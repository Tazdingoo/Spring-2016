package edu.nyu.cs9053.homework10;

/**
 * User: blangel
 * Date: 4/12/16
 * Time: 7:19 PM
 */
public interface AttackHandler {

    /**
     * Invoked when the attack can be fought off
     * Note, this should only be invoked if the calling thread is actually able to ward off the attack.
     */
    void soldiersReady();

}
