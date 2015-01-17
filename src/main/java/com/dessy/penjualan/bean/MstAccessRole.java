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
@Table(name="MST_ACCESS_ROLE") 
public class MstAccessRole extends EntityUserTrail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MstAccessRolePK trioMstaccessrolePK;
	@Column(name="VSTAT", length=1)
	private String vstat;
	
	@ManyToOne
	@JoinColumn(name="VMENUID", referencedColumnName="VMENUID", insertable=false, updatable=false)
	private MstMenu trioMstmenu;
	
	@ManyToOne
	@JoinColumn(name="VROLEID", referencedColumnName="VROLEID", insertable=false, updatable=false)
	private MstRole trioMstrole;
	
	public MstAccessRole() {
		this.trioMstaccessrolePK = new MstAccessRolePK();
		this.trioMstmenu = new MstMenu();
		this.trioMstrole = new MstRole();
	}
	
	public MstAccessRole(String vroleid, String vmenuid) {
		this.trioMstaccessrolePK = new MstAccessRolePK(vroleid, vmenuid);
	}

	public MstRole getTrioMstrole() {
		return trioMstrole;
	}

	public void setTrioMstrole(MstRole trioMstrole) {
		this.trioMstrole = trioMstrole;
	}

	public MstMenu getTrioMstmenu() {
		return trioMstmenu;
	}

	public void setTrioMstmenu(MstMenu trioMstmenu) {
		this.trioMstmenu = trioMstmenu;
	}

	public MstAccessRolePK getTrioMstaccessrolePK() {
		return trioMstaccessrolePK;
	}

	public void setTrioMstaccessrolePK(MstAccessRolePK trioMstaccessrolePK) {
		this.trioMstaccessrolePK = trioMstaccessrolePK;
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
				+ ((trioMstaccessrolePK == null) ? 0 : trioMstaccessrolePK
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
		MstAccessRole other = (MstAccessRole) obj;
		if (trioMstaccessrolePK == null) {
			if (other.trioMstaccessrolePK != null)
				return false;
		} else if (!trioMstaccessrolePK.equals(other.trioMstaccessrolePK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrioMstaccessrole [trioMstaccessrolePK=" + trioMstaccessrolePK
				+ "]";
	}
	
}
