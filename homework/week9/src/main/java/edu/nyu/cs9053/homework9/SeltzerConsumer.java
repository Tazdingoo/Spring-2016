package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

public class SeltzerConsumer implements Consumer {
	private final Semaphore semaphore;

	public SeltzerConsumer(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public Seltzer consume(VendingMachine from) {
		if (from == null) {
			throw new IllegalArgumentException();
		}
		try{
			semaphore.acquire();
			if (from.isEmpty()) {
				return null;
			}
			return from.remove();
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(ie);
		} finally {
			semaphore.release();
		}
	}
}