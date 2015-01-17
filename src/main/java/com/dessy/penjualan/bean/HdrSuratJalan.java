package com.dessy.penjualan.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "HDR_SURAT_JALAN")
public class HdrSuratJalan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NO_SURAT_JALAN", nullable = false, length = 30)
	private String noSuratJalan;

	@Column(name = "STATUS", length = 1)
	private String status;

	@Column(name = "NAMA_PENERIMA", length = 30)
	private String namaPenerima;

	@Column(name = "KD_DLR", length = 10)
	private String kdDlr;

	@Column(name = "ALAMAT_PENERIMA", length = 50)
	private String alamatPenerima;

	@Column(name = "TGL_SJ")
	@Temporal(TemporalType.DATE)
	private Date tglSj;

	@Column(name = "NO_PICKLIST", length = 30)
	private String noPicklist;

	@OneToMany(cascade = { javax.persistence.CascadeType.ALL }, mappedBy = "hdrSuratJalan")
	private Set<DtlSuratJalan> dtlSuratJalans;

	public HdrSuratJalan() {
		dtlSuratJalans = new HashSet<DtlSuratJalan>();
	}

	public HdrSuratJalan(String noSuratJalan) {
		super();
		this.noSuratJalan = noSuratJalan;
	}

	public String getNoSuratJalan() {
		return noSuratJalan;
	}

	public void setNoSuratJalan(String noSuratJalan) {
		this.noSuratJalan = noSuratJalan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNamaPenerima() {
		return namaPenerima;
	}

	public void setNamaPenerima(String namaPenerima) {
		this.namaPenerima = namaPenerima;
	}

	public String getKdDlr() {
		return kdDlr;
	}

	public void setKdDlr(String kdDlr) {
		this.kdDlr = kdDlr;
	}

	public String getAlamatPenerima() {
		return alamatPenerima;
	}

	public void setAlamatPenerima(String alamatPenerima) {
		this.alamatPenerima = alamatPenerima;
	}

	public Date getTglSj() {
		return tglSj;
	}

	public void setTglSj(Date tglSj) {
		this.tglSj = tglSj;
	}

	public String getNoPicklist() {
		return noPicklist;
	}

	public void setNoPicklist(String noPicklist) {
		this.noPicklist = noPicklist;
	}

	public Set<DtlSuratJalan> getDtlSuratJalans() {
		return dtlSuratJalans;
	}

	public void setDtlSuratJalans(Set<DtlSuratJalan> dtlSuratJalans) {
		this.dtlSuratJalans = dtlSuratJalans;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((noPicklist == null) ? 0 : noPicklist.hashCode());
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
		HdrSuratJalan other = (HdrSuratJalan) obj;
		if (noPicklist == null) {
			if (other.noPicklist != null)
				return false;
		} else if (!noPicklist.equals(other.noPicklist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HdrSuratJalan [noSuratJalan=" + noSuratJalan + "]";
	}

}
