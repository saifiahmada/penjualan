package com.dessy.penjualan.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dessy.penjualan.common.BaseAudit;
import com.dessy.penjualan.usertrail.EntityUserTrail;


@Entity
@Table(name="MST_DEALER")
public class MstDealer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID", length=6, nullable=false)
	private String id;
	@Column(name="NAMA_DEALER", length=50)
	private String namaDealer;
	@Column(name="ALAMAT", length=200)
	private String alamat;
	@Column(name="TELPON", length=15)
	private String telpon;
	@Column(name="PIMPINAN", length=30)
	private String pimpinan;
	@Column(name="NPWP", length=30)
	private String npwp;
	
	public MstDealer() {

	}
	
	public MstDealer(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNamaDealer() {
		return namaDealer;
	}

	public void setNamaDealer(String namaDealer) {
		this.namaDealer = namaDealer;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getTelpon() {
		return telpon;
	}

	public void setTelpon(String telpon) {
		this.telpon = telpon;
	}

	public String getPimpinan() {
		return pimpinan;
	}

	public void setPimpinan(String pimpinan) {
		this.pimpinan = pimpinan;
	}


	public String getNpwp() {
		return npwp;
	}

	public void setNpwp(String npwp) {
		this.npwp = npwp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MstDealer other = (MstDealer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MstDealer [id=" + id + "]";
	}

}
