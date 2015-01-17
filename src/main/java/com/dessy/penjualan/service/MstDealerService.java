package com.dessy.penjualan.service;

import java.util.List;

import com.dessy.penjualan.bean.MstDealer;
import com.dessy.penjualan.util.GenericDao;

public abstract interface MstDealerService  { 
	
	public void save(MstDealer domain, String user);
	
	public void saveOrUpdate(MstDealer domain, String user);

	public void update(MstDealer domain, String user);
	
	public List<MstDealer> findAll();
	
	public List<MstDealer> findByObject(MstDealer mstDealer);

}
