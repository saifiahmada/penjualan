package com.dessy.penjualan.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DtlDoPK implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name="NO_DO", length=30)
	private String noDo;
	@Column(name="KD_ITEM", length=6)
	private String kdItem;
	
	public DtlDoPK() {

	}

	public DtlDoPK(String noDo, String kdItem) {
		super();
		this.noDo = noDo;
		this.kdItem = kdItem;
	}

	public String getNoDo() {
		return noDo;
	}

	public void setNoDo(String noDo) {
		this.noDo = noDo;
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
		result = prime * result + ((noDo == null) ? 0 : noDo.hashCode());
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
		DtlDoPK other = (DtlDoPK) obj;
		if (kdItem == null) {
			if (other.kdItem != null)
				return false;
		} else if (!kdItem.equals(other.kdItem))
			return false;
		if (noDo == null) {
			if (other.noDo != null)
				return false;
		} else if (!noDo.equals(other.noDo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DtlDoPK [noDo=" + noDo + ", kdItem=" + kdItem + "]";
	}

}
