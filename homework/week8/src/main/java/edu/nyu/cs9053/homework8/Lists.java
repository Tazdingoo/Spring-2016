package edu.nyu.cs9053.homework8;

import java.util.List;
import java.util.Collections;

/**
 * User: blangel
 * Date: 10/14/14
 * Time: 6:47 PM
 */
public class Lists {

    public static <T> List shuffle(List<T> list) {
	// TODO
    	Collections.shuffle(list);
    	return list;
    }

    public static <T> boolean deepEquals(List<T> left, List<T> right) {
    	if (left == right) {
    		return true;
    	}
        if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
    	if (left.size() != right.size()) {
    		return false;
    	}
    	for (int index = 0; index < left.size(); index++) {
    		if (!left.get(index).equals(right.get(index))) {
    			return false;
    		}
    	}
    	return true;

        
    }

}
