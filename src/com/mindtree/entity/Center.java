
package com.mindtree.entity;

public class Center {
	private String placename;
	private int strength;
	private int centerid;

	public Center() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Center(String placename, int strength, int centerid) {
		super();
		this.placename = placename;
		this.strength = strength;
		this.centerid = centerid;
	}

	public String getPlacename() {
		return placename;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + centerid;
		result = prime * result + ((placename == null) ? 0 : placename.hashCode());
		result = prime * result + strength;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Center other = (Center) obj;
		if (centerid != other.centerid)
			return false;
		if (placename == null) {
			if (other.placename != null)
				return false;
		} else if (!placename.equals(other.placename))
			return false;
		if (strength != other.strength)
			return false;
		return true;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getCenterid() {
		return centerid;
	}

	public void setCenterid(int centerid) {
		this.centerid = centerid;
	}

}
