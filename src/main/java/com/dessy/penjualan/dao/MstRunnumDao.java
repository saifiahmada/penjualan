package com.dessy.penjualan.dao;

import com.dessy.penjualan.bean.MstRunnum;
import com.dessy.penjualan.common.GenericDao;

public abstract interface MstRunnumDao extends GenericDao<MstRunnum, String> { 
	public int getRunningNumber(String idDoc, String reseter);
}
