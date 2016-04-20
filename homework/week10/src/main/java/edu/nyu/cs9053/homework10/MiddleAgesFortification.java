package edu.nyu.cs9053.homework10;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * User: blangel
 * Date: 4/12/16
 * Time: 7:28 PM
 */
public class MiddleAgesFortification extends FortificationConcurrencyFactorProvider implements Fortification<Thread> {

	private final Thread threads[];

	private final BlockingQueue<Runnable> blockingQueue;


	public MiddleAgesFortification (int concurrencyFactor) {
		super(concurrencyFactor);
		threads = new Thread[concurrencyFactor];
		blockingQueue = new LinkedBlockingQueue<Runnable>(concurrencyFactor);
		this.fillInThreads();

	}

	public void fillInThreads() {
		for (int i = 0; i<getConcurrencyFactor(); i++) {
			threads[i] = new Thread(new Runnable(){
				@Override
				public void run() {
					while (!Thread.currentThread().isInterrupted()){
                        					try {
                            					Runnable queueItem = blockingQueue.take();
                                					queueItem.run();
                        					} catch (InterruptedException ie) {
                            					Thread.currentThread().interrupt();
                        					}
					}
						
				}
			});
		}

		for (Thread thread: threads) {
			thread.start();
		}
	}

	@Override
	public void handleAttack(final AttackHandler handler) {
		try{
			blockingQueue.put(new Runnable() {
				@Override
				public void run() {
					handler.soldiersReady();
				}
			});
		}catch (InterruptedException ie) {
                            	ie.printStackTrace();
                        	}
		
	}

	@Override
	public void surrender() {
		//
		for (Thread thread : threads) {
            			if (thread != null) {
                		thread.interrupt();
            			}
        		}
	}

}
