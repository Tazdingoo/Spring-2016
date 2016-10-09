package edu.nyu.cs9053.homework8;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * User: blangel
 * Date: 10/14/14
 * Time: 6:47 PM
 */
public class Sets {


    public static <T> Set<T> union(Set<T> left, Set<T> right) {
	// TODO
    	Set<T> unionSet = new HashSet<>(left.size()+right.size(), 1.0f);
    	unionSet.addAll(left);
    	unionSet.addAll(right);
    	return unionSet;
    }

    public static <T> Set intersection(Set<T> left, Set<T> right) {
	// TODO
    	Set<T> intersectionSet = new HashSet<>((left.size() < right.size() ? left.size() : right.size()), 1.0f);
    	intersectionSet.addAll(left);
    	intersectionSet.retainAll(right);
    	return intersectionSet;
    }

    public static <T> Set symmetricDifference(Set<T> left, Set<T> right) {
	// TODO
    	Set<T> symmetricDifferenceSet = new HashSet<>(left.size()+right.size(), 1.0f);
    	symmetricDifferenceSet.addAll(Sets.union(left, right));
    	symmetricDifferenceSet.removeAll(Sets.intersection(left, right));
    	return symmetricDifferenceSet;
    }

}
