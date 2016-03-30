package edu.nyu.cs9053.homework7.inventory;

public class WrappedElectronic<T extends Electronic> extends WrappedItem<T>{
	private static final Double WRAP_PRICE = 50d;
	public WrappedElectronic(T item) {
		super(item);
	} 
}