package com.dessy.penjualan.service;

import java.util.List;

import com.dessy.penjualan.bean.MstHarga;

public interface MstHargaService {
	public void saveOrUpdate(MstHarga mstHarga);
	public List<MstHarga> findAll();
	public MstHarga get(String kdItem);
	public List<MstHarga> findByObject(MstHarga mstHarga);
}
