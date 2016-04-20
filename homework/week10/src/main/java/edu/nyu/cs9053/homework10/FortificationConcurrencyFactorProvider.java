package edu.nyu.cs9053.homework10;

public abstract class FortificationConcurrencyFactorProvider implements ConcurrencyFactorProvider {
	
	private final int concurrencyFactor;

	protected FortificationConcurrencyFactorProvider(int concurrencyFactor) {
		this.concurrencyFactor = concurrencyFactor;
	}

	public int getConcurrencyFactor() {
		return concurrencyFactor;
	}
}