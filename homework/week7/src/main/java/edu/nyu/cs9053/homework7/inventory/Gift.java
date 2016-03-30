package edu.nyu.cs9053.homework7.inventory;

public class Gift<T extends Item> implements Item {
	private final Double price;
	private final WrappedItem<T> item;

	public Gift(WrappedItem<T> item) {
		this.price = item.getPrice();
		this.item = item;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	public WrappedItem<T> getItem() {
		return item;
	}
}