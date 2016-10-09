package edu.nyu.cs9053.homework11.network;

import edu.nyu.cs9053.homework11.game.Difficulty;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;

/**
 * User: blangel
 * Date: 11/15/15
 * Time: 3:31 PM
 *
 * A NIO implementation of a NetworkGameProvider.
 *
 * The server takes the following commands:
 * <pre>
 *     foes Difficulty
 * </pre>
 * <pre>
 *     move
 * </pre>
 * where the String "foes Easy" would be a call to {@linkplain NetworkGameProvider#getRandomNumberOfNextFoes(String)}
 * with "Easy"
 * and a call using String "move" would be a call to {@linkplain NetworkGameProvider#getRandomNextMove()}
 */
public class GameServer implements NetworkGameProvider, Runnable {

    public static final String SERVER_HOST = "localhost";

    public static final int SERVER_PORT = 8080;

    private static final Random RANDOM = new Random();

    private static final int BUFFER_SIZE = 4096;

    private static final Charset CHARSET = Charset.forName("UTF-8");

    private final Selector selector;

    private final ServerSocketChannel serverSocketChannel;

    private final ByteBuffer serverBuffer;

    private final Map<SocketChannel, ByteBuffer> clientBufferMap;

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
        server.run();
    }

    public GameServer() throws IOException {
        serverBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        clientBufferMap = new HashMap<>();
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new java.net.InetSocketAddress(SERVER_HOST, SERVER_PORT));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
    @Override
    public String getRandomNumberOfNextFoes(String difficulty) {
        if (difficulty == null) {
            return String.valueOf(RANDOM.nextInt(Difficulty.Easy.getLevel() + 1));
        }
        for (Difficulty d: Difficulty.values()) {
            if (d.name().equals(difficulty)) {
                return String.valueOf(RANDOM.nextInt(d.getLevel() + 1));
            }
        }
        return String.valueOf(RANDOM.nextInt(Difficulty.Easy.getLevel() + 1));

    }

    @Override
    public String getRandomNextMove() {
        int move = RANDOM.nextInt(40);
        if (move < 10) {
            return "Up";
        }
        if (move >= 10 && move < 20) {
            return "Down";
        }
        if (move == 20) {
            return "Right";
        }
        else {
            return "Left";
        }
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int readyChannels = selector.select();
                if (readyChannels == 0) {
                    continue;
                }
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    try {
                        SelectionKey key = keyIterator.next();
                        if (key.isAcceptable()) {
                            SocketChannel clientChannel = serverSocketChannel.accept();
                            clientChannel.configureBlocking(false);
                            clientChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                            clientBufferMap.put(clientChannel, ByteBuffer.allocate(BUFFER_SIZE));
                        }
                        else if (key.isReadable()) {
                            SocketChannel clientChannel = (SocketChannel)key.channel();
                            serverBuffer.clear();
                            try {
                                int read = clientChannel.read(serverBuffer);
                                String dataReceived = new String(serverBuffer.array(), CHARSET);
                                ByteBuffer writeBuffer = clientBufferMap.get(clientChannel);
                                if (dataReceived.substring(0, 7).equals("getMove")) {

                                    writeBuffer.put(ByteBuffer.wrap(getRandomNextMove().getBytes(CHARSET)));
                                    writeBuffer.put((byte) '\n');
                                } else {
                                    writeBuffer.put(ByteBuffer.wrap(getRandomNumberOfNextFoes(dataReceived).getBytes(CHARSET)));
                                    writeBuffer.put((byte) '\n');
                                }
                            }catch (Exception e) {
                                clientBufferMap.remove(clientChannel);
                                key.cancel();
                            }
                        }
                        else if (key.isWritable()) {
                            SocketChannel clientChannel = (SocketChannel) key.channel();
                            ByteBuffer writeBuffer = clientBufferMap.get(clientChannel);
                            if (writeBuffer == null || writeBuffer.position() == 0) {
                                continue;
                            }
                            writeBuffer.flip();
                            clientChannel.write(writeBuffer);
                            writeBuffer.clear();
                        }
                    }
                    finally {
                        keyIterator.remove();
                    }
                }
            }
            catch (IOException ioe) {
                System.out.printf("Failed to run - %s%n", ioe.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }


}
