package edu.nyu.cs9053.homework9;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SeltzerProducer implements Producer {
	private final Semaphore semaphore;

	public SeltzerProducer(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override 
	public Seltzer produce(VendingMachine into) {
		if (into == null) {
			throw new IllegalArgumentException();
		}
		try{
			semaphore.acquire();
			if (into.atCapacity()) {
				return null;
			}
			Random random = new Random();
			Flavor[] flavors = Flavor.values();
			Seltzer newSeltzer = new Seltzer(flavors[random.nextInt(flavors.length)]);
			into.add(newSeltzer);
			return newSeltzer;
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(ie);
		} finally {
			semaphore.release();
		}
	}
}