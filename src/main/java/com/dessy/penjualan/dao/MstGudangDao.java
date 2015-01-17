package com.dessy.penjualan.dao;

import java.util.List;

import com.dessy.penjualan.bean.MstGudang;
import com.dessy.penjualan.common.GenericDao;


public abstract interface MstGudangDao extends GenericDao<MstGudang, String> {
	public List<MstGudang> findByObject(MstGudang mstGudang);
}
