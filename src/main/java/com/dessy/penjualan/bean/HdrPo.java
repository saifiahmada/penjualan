package com.dessy.penjualan.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dessy.penjualan.common.BaseAudit;

@Entity
@Table(name="HDR_PO")
public class HdrPo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="NO_PO", length=30, nullable=false)
	private String noPo;
	@Column(name="TGL_PO")
	@Temporal(TemporalType.DATE)
	private Date tglPo;
	@Column(name="ID_DEALER", length = 6)
	private String idDealer;
	@Column(name="STATUS", length=1)
	private String status;
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="hdrPo", fetch=FetchType.EAGER)
	private Set<DtlPo> dtlPos;
	
	public HdrPo() {
		dtlPos = new HashSet<DtlPo>();
	}

	public HdrPo(String noPo) {
		super();
		this.noPo = noPo;
	}

	public String getNoPo() {
		return noPo;
	}

	public void setNoPo(String noPo) {
		this.noPo = noPo;
	}

	public Date getTglPo() {
		return tglPo;
	}

	public void setTglPo(Date tglPo) {
		this.tglPo = tglPo;
	}

	public String getIdDealer() {
		return idDealer;
	}

	public void setIdDealer(String idDealer) {
		this.idDealer = idDealer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<DtlPo> getDtlPos() {
		return dtlPos;
	}

	public void setDtlPos(Set<DtlPo> dtlPos) {
		this.dtlPos = dtlPos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noPo == null) ? 0 : noPo.hashCode());
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
		HdrPo other = (HdrPo) obj;
		if (noPo == null) {
			if (other.noPo != null)
				return false;
		} else if (!noPo.equals(other.noPo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HdrPo [noPo=" + noPo + "]";
	}

	
}
