package com.dessy.penjualan.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dessy.penjualan.common.BaseAudit;


@Entity
@Table(name="STOK_DETAIL")
public class StokDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="NO_MESIN", length=13)
	private String noMesin;
	@Column(name="NO_RANGKA", length=13)
	private String noRangka;
	@Column(name="KD_ITEM", length=6)
	private String kdItem;
	@Column(name="LOKASI", length=10)
	private String lokasi;
	@Column(name="THN_PRODUKSI", length=4)
	private String thnProduksi;
	@Column(name="NO_PICKLIST", length=30)
	private String noPicklist;
	@Column(name="STATUS", length=1)
	private String status;
	
	public StokDetail() {
		
	}
	
	public StokDetail(String noMesin ) {
		super();
		this.noMesin = noMesin;
	}

	public String getNoMesin() {
		return noMesin;
	}

	public void setNoMesin(String noMesin) {
		this.noMesin = noMesin;
	}

	public String getNoRangka() {
		return noRangka;
	}

	public void setNoRangka(String noRangka) {
		this.noRangka = noRangka;
	}

	public String getKdItem() {
		return kdItem;
	}

	public void setKdItem(String kdItem) {
		this.kdItem = kdItem;
	}

	public String getLokasi() {
		return lokasi;
	}

	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
	}

	public String getThnProduksi() {
		return thnProduksi;
	}

	public void setThnProduksi(String thnProduksi) {
		this.thnProduksi = thnProduksi;
	}

	public String getNoPicklist() {
		return noPicklist;
	}

	public void setNoPicklist(String noPicklist) {
		this.noPicklist = noPicklist;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
