package com.dessy.penjualan.bean;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="STOK_GLOBAL")
public class StokGlobal implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="KD_ITEM")
	private String kdItem;
	@Column(name="QTY")
	private int qty;
	@Column(name="LOKASI", length=6)
	private String lokasi;
	
	public StokGlobal() {
		
	}
	
	public StokGlobal(String kdItem) {
		this.kdItem = kdItem;
	}

	public String getKdItem() {
		return kdItem;
	}

	public void setKdItem(String kdItem) {
		this.kdItem = kdItem;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getLokasi() {
		return lokasi;
	}

	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
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
		StokGlobal other = (StokGlobal) obj;
		if (kdItem == null) {
			if (other.kdItem != null)
				return false;
		} else if (!kdItem.equals(other.kdItem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StokGlobal [kdItem=" + kdItem + "]";
	}
	

}
