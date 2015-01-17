package com.dessy.penjualan.usertrail;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityUserTrail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Embedded
	protected UserTrailing userTrailing;

	public UserTrailing getUserTrailing() {
		if (this.userTrailing == null)
			this.userTrailing = new UserTrailing();
		return userTrailing;
	}

	public void setUserTrailing(UserTrailing userTrailing) {
		this.userTrailing = userTrailing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userTrailing == null) ? 0 : userTrailing.hashCode());
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
		EntityUserTrail other = (EntityUserTrail) obj;
		if (userTrailing == null) {
			if (other.userTrailing != null)
				return false;
		} else if (!userTrailing.equals(other.userTrailing))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioEntityUserTrail [userTrailing=" + userTrailing + "]";
	}
	
}
