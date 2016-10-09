package edu.nyu.cs9053.homework7;

import java.util.Iterator;
import edu.nyu.cs9053.homework7.inventory.*;
/**
 * User: blangel
 * Date: 10/13/14
 * Time: 1:57 PM
 */
public class Warehouse {

    private static void copy(Bin<? extends Item> from, Bin<? super Item> into) {
        if (from == null || into ==null) {
            throw new IllegalArgumentException();
        }
        for (Iterator<? extends Item> iter = from.iterator(); iter.hasNext(); ) {
            into.add(iter.next());
        }

    }

    // TODO - implement such that the warehouse can hold any Bin of Item type

    private final Bin<? extends Item> items;

    public Warehouse(Bin<? extends Item> items) {
        this.items = items;
    }

    public Bin getItems() {
        return items;
    }

    public Warehouse copy() {
        // TODO - make a new Bin copying the values from `items` into a new Bin using the 'copy' method below
        Bin<Item> copiedBin = new Bin<>();
        // TODO - change to return a copied bin
        copy(items, copiedBin);
        Warehouse copiedWarehouse = new Warehouse(copiedBin);
        return copiedWarehouse;
    }

}
