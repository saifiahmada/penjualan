package com.dessy.penjualan.dao;

import java.util.List;

import com.dessy.penjualan.bean.MstItem;
import com.dessy.penjualan.common.GenericDao;


public abstract interface MstItemDao extends GenericDao<MstItem, String> { 
	public List<MstItem> findByObject(MstItem mstItem);
}
