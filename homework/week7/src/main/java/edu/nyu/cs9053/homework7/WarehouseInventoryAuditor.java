package edu.nyu.cs9053.homework7;

import java.util.Iterator;
import edu.nyu.cs9053.homework7.inventory.*;
/**
 * User: blangel
 * Date: 10/13/14
 * Time: 1:58 PM
 */
public class WarehouseInventoryAuditor {

    // TODO - create a method to print the individual prices of a Bin of any Item type
    public static void itemBinPrinter(Bin<? extends Item> itemBin) {
    	if (itemBin == null) {
    		throw new IllegalArgumentException();
    	}
    	
    	for (Iterator<? extends Item> iter = itemBin.iterator(); iter.hasNext(); ) {
    		Double price = iter.next().getPrice();
    		if (price == null) {
    			throw new IllegalArgumentException();
    		}
    		System.out.println(price);
    	}
    }
    // TODO - create a method to print the individual prices of a Bin of any Electronic types
    public static void electronicBinPrinter(Bin<? extends Electronic> electronicBin) {
    	itemBinPrinter(electronicBin);
    }
    // TODO - create a method to print the individual prices of a Bin of any Book types
    public static void bookBinPrinter(Bin<? extends Book> bookBin) {
    	itemBinPrinter(bookBin);
    }

}
