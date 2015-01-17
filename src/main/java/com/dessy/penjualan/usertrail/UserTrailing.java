package com.dessy.penjualan.usertrail;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class UserTrailing implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="VCREABY", length=20)
	private String vcreaby;

	@Column(name="DCREA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dcrea;

	@Column(name="VMODIBY", length=20)
	private String vmodiby;

	@Column(name="DMODI")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dmodi;

	public String getVcreaby() {
		return vcreaby;
	}

	public void setVcreaby(String vcreaby) {
		this.vcreaby = vcreaby;
	}

	public Date getDcrea() {
		return dcrea;
	}

	public void setDcrea(Date dcrea) {
		this.dcrea = dcrea;
	}

	public String getVmodiby() {
		return vmodiby;
	}

	public void setVmodiby(String vmodiby) {
		this.vmodiby = vmodiby;
	}

	public Date getDmodi() {
		return dmodi;
	}

	public void setDmodi(Date dmodi) {
		this.dmodi = dmodi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dcrea == null) ? 0 : dcrea.hashCode());
		result = prime * result + ((dmodi == null) ? 0 : dmodi.hashCode());
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
		UserTrailing other = (UserTrailing) obj;
		if (dcrea == null) {
			if (other.dcrea != null)
				return false;
		} else if (!dcrea.equals(other.dcrea))
			return false;
		if (dmodi == null) {
			if (other.dmodi != null)
				return false;
		} else if (!dmodi.equals(other.dmodi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioUserTrailing [vcreaby=" + vcreaby + ", dcrea=" + dcrea
				+ ", vmodiby=" + vmodiby + ", dmodi=" + dmodi + "]";
	}
	
}
