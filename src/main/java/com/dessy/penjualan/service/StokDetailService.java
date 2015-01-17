package com.dessy.penjualan.service;

import java.util.List;

import com.dessy.penjualan.bean.StokDetail;
import com.dessy.penjualan.util.GenericDao;


public abstract interface StokDetailService  { 
	
	public void saveOrUpdate(StokDetail domain);

	public List<StokDetail> findAll();
	
	public String getNoMesin(String kdItem);
	
	public String getNoRangkaByNoMesin(String noMesin);

}
