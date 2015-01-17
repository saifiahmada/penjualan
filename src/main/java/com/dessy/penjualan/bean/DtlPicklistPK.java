package com.dessy.penjualan.bean;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DtlPicklistPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "NOPICKLIST", nullable = false, length = 30)
	private String nopicklist;

	@Basic(optional = false)
	@Column(name = "NO_MESIN", nullable = false, length = 30)
	private String noMesin;
	
	public DtlPicklistPK() {

	}

	public DtlPicklistPK(String nopicklist, String noMesin) {
		super();
		this.nopicklist = nopicklist;
		this.noMesin = noMesin;
	}

	public String getNopicklist() {
		return nopicklist;
	}

	public void setNopicklist(String nopicklist) {
		this.nopicklist = nopicklist;
	}

	public String getNoMesin() {
		return noMesin;
	}

	public void setNoMesin(String noMesin) {
		this.noMesin = noMesin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noMesin == null) ? 0 : noMesin.hashCode());
		result = prime * result
				+ ((nopicklist == null) ? 0 : nopicklist.hashCode());
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
		DtlPicklistPK other = (DtlPicklistPK) obj;
		if (noMesin == null) {
			if (other.noMesin != null)
				return false;
		} else if (!noMesin.equals(other.noMesin))
			return false;
		if (nopicklist == null) {
			if (other.nopicklist != null)
				return false;
		} else if (!nopicklist.equals(other.nopicklist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DtlPicklistPK [nopicklist=" + nopicklist + ", noMesin="
				+ noMesin + "]";
	}

}
