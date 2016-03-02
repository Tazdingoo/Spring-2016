package edu.nyu.cs9053.homework5;

public abstract class AbstractTimeTraveler implements TimeTraveler {
	protected static final Double DAYS_IN_YEAR = 365d;
	protected static final Double HOURS_IN_YEAR = 365d*24d;
	private final String name;
	private Double remainingYearsOfTravel;
	AbstractTimeTraveler(String name, Double remainingYearsOfTravel) {
		this.name = name;
		this.remainingYearsOfTravel = remainingYearsOfTravel;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Double getRemainingYearsOfTravel() {
		return remainingYearsOfTravel;
	}

	public void updateRemainingYearsOfTravel(Double remainingYearsOfTravel) {
		this.remainingYearsOfTravel = remainingYearsOfTravel;
	}

	protected Double travelCost(Time unit, int amount) {
		Double yearsToTravel;
		if (unit == Time.Days) {
			yearsToTravel = (Double)(amount/DAYS_IN_YEAR);
		}
		else {
			yearsToTravel = (Double)(amount/HOURS_IN_YEAR);
		}
		return (getRemainingYearsOfTravel() > yearsToTravel)? yearsToTravel : getRemainingYearsOfTravel(); 
	}
	@Override
	public boolean isExhausted() {
		return (getRemainingYearsOfTravel() == 0)? true : false; 
	}
}