package edu.nyu.cs9053.homework7.inventory;

public class WrappedBook<T extends Book> extends WrappedItem<T> {
	private static final Double WRAP_PRICE = 15d; 
	public WrappedBook(T item) {
		super(item);
	}
}