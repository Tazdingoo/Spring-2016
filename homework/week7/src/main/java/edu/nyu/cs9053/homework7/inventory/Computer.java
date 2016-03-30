package edu.nyu.cs9053.homework7.inventory;

public class Computer extends Electronic {
	private final Double ghz;

	public Computer(Double price, Double ghz) {
		super(price);
		this.ghz = ghz;
	}

	public Double getGhz() {
		return ghz;
	}

}