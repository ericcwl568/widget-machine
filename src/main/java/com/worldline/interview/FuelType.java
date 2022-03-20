package com.worldline.interview;

public enum FuelType {
	PETROL(9.00), DIESEL(12.00), WOOD(4.35), COAL(5.65);

	private double cost;

	private FuelType(double cost) {
		this.cost = cost;
	}

	public double getFuelCost() {
		return cost;
	}
}
