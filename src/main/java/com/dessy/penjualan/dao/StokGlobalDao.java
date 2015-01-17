package com.dessy.penjualan.dao;

import com.dessy.penjualan.bean.StokGlobal;
import com.dessy.penjualan.common.GenericDao;


public abstract interface StokGlobalDao extends GenericDao<StokGlobal, String> { 
	public Integer getStokByKdItem(String kdItem);
	public void updateStok(String kdItem, Integer qtyPick );
}
