package com.dessy.penjualan.bean;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MST_HARGA")
public class MstHarga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="KD_ITEM", nullable=false)
	private String kdItem;
	@Column(name="HRG_KSG")
	private BigDecimal hrgKsg;
	@Column(name="BBN")
	private BigDecimal bbn;
	@Column(name="HRG_KMP")
	private BigDecimal hrgKmp;
	
	public BigDecimal getHrgKsg() {
		return hrgKsg;
	}

	public void setHrgKsg(BigDecimal hrgKsg) {
		this.hrgKsg = hrgKsg;
	}

	public BigDecimal getBbn() {
		return bbn;
	}

	public void setBbn(BigDecimal bbn) {
		this.bbn = bbn;
	}

	public BigDecimal getHrgKmp() {
		return hrgKmp;
	}

	public void setHrgKmp(BigDecimal hrgKmp) {
		this.hrgKmp = hrgKmp;
	}

	public MstHarga() {
		// TODO Auto-generated constructor stub
	}

	public String getKdItem() {
		return kdItem;
	}

	public void setKdItem(String kdItem) {
		this.kdItem = kdItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kdItem == null) ? 0 : kdItem.hashCode());
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
		MstHarga other = (MstHarga) obj;
		if (kdItem == null) {
			if (other.kdItem != null)
				return false;
		} else if (!kdItem.equals(other.kdItem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MstHarga [kdItem=" + kdItem + "]";
	}

}
