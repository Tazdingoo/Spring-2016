package edu.nyu.cs9053.homework7.inventory;

import java.util.Collection;
import java.util.ArrayList;

public class BookShelf<T extends Book> implements Item {
	private final Double price;
	private final Collection<T> books;

	public BookShelf(Double price) {
		this.price = price;
		books = new ArrayList<>();
	}

	@Override
	public Double getPrice() {
		return price;
	}

	public Collection<T> getBooks() {
		return books;
	}

	public void addBooks(T book) {
		books.add(book);
	}
}