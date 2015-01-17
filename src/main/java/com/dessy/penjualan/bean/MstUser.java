package com.dessy.penjualan.bean;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dessy.penjualan.usertrail.EntityUserTrail;


@Entity
@Table(name="MST_USER")
public class MstUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="VUSERNAME", length=20, nullable=false)
	private String vusername;
	
	@Column(name="VPASSWORD", length=64, nullable=false) 
	private String vpassword;
	
	@Column(name="VSTAT", length=1)
	private String vstat;
	
	@OneToMany(mappedBy="trioMstuser")
	private Set<MstUserRole> trioMstuserroleSet;
	
	public MstUser() {
		
	}
	
	public MstUser(String vusername) {
		this.vusername = vusername;
	}
	
	public String getVusername() {
		return vusername;
	}

	public void setVusername(String vusername) {
		this.vusername = vusername;
	}

	public Set<MstUserRole> getTrioMstuserroleSet() {
		return trioMstuserroleSet;
	}

	public void setTrioMstuserroleSet(Set<MstUserRole> trioMstuserroleSet) {
		this.trioMstuserroleSet = trioMstuserroleSet;
	}

	public String getVpassword() {
		return vpassword;
	}

	public void setVpassword(String vpassword) {
		this.vpassword = vpassword;
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
		result = prime * result
				+ ((vusername == null) ? 0 : vusername.hashCode());
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
		MstUser other = (MstUser) obj;
		if (vusername == null) {
			if (other.vusername != null)
				return false;
		} else if (!vusername.equals(other.vusername))
			return false;
		return true;
	}

}

