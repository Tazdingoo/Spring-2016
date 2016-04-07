package edu.nyu.cs9053.homework9;

import java.util.List;

/**
 * User: blangel
 * Date: 4/3/16
 * Time: 2:11 PM
 */
public class VendingMachine {

    private final List<Seltzer> seltzers;

    private final int capacity;

    public VendingMachine(List<Seltzer> seltzers) {
        this.seltzers = seltzers;
        this.capacity = seltzers.size();
    }

    public boolean atCapacity() {
        return (seltzers.size() == capacity);
    }

    public boolean isEmpty() {
        return seltzers.isEmpty();
    }

    public void add(Seltzer seltzer) {
        this.seltzers.add(seltzer);
        if (this.seltzers.size() > capacity) {
            throw new UnsupportedOperationException();
        }
    }

    public Seltzer remove() {
        try {
            return this.seltzers.remove(0);
        } catch (IndexOutOfBoundsException ioobe) {
            throw new UnsupportedOperationException();
        }
    }

}
