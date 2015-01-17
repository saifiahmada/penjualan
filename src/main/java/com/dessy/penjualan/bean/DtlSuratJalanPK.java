package com.dessy.penjualan.bean;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DtlSuratJalanPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(name = "NO_MESIN", nullable = false, length = 30)
	private String noMesin;

	@Basic(optional = false)
	@Column(name = "NO_SURAT_JALAN", nullable = false, length = 30)
	private String noSuratJalan;
	
	public DtlSuratJalanPK() {

	}

	public DtlSuratJalanPK(String noMesin, String noSuratJalan) {
		super();
		this.noMesin = noMesin;
		this.noSuratJalan = noSuratJalan;
	}

	public String getNoMesin() {
		return noMesin;
	}

	public void setNoMesin(String noMesin) {
		this.noMesin = noMesin;
	}

	public String getNoSuratJalan() {
		return noSuratJalan;
	}

	public void setNoSuratJalan(String noSuratJalan) {
		this.noSuratJalan = noSuratJalan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noMesin == null) ? 0 : noMesin.hashCode());
		result = prime * result
				+ ((noSuratJalan == null) ? 0 : noSuratJalan.hashCode());
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
		DtlSuratJalanPK other = (DtlSuratJalanPK) obj;
		if (noMesin == null) {
			if (other.noMesin != null)
				return false;
		} else if (!noMesin.equals(other.noMesin))
			return false;
		if (noSuratJalan == null) {
			if (other.noSuratJalan != null)
				return false;
		} else if (!noSuratJalan.equals(other.noSuratJalan))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DtlSuratJalanPK [noMesin=" + noMesin + ", noSuratJalan="
				+ noSuratJalan + "]";
	}
	
}
