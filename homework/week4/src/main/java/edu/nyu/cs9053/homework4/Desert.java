package edu.nyu.cs9053.homework4;
public enum Desert {
	Antarctic (14200000),
	Arctic (13900000),
	Sahara (9100000),
	Arabian (2600000),
	Gobi (1300000),
	Patagonian (670000),
	GreatVictoria (647000),
	Kalahari (570000),
	GreatBasin (490000),
	Syrian (490000);

	private final Integer areaKm;

	private Desert(Integer areaKm) {
		this.areaKm = areaKm;
	}

	public Integer getAreaKm() {
		return areaKm;
	}

	public static void printArea(Desert ... names) {
		if (names == null || names.length == 0) {
			System.out.println("Invalid input.");
			return;
       		}
		for (Desert d: names) {
			System.out.printf("Area of %s is %d%n", d.name(), d.getAreaKm());
		}
	}
}