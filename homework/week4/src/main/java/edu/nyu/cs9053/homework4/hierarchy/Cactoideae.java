package edu.nyu.cs9053.homework4.hierarchy;

public abstract  class Cactoideae extends Cactus {
	private static final int TRIBE_NUMBER = 2;
	public Cactoideae(String name, String location) {
		super(name, location);
	}
	//all genuses in cactoideae subfamily has spine and flower
	@Override
	public LeafType getLeafType() {
		return LeafType.Spine;
	}

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
		Cactoideae that = (Cactoideae)o;
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