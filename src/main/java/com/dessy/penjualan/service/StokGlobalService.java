package com.dessy.penjualan.service;

import java.util.List;

import com.dessy.penjualan.bean.HdrPo;
import com.dessy.penjualan.bean.StokGlobal;
import com.dessy.penjualan.util.GenericDao;


public abstract interface StokGlobalService  { 
	
	public void saveOrUpdate(StokGlobal domain);

	public List<StokGlobal> findAll();
	
	public Integer getStokByKdItem(String kdItem);
	
	public boolean isOKCekStok(HdrPo hdrPO);
	
	public void updateStok(String kdItem, Integer qtyPick );
}
