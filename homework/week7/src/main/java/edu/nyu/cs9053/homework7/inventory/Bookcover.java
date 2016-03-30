package edu.nyu.cs9053.homework7.inventory;

public class Bookcover<B extends Book> implements Item{
	private final Double price;
	private final B book;

	public Bookcover(Double price, B book) {
		this.price = price;
		this.book = book;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	public B getBook() {
		return book;
	}
}