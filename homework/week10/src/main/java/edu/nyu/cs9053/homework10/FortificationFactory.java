package edu.nyu.cs9053.homework10;

import java.util.concurrent.ExecutorService;
/**
 * User: blangel
 * Date: 4/12/16
 * Time: 7:31 PM
 */
public class FortificationFactory {

    public static Fortification<Thread> createMiddleAges(int concurrencyFactor) {
        return new MiddleAgesFortification(concurrencyFactor);
    }

    public static Fortification<ExecutorService> createModern(final int concurrencyFactor) {
        return new ModernFortification(concurrencyFactor);
    }

}
