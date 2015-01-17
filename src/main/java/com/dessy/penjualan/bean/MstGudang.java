package com.dessy.penjualan.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MstGudang {
	@Id
	private String id;
	
	private String namaGudang;
	
	public MstGudang() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNamaGudang() {
		return namaGudang;
	}

	public void setNamaGudang(String namaGudang) {
		this.namaGudang = namaGudang;
	}
	

}
