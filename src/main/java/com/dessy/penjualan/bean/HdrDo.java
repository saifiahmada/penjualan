package com.dessy.penjualan.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dessy.penjualan.common.BaseAudit;

@Entity
@Table(name="HDR_DO")
public class HdrDo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="NO_DO", nullable=false)
	private String noDo;
	@Column(name="ALAMAT_TAGIHAN")
	private String alamatTagihan;
	@Column(name="NAMA_PENERIMA")
	private String namaPenerima;
	@Column(name="HARGA", precision=15, scale=2)
	private BigDecimal harga;
	@Column(name="NO_FAKTUR")
	private String noFaktur;
	@Column(name="STATUS")
	private String status;
	@Column(name="NO_PO")
	private String noPo;
	@Column(name="KD_DLR")
	private String kdDlr;
	@Column(name="TGL_DO")
	@Temporal(TemporalType.DATE)
	private Date tglDO;
	
	@Column(name="TGL_FAKTUR")
	@Temporal(TemporalType.DATE)
	private Date tglFaktur;
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="hdrDo" , fetch=FetchType.EAGER)
	private Set<DtlDo> dtlDos;
	
	public HdrDo() {
		dtlDos = new HashSet<DtlDo>();
	}
	
	public HdrDo(String noDo) {
		super();
		this.noDo = noDo;
	}

	public String getNoDo() {
		return noDo;
	}

	public void setNoDo(String noDo) {
		this.noDo = noDo;
	}

	public String getAlamatTagihan() {
		return alamatTagihan;
	}

	public void setAlamatTagihan(String alamatTagihan) {
		this.alamatTagihan = alamatTagihan;
	}

	public String getNamaPenerima() {
		return namaPenerima;
	}

	public void setNamaPenerima(String namaPenerima) {
		this.namaPenerima = namaPenerima;
	}

	public BigDecimal getHarga() {
		return harga;
	}

	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}

	public String getNoFaktur() {
		return noFaktur;
	}

	public void setNoFaktur(String noFaktur) {
		this.noFaktur = noFaktur;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<DtlDo> getDtlDos() {
		return dtlDos;
	}

	public void setDtlDos(Set<DtlDo> dtlDos) {
		this.dtlDos = dtlDos;
	}

	public String getNoPo() {
		return noPo;
	}

	public void setNoPo(String noPo) {
		this.noPo = noPo;
	}

	public String getKdDlr() {
		return kdDlr;
	}

	public void setKdDlr(String kdDlr) {
		this.kdDlr = kdDlr;
	}

	public Date getTglDO() {
		return tglDO;
	}

	public void setTglDO(Date tglDO) {
		this.tglDO = tglDO;
	}

	public Date getTglFaktur() {
		return tglFaktur;
	}

	public void setTglFaktur(Date tglFaktur) {
		this.tglFaktur = tglFaktur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noDo == null) ? 0 : noDo.hashCode());
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
		HdrDo other = (HdrDo) obj;
		if (noDo == null) {
			if (other.noDo != null)
				return false;
		} else if (!noDo.equals(other.noDo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HdrDo [noDo=" + noDo + "]";
	}

}
