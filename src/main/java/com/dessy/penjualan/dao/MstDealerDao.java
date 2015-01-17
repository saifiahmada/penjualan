package com.dessy.penjualan.dao;

import java.util.List;

import com.dessy.penjualan.bean.MstDealer;
import com.dessy.penjualan.common.GenericDao;


public abstract interface MstDealerDao extends GenericDao<MstDealer, String> { 
	public List<MstDealer> findByObject(MstDealer mstDealer);
}
