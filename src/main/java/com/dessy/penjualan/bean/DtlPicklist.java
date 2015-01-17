package com.dessy.penjualan.bean;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DTL_PICKLIST")
public class DtlPicklist implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DtlPicklistPK dtlPicklistPK;

	@Column(name = "KD_ITEM")
	private String kdItem;
	
	@Column(name = "NO_RANGKA")
	private String noRangka;

	@JoinColumn(name = "NOPICKLIST", referencedColumnName = "NOPICKLIST", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private HdrPicklist hdrPicklist;
	
	public DtlPicklist() {
		hdrPicklist = new HdrPicklist();
	}

	public DtlPicklist(DtlPicklistPK dtlPicklistPK) {
		super();
		this.dtlPicklistPK = dtlPicklistPK;
	}
	
	public DtlPicklist(String nopicklist, String noMesin) {
		super();
		this.dtlPicklistPK = new DtlPicklistPK(nopicklist, noMesin);
	}

	public DtlPicklistPK getDtlPicklistPK() {
		return dtlPicklistPK;
	}

	public void setDtlPicklistPK(DtlPicklistPK dtlPicklistPK) {
		this.dtlPicklistPK = dtlPicklistPK;
	}

	public String getKdItem() {
		return kdItem;
	}

	public void setKdItem(String kdItem) {
		this.kdItem = kdItem;
	}

	public HdrPicklist getHdrPicklist() {
		return hdrPicklist;
	}

	public void setHdrPicklist(HdrPicklist hdrPicklist) {
		this.hdrPicklist = hdrPicklist;
	}

	public String getNoRangka() {
		return noRangka;
	}

	public void setNoRangka(String noRangka) {
		this.noRangka = noRangka;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dtlPicklistPK == null) ? 0 : dtlPicklistPK.hashCode());
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
		DtlPicklist other = (DtlPicklist) obj;
		if (dtlPicklistPK == null) {
			if (other.dtlPicklistPK != null)
				return false;
		} else if (!dtlPicklistPK.equals(other.dtlPicklistPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DtlPicklist [dtlPicklistPK=" + dtlPicklistPK + "]";
	}

}
