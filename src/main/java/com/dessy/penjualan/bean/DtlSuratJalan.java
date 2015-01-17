package com.dessy.penjualan.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DTL_SURAT_JALAN")
public class DtlSuratJalan implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private DtlSuratJalanPK dtlSuratJalanPK;

	@Column(name = "KD_ITEM", length = 25)
	private String kdItem;

	@Column(name = "NO_RANGKA", length = 30)
	private String noRangka;

	@JoinColumn(name="NO_SURAT_JALAN", referencedColumnName="NO_SURAT_JALAN", insertable=false, updatable=false)
	@ManyToOne(optional = false)
	private HdrSuratJalan hdrSuratJalan;

	public DtlSuratJalan() {

	}

	public DtlSuratJalan(DtlSuratJalanPK dtlSuratJalanPK) {
		super();
		this.dtlSuratJalanPK = dtlSuratJalanPK;
	}

	public DtlSuratJalanPK getDtlSuratJalanPK() {
		return dtlSuratJalanPK;
	}

	public void setDtlSuratJalanPK(DtlSuratJalanPK dtlSuratJalanPK) {
		this.dtlSuratJalanPK = dtlSuratJalanPK;
	}

	public String getKdItem() {
		return kdItem;
	}

	public void setKdItem(String kdItem) {
		this.kdItem = kdItem;
	}

	public String getNoRangka() {
		return noRangka;
	}

	public void setNoRangka(String noRangka) {
		this.noRangka = noRangka;
	}

	public HdrSuratJalan getHdrSuratJalan() {
		return hdrSuratJalan;
	}

	public void setHdrSuratJalan(HdrSuratJalan hdrSuratJalan) {
		this.hdrSuratJalan = hdrSuratJalan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dtlSuratJalanPK == null) ? 0 : dtlSuratJalanPK.hashCode());
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
		DtlSuratJalan other = (DtlSuratJalan) obj;
		if (dtlSuratJalanPK == null) {
			if (other.dtlSuratJalanPK != null)
				return false;
		} else if (!dtlSuratJalanPK.equals(other.dtlSuratJalanPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DtlSuratJalan [dtlSuratJalanPK=" + dtlSuratJalanPK + "]";
	}

}
