package edu.nyu.cs9053.homework5;

public class DoublyTimeTraveler extends AbstractTimeTraveler {
	public DoublyTimeTraveler(String name, Double remainingYearsOfTravel) {
		super(name, remainingYearsOfTravel);
	}

	@Override
	protected Double travelCost(Time unit, int amount) {
		Double yearsToTravel;
		if (unit == Time.Days) {
			yearsToTravel = (Double)(amount/DAYS_IN_YEAR);
		}
		else {
			yearsToTravel = (Double)(amount/HOURS_IN_YEAR);
		}
		return (getRemainingYearsOfTravel() > 2*yearsToTravel)? 2*yearsToTravel : getRemainingYearsOfTravel(); 
	}


	@Override
	public void adjust(Time unit, int amount, boolean ahead) {
		updateRemainingYearsOfTravel(getRemainingYearsOfTravel() - travelCost(unit, amount));
	}
}