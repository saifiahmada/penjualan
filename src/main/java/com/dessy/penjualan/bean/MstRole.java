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
@Table(name="MST_ROLE")
public class MstRole extends EntityUserTrail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="VROLEID", length=20, nullable=false)
	private String vroleid;
	
	@Column(name="VROLENAME") 
	private String vrolename;
	
	@OneToMany(mappedBy="trioMstrole") 
	private Set<MstAccessRole> trioMstaccessroleSet;
	
	@OneToMany(mappedBy="trioMstrole")
	private Set<MstUserRole> trioMstuserroleSet;
	
	public MstRole() {
		
	}
	
	public MstRole(String vroleid) {
		this.vroleid = vroleid;
	}

	public String getVroleid() {
		return vroleid;
	}

	public void setVroleid(String vroleid) {
		this.vroleid = vroleid;
	}

	public Set<MstAccessRole> getTrioMstaccessroleSet() {
		return trioMstaccessroleSet;
	}

	public void setTrioMstaccessroleSet(Set<MstAccessRole> trioMstaccessroleSet) {
		this.trioMstaccessroleSet = trioMstaccessroleSet;
	}

	public String getVrolename() {
		return vrolename;
	}

	public void setVrolename(String vrolename) {
		this.vrolename = vrolename;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((vroleid == null) ? 0 : vroleid.hashCode());
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
		MstRole other = (MstRole) obj;
		if (vroleid == null) {
			if (other.vroleid != null)
				return false;
		} else if (!vroleid.equals(other.vroleid))
			return false;
		return true;
	}

}

