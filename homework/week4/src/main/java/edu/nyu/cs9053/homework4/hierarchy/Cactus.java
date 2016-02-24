package edu.nyu.cs9053.homework4.hierarchy;

public abstract  class Cactus  {
	private static final int DEFAULT_TRIBE_NUMBER = 31;
	private final String name;
	private String location;
	protected Cactus (String name) {
		this(name, null);
	}
	protected Cactus (String name, String location) {
		this.name = name;
		this.location = location;
	}
	public abstract boolean isFlowering();
	public abstract LeafType getLeafType();
	public abstract boolean hasEdibleFruit();

	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}

	@Override
	public boolean equals(Object o){
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass()!=o.getClass())) {
			return false;
		}
		Cactus that = (Cactus)o;
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
		hashReuslt = DEFAULT_TRIBE_NUMBER*hashReuslt + ((getLocation() != null)? getLocation().hashCode() : 0);
		return hashReuslt;
	}
}
