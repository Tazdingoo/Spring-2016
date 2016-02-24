package edu.nyu.cs9053.homework4.hierarchy;

public class Armatocereus extends Cactoideae {
	//property of this class, set as a prime number
	private static final int TRIBE_NUMBER = 11;
	public Armatocereus(String name, String location){
		super(name, location);
	}
	@Override
	public boolean hasEdibleFruit() {
		return false;
	}
	@Override
	public boolean equals(Object o){
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass()!=o.getClass())) {
			return false;
		}
		Armatocereus that = (Armatocereus)o;
		if ((getName() == null)&&(that.getName() != null)) {
			return false;
		}
		if ((getName() != null)&& !(getName().equals(that.getName()))) {
			return false;
		}
		return ((getLocation() == null) ? (that.getLocation() == null) : (getLocation().equals(that.getLocation())));
	}
	@Override
	public int hashCode() {
		int hashReuslt = (getName() != null)? getName().hashCode() : 0;
		hashReuslt = TRIBE_NUMBER*hashReuslt + ((getLocation() != null)? getLocation().hashCode() : 0);
		return hashReuslt;
	}
}