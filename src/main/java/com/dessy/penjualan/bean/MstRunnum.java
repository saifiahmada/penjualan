package com.dessy.penjualan.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MST_RUNNUM")
public class MstRunnum  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MstRunnumPK mstRunnumPK;
	
	@Column(name="DESCRIPTION", length=30)
	private String description;
	
	@Column(name="RUNNUM", length=11)
	private int runnum;
	
	public MstRunnum() {
		this.mstRunnumPK = new MstRunnumPK();
	}
	
	public MstRunnum(String idDoc, String reseter) {
		this.mstRunnumPK = new MstRunnumPK(idDoc, reseter);
	}

	public MstRunnumPK getMstRunnumPK() {
		return mstRunnumPK;
	}

	public void setMstrunnumPK(MstRunnumPK mstRunnumPK) {
		this.mstRunnumPK = mstRunnumPK;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRunnum() {
		return runnum;
	}

	public void setRunnum(int runnum) {
		this.runnum = runnum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mstRunnumPK == null) ? 0 : mstRunnumPK.hashCode());
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
		MstRunnum other = (MstRunnum) obj;
		if (mstRunnumPK == null) {
			if (other.mstRunnumPK != null)
				return false;
		} else if (!mstRunnumPK.equals(other.mstRunnumPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MstRunnum [mstrunnumPK=" + mstRunnumPK + "]";
	}

	
	
}

