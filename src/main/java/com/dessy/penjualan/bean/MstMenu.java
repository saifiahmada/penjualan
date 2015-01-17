package com.dessy.penjualan.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dessy.penjualan.common.BaseAudit;



@Entity
@Table(name="MST_MENU")
public class MstMenu extends BaseAudit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="VMENUID", length=11, nullable=false)
	private String vmenuid;
	
	@Column(name="VPARENT", length=6)
	private String vparent;
	
	@Column(name="VTITLE", length=100)
	private String vtitle;
	
	@Column(name="VLOCATION", length=30)
	private String vlocation;
	
	@Column(name="VIMAGE", length=30)
	private String vimage;
	
	@Column(name="VSTATUS", length=1)
	private String vstatus;
	
	@Column(name="NORDERER", length=3)
	private int norderer;
	
	@OneToMany(mappedBy="trioMstmenu")
	private Set<MstAccessRole> trioMstaccessroleSet;
	
	public MstMenu() {
		
	}
	
	public MstMenu(String vmenuid) {
		this.vmenuid = vmenuid;
	}
	
	public MstMenu(String vmenuid, String vparent, String vtitle, String vlocation, String vimage, int norderer ) {
		this.vmenuid = vmenuid;
		this.vparent = vparent;
		this.vtitle = vtitle;
		this.vlocation = vlocation;
		this.vimage = vimage;
		this.norderer = norderer;
	}

	public String getVmenuid() {
		return vmenuid;
	}

	public void setVmenuid(String vmenuid) {
		this.vmenuid = vmenuid;
	}

	public Set<MstAccessRole> getTrioMstaccessroleSet() {
		return trioMstaccessroleSet;
	}

	public void setTrioMstaccessroleSet(Set<MstAccessRole> trioMstaccessroleSet) {
		this.trioMstaccessroleSet = trioMstaccessroleSet;
	}
	
	public String getVparent() {
		return vparent;
	}

	public void setVparent(String vparent) {
		this.vparent = vparent;
	}

	public String getVtitle() {
		return vtitle;
	}

	public void setVtitle(String vtitle) {
		this.vtitle = vtitle;
	}

	public String getVlocation() {
		return vlocation;
	}

	public void setVlocation(String vlocation) {
		this.vlocation = vlocation;
	}

	public String getVimage() {
		return vimage;
	}

	public void setVimage(String vimage) {
		this.vimage = vimage;
	}

	public int getNorderer() {
		return norderer;
	}

	public void setNorderer(int norderer) {
		this.norderer = norderer;
	}

	public String getVstatus() {
		return vstatus;
	}

	public void setVstatus(String vstatus) {
		this.vstatus = vstatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((vmenuid == null) ? 0 : vmenuid.hashCode());
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
		MstMenu other = (MstMenu) obj;
		if (vmenuid == null) {
			if (other.vmenuid != null)
				return false;
		} else if (!vmenuid.equals(other.vmenuid))
			return false;
		return true;
	}

}
