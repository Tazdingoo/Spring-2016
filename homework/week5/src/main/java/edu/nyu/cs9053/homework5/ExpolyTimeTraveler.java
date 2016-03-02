package edu.nyu.cs9053.homework5;

public class ExpolyTimeTraveler extends AbstractTimeTraveler {
	private final Double decayConstant;
	public ExpolyTimeTraveler(String name, Double remainingYearsOfTravel, Double decayConstant) {
		super(name, remainingYearsOfTravel);
		this.decayConstant = decayConstant;
	}

	@Override
	public boolean isExhausted() {
		return (getRemainingYearsOfTravel() < 0.001)? true : false; 
	}

	@Override
	public void adjust(Time unit, int amount, boolean ahead) {
		Double yearsToTravel;
		if (unit == Time.Days) {
			yearsToTravel = (Double)(amount/DAYS_IN_YEAR);
		}
		else {
			yearsToTravel = (Double)(amount/HOURS_IN_YEAR);
		}
		updateRemainingYearsOfTravel(getRemainingYearsOfTravel() * Math.exp(-1 * decayConstant * yearsToTravel));
	}
}