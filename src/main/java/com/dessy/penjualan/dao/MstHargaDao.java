package com.dessy.penjualan.dao;

import java.util.List;

import com.dessy.penjualan.bean.MstHarga;
import com.dessy.penjualan.common.GenericDao;

public interface MstHargaDao extends GenericDao<MstHarga, String>  {
	public List<MstHarga> findByObject(MstHarga mstHarga);
}
