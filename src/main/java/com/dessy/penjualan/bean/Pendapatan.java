package com.dessy.penjualan.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PENDAPATAN")
public class Pendapatan implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="NO_MESIN")
	private String noMesin;
	@Column(name="KD_ITEM")
	private String kdItem;
	@Column(name="HARGA_BELI")
	private BigDecimal hargaBeli;
	@Column(name="HARGA_JUAL")
	private BigDecimal hargaJual;
	@Column(name="UNTUNG")
	private BigDecimal untung;
	
	public Pendapatan() {
		// TODO Auto-generated constructor stub
	}

	public String getNoMesin() {
		return noMesin;
	}

	public void setNoMesin(String noMesin) {
		this.noMesin = noMesin;
	}

	public String getKdItem() {
		return kdItem;
	}

	public void setKdItem(String kdItem) {
		this.kdItem = kdItem;
	}

	

	public BigDecimal getHargaBeli() {
		return hargaBeli;
	}

	public void setHargaBeli(BigDecimal hargaBeli) {
		this.hargaBeli = hargaBeli;
	}

	public BigDecimal getHargaJual() {
		return hargaJual;
	}

	public void setHargaJual(BigDecimal hargaJual) {
		this.hargaJual = hargaJual;
	}

	public BigDecimal getUntung() {
		return untung;
	}

	public void setUntung(BigDecimal untung) {
		this.untung = untung;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noMesin == null) ? 0 : noMesin.hashCode());
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
		Pendapatan other = (Pendapatan) obj;
		if (noMesin == null) {
			if (other.noMesin != null)
				return false;
		} else if (!noMesin.equals(other.noMesin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pendapatan [noMesin=" + noMesin + "]";
	}
	
}
