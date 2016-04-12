package edu.nyu.cs9053.homework9;

/**
 * User: blangel
 * Date: 4/3/16
 * Time: 2:16 PM
 */
public interface Producer {

    /**
     * Creates a new {@link Seltzer} and places it into {@code into} only if there's available room left within it
     *
     * @param into to place the new {@link Seltzer} if any
     * @return the produced {@link Seltzer} or null if none could be placed
     */
    Seltzer produce(VendingMachine into);

}
