package com.dessy.penjualan.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class MstRunnumPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="ID_DOC", length=20, nullable=false)
	private String idDoc;
	@Column(name="RESETER", length=6, nullable=false)
	private String reseter;
	
	public MstRunnumPK() {

	}
	
	public MstRunnumPK(String idDoc, String reseter) {
		this.idDoc = idDoc;
		this.reseter = reseter;
	}

	public String getIdDoc() {
		return idDoc;
	}

	public void setIdDoc(String idDoc) {
		this.idDoc = idDoc;
	}

	public String getReseter() {
		return reseter;
	}

	public void setReseter(String reseter) {
		this.reseter = reseter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDoc == null) ? 0 : idDoc.hashCode());
		result = prime * result + ((reseter == null) ? 0 : reseter.hashCode());
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
		MstRunnumPK other = (MstRunnumPK) obj;
		if (idDoc == null) {
			if (other.idDoc != null)
				return false;
		} else if (!idDoc.equals(other.idDoc))
			return false;
		if (reseter == null) {
			if (other.reseter != null)
				return false;
		} else if (!reseter.equals(other.reseter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MstRunnumPK [idDoc=" + idDoc + ", reseter=" + reseter + "]";
	}
	
}

