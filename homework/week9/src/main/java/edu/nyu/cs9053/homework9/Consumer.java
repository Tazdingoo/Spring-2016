package edu.nyu.cs9053.homework9;

/**
 * User: blangel
 * Date: 4/3/16
 * Time: 2:10 PM
 */
public interface Consumer {

    /**
     * Removes a {@link Seltzer} from {@code from} only if there's seltzers within it.
     *
     * @param from to extract a {@link Seltzer} if any
     * @return the extracted {@link Seltzer} or null if none could be extracted
     */
    Seltzer consume(VendingMachine from);

}
