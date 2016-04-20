package edu.nyu.cs9053.homework10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * User: blangel
 * Date: 4/12/16
 * Time: 7:27 PM
 */
public class ModernFortification extends FortificationConcurrencyFactorProvider implements Fortification<ExecutorService> {

	private final ExecutorService executor;

	public ModernFortification(int concurrencyFactor) {
		super(concurrencyFactor);
		executor = Executors.newFixedThreadPool(concurrencyFactor);
	}

	@Override
	public void handleAttack(final AttackHandler handler) {
		//
		for (int i = 0; i < getConcurrencyFactor(); i++) {
			executor.submit(new Runnable(){
				@Override
				public void run() {
					handler.soldiersReady();
				}
			});
		}
		
	}

	@Override
	public void surrender() {
		//
		executor.shutdown();
	}
}
