package edu.nyu.cs9053.homework4.hierarchy;

public class Pereskia extends Cactus {
	//property of this class, set as a prime number
	private static final int TRIBE_NUMBER = 5;
	public Pereskia(String name, String location) {
		super(name, location);
	}
	//there is no other genus that belongs to the subfamily same with pereskia, so pereskia becomes a subfamily itself, which has leaves, flower and it's edible
	@Override
	public LeafType getLeafType() {
		return LeafType.Leaf;
	}
	@Override
	public boolean isFlowering() {
		return true;
	}
	@Override
	public boolean hasEdibleFruit() {
		return true;
	}

	@Override
	public boolean equals(Object o){
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass()!=o.getClass())) {
			return false;
		}
		Pereskia that = (Pereskia)o;
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