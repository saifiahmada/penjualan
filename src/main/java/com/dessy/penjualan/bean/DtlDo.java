package com.dessy.penjualan.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dessy.penjualan.common.BaseAudit;

@Entity
@Table(name = "DTL_DO")
public class DtlDo implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private DtlDoPK dtlDoPK;

	@Column(name = "HARGA_KOSONG", precision = 20, scale = 2)
	private BigDecimal hargaKosong;

	@Column(name = "HARGA_STD", precision = 20, scale = 2)
	private BigDecimal hargaStd;

	@Column(name = "QTY")
	private Long qty;

	@Column(name = "HARGA_NETTO", precision = 20, scale = 2)
	private BigDecimal hargaNetto;

	@JoinColumn(name = "NO_DO", referencedColumnName = "NO_DO", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private HdrDo hdrDo;

	@JoinColumn(name = "KD_ITEM", referencedColumnName = "KD_ITEM", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private MstItem mstItem;
	
	public DtlDo() {

	}

	public DtlDo(DtlDoPK dtlDoPK) {
		super();
		this.dtlDoPK = dtlDoPK;
	}

	public DtlDoPK getDtlDoPK() {
		return dtlDoPK;
	}

	public void setDtlDoPK(DtlDoPK dtlDoPK) {
		this.dtlDoPK = dtlDoPK;
	}

	public BigDecimal getHargaKosong() {
		return hargaKosong;
	}

	public void setHargaKosong(BigDecimal hargaKosong) {
		this.hargaKosong = hargaKosong;
	}

	public BigDecimal getHargaStd() {
		return hargaStd;
	}

	public void setHargaStd(BigDecimal hargaStd) {
		this.hargaStd = hargaStd;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public BigDecimal getHargaNetto() {
		return hargaNetto;
	}

	public void setHargaNetto(BigDecimal hargaNetto) {
		this.hargaNetto = hargaNetto;
	}

	public HdrDo getHdrDo() {
		return hdrDo;
	}

	public void setHdrDo(HdrDo hdrDo) {
		this.hdrDo = hdrDo;
	}

	public MstItem getMstItem() {
		return mstItem;
	}

	public void setMstItem(MstItem mstItem) {
		this.mstItem = mstItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtlDoPK == null) ? 0 : dtlDoPK.hashCode());
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
		DtlDo other = (DtlDo) obj;
		if (dtlDoPK == null) {
			if (other.dtlDoPK != null)
				return false;
		} else if (!dtlDoPK.equals(other.dtlDoPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DtlDo [dtlDoPK=" + dtlDoPK + "]";
	}
	
	

}
