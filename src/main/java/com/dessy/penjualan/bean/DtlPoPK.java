package com.dessy.penjualan.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DtlPoPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="NO_PO", length=30)
	private String noPo;
	
	@Column(name="KD_ITEM", length=6)
	private String kdItem;
	
	public DtlPoPK() {
	}

	public DtlPoPK(String noPo, String kdItem) {
		super();
		this.noPo = noPo;
		this.kdItem = kdItem;
	}

	public String getNoPo() {
		return noPo;
	}

	public void setNoPo(String noPo) {
		this.noPo = noPo;
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
		DtlPoPK other = (DtlPoPK) obj;
		if (kdItem == null) {
			if (other.kdItem != null)
				return false;
		} else if (!kdItem.equals(other.kdItem))
			return false;
		if (noPo == null) {
			if (other.noPo != null)
				return false;
		} else if (!noPo.equals(other.noPo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DtlPoPK [noPo=" + noPo + ", kdItem=" + kdItem + "]";
	}
	
}
