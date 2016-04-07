package edu.nyu.cs9053.homework9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: blangel
 * Date: 4/3/16
 * Time: 2:14 PM
 */
public class VendingMachineDispenser {

    private static final int MAX_INITIAL_SELTZERS = 1000;

    public static void main(String[] args) {
        List<Seltzer> seltzers = seed();
        VendingMachine vendingMachine = new VendingMachine(seltzers);
        Producer producer = ProducerConsumerFactory.createProducer();
        Consumer consumer = ProducerConsumerFactory.createConsumer();
        VendingMachineDispenser dispenser = new VendingMachineDispenser(vendingMachine, producer, consumer);
        dispenser.start();
    }

    private static List<Seltzer> seed() {
        Random random = new Random();
        int capacity = random.nextInt(MAX_INITIAL_SELTZERS) + 1;
        Flavor[] flavors = Flavor.values();
        List<Seltzer> initial = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            initial.add(new Seltzer(flavors[random.nextInt(flavors.length)]));
        }
        return initial;
    }

    private final VendingMachine vendingMachine;

    private final Producer producer;

    private final Consumer consumer;

    public VendingMachineDispenser(VendingMachine vendingMachine, Producer producer, Consumer consumer) {
        this.vendingMachine = vendingMachine;
        this.producer = producer;
        this.consumer = consumer;
    }

    private void start() {
        Thread producerThread = new Thread(new Runnable() {
            @Override public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    Seltzer seltzer = producer.produce(vendingMachine);
                    if (seltzer != null) {
                        System.out.printf("Produced %s%n", seltzer);
                    }
                }
            }
        });
        Thread consumerThread = new Thread(new Runnable() {
            @Override public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    Seltzer seltzer = consumer.consume(vendingMachine);
                    if (seltzer != null) {
                        System.out.printf("Consumed %s%n", seltzer);
                    }
                }
            }
        });
        producerThread.start();
        consumerThread.start();
        while (producerThread.isAlive() && consumerThread.isAlive()) {
            Thread.yield();
        }
        // failure, orderly shutdown and error message print
        producerThread.interrupt();
        consumerThread.interrupt();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
        System.err.printf("Fail! Producer or Consumer not implemented properly");
        System.exit(1);
    }

}
