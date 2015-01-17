package com.dessy.penjualan.dao;


import com.dessy.penjualan.bean.StokDetail;
import com.dessy.penjualan.common.GenericDao;

public abstract interface StokDetailDao extends GenericDao<StokDetail, String> { 
	public String getNoMesin(String kdItem);
	public String getNoRangkaByNoMesin(String noMesin);
}
