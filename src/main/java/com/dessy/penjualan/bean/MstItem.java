package com.dessy.penjualan.bean;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dessy.penjualan.common.BaseAudit;

@Entity
@Table(name="MST_ITEM")
public class MstItem extends BaseAudit implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="KD_ITEM", length=6, nullable=false)
	private String kdItem;
	@Column(name="NAMA", length=15)
	private String nama;
	@Column(name="TIPE", length=15)
	private String tipe;
	@Column(name="WARNA", length=15)
	private String warna;
	
	public MstItem() {

	}

	public MstItem(String kdItem) {
		super();
		this.kdItem = kdItem;
	}

	public String getKdItem() {
		return kdItem;
	}

	public void setKdItem(String kdItem) {
		this.kdItem = kdItem;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTipe() {
		return tipe;
	}

	public void setTipe(String tipe) {
		this.tipe = tipe;
	}

	public String getWarna() {
		return warna;
	}

	public void setWarna(String warna) {
		this.warna = warna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((kdItem == null) ? 0 : kdItem.hashCode());
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
		MstItem other = (MstItem) obj;
		if (kdItem == null) {
			if (other.kdItem != null)
				return false;
		} else if (!kdItem.equals(other.kdItem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MstItem [kdItem=" + kdItem + "]";
	}
}
