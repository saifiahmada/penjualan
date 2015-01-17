package com.dessy.penjualan.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dessy.penjualan.common.BaseAudit;

@Entity
@Table(name="DTL_PO")
public class DtlPo implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@EmbeddedId
	private DtlPoPK dtlPoPK;
	
	@Column(name="QTY")
	private int qty;
	
	@Column(name="QTY_APP")
	private int qtyApp;
	
	@ManyToOne
	@JoinColumn(name="NO_PO", referencedColumnName="NO_PO", insertable=false, updatable=false)
	private HdrPo hdrPo;
	
	public DtlPo() {
		hdrPo = new HdrPo();
	}
	
	public DtlPo(String noPo, String kdItem) {
		super();
		this.dtlPoPK = new DtlPoPK(noPo, kdItem);
	}

	public DtlPo(DtlPoPK dtlPoPK) {
		super();
		this.dtlPoPK = dtlPoPK;
	}

	public DtlPoPK getDtlPoPK() {
		return dtlPoPK;
	}

	public void setDtlPoPK(DtlPoPK dtlPoPK) {
		this.dtlPoPK = dtlPoPK;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public HdrPo getHdrPo() {
		return hdrPo;
	}

	public void setHdrPo(HdrPo hdrPo) {
		this.hdrPo = hdrPo;
	}

	public int getQtyApp() {
		return qtyApp;
	}

	public void setQtyApp(int qtyApp) {
		this.qtyApp = qtyApp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtlPoPK == null) ? 0 : dtlPoPK.hashCode());
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
		DtlPo other = (DtlPo) obj;
		if (dtlPoPK == null) {
			if (other.dtlPoPK != null)
				return false;
		} else if (!dtlPoPK.equals(other.dtlPoPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DtlPo [dtlPoPK=" + dtlPoPK + "]";
	}
	
}
