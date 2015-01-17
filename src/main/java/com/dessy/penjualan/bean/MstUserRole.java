package com.dessy.penjualan.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dessy.penjualan.usertrail.EntityUserTrail;



@Entity
@Table(name="MST_USER_ROLE")
public class MstUserRole extends EntityUserTrail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MstUserRolePK trioMstuserrolePK;
	
	@Column(name="VSTAT", length=1)
	private String vstat;
	
	@ManyToOne
	@JoinColumn(name="VUSERNAME", referencedColumnName="VUSERNAME", insertable=false, updatable=false)
	private MstUser trioMstuser;
	
	@ManyToOne
	@JoinColumn(name="VROLEID", referencedColumnName="VROLEID", insertable=false, updatable=false)
	private MstRole trioMstrole;
	
	public MstUserRole() {
		this.trioMstuserrolePK = new MstUserRolePK();
		this.trioMstrole = new MstRole();
		this.trioMstuser = new MstUser();
	}
	
	public MstUserRole(String vusername, String vroleid) {
		this.trioMstuserrolePK = new MstUserRolePK(vusername, vroleid);
	}

	public MstRole getTrioMstrole() {
		return trioMstrole;
	}

	public void setTrioMstrole(MstRole trioMstrole) {
		this.trioMstrole = trioMstrole;
	}

	public MstUser getTrioMstuser() {
		return trioMstuser;
	}

	public void setTrioMstuser(MstUser trioMstuser) {
		this.trioMstuser = trioMstuser;
	}

	public MstUserRolePK getTrioMstuserrolePK() {
		return trioMstuserrolePK;
	}

	public void setTrioMstuserrolePK(MstUserRolePK trioMstuserrolePK) {
		this.trioMstuserrolePK = trioMstuserrolePK;
	}

	public String getVstat() {
		return vstat;
	}

	public void setVstat(String vstat) {
		this.vstat = vstat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((trioMstuserrolePK == null) ? 0 : trioMstuserrolePK
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MstUserRole other = (MstUserRole) obj;
		if (trioMstuserrolePK == null) {
			if (other.trioMstuserrolePK != null)
				return false;
		} else if (!trioMstuserrolePK.equals(other.trioMstuserrolePK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstuserrole [trioMstuserrolePK=" + trioMstuserrolePK + "]";
	}
	
}

