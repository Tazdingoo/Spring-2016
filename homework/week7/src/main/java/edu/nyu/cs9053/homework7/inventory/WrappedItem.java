package edu.nyu.cs9053.homework7.inventory;

public class WrappedItem<T extends Item> implements Item {
	private final T item;
	private final Double price;
	private static final Double WRAP_PRICE = 10d; 

	public WrappedItem(T item) {
		this.price = item.getPrice() + WRAP_PRICE;
		this.item = item;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	public T unwrap() {
		return item;
	}
}