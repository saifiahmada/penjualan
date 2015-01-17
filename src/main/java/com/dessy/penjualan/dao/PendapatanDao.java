package com.dessy.penjualan.dao;

import java.util.List;

import com.dessy.penjualan.bean.MstHarga;
import com.dessy.penjualan.bean.Pendapatan;
import com.dessy.penjualan.common.GenericDao;

public interface PendapatanDao extends GenericDao<Pendapatan, String>  {
	public List<Pendapatan> getListByKdItem(String kdItem);
}
