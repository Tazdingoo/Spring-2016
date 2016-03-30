package edu.nyu.cs9053.homework7.inventory;

public class DigitalCamera extends Camera {
	private final Integer zoom;

	public DigitalCamera(Double price, Integer zoom) {
		super(price);
		this.zoom = zoom;
	}

	public Integer getZoom() {
		return zoom;
	}
}