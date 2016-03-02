package edu.nyu.cs9053.homework5;

public class LinearlyTimeTraveler extends AbstractTimeTraveler {
	public LinearlyTimeTraveler (String name, Double remainingYearsOfTravel) {
		super(name, remainingYearsOfTravel);
	}

	@Override
	public void adjust(Time unit, int amount, boolean ahead) {
		updateRemainingYearsOfTravel(getRemainingYearsOfTravel() - travelCost(unit, amount));
	}
}