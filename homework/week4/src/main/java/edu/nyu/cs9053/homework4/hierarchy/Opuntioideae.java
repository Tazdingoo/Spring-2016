package edu.nyu.cs9053.homework4.hierarchy;

public abstract class Opuntioideae extends Cactus {
	private static final int TRIBE_NUMBER = 3;
	public Opuntioideae(String name, String location) {
		super(name, location);
	}
	//all genuses in opuntioideae subfamily has flower
	@Override
	public boolean isFlowering() {
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
		Opuntioideae that = (Opuntioideae)o;
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