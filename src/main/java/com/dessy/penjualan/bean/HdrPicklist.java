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
@Table(name = "HDR_PICKLIST")
public class HdrPicklist implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "NOPICKLIST", nullable = false, length = 30)
	private String nopicklist;

	@Column(name = "LOKASI", length = 20)
	private String lokasi;

	@Column(name = "STATUS", length = 1)
	private String status;
	
	@Column(name = "KD_DLR")
	private String kdDlr;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TGL_PICK")
	private Date tglPick; 

	@OneToMany(cascade = { javax.persistence.CascadeType.ALL }, mappedBy = "hdrPicklist")
	private Set<DtlPicklist> dtlpicklists; 
	
	public HdrPicklist() {
		this.dtlpicklists = new HashSet<DtlPicklist>();
	}
	
	
	public HdrPicklist(String nopicklist) {
		super();
		this.nopicklist = nopicklist;
	}

	public String getNopicklist() {
		return nopicklist;
	}

	public void setNopicklist(String nopicklist) {
		this.nopicklist = nopicklist;
	}

	public String getLokasi() {
		return lokasi;
	}

	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<DtlPicklist> getDtlpicklists() {
		return dtlpicklists;
	}

	public void setDtlpicklists(Set<DtlPicklist> dtlpicklists) {
		this.dtlpicklists = dtlpicklists;
	}

	public String getKdDlr() {
		return kdDlr;
	}


	public void setKdDlr(String kdDlr) {
		this.kdDlr = kdDlr;
	}


	public Date getTglPick() {
		return tglPick;
	}


	public void setTglPick(Date tglPick) {
		this.tglPick = tglPick;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		HdrPicklist other = (HdrPicklist) obj;
		if (nopicklist == null) {
			if (other.nopicklist != null)
				return false;
		} else if (!nopicklist.equals(other.nopicklist))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "HdrPicklist [nopicklist=" + nopicklist + "]";
	}

}
