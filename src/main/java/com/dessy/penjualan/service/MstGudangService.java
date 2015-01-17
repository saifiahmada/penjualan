package com.dessy.penjualan.service;

import java.util.List;

import com.dessy.penjualan.bean.MstGudang;

public interface MstGudangService {
	public void saveOrUpdate(MstGudang mstGudang);
	public List<MstGudang> findAll();
	public List<MstGudang> findByObject(MstGudang mstGudang);
}
