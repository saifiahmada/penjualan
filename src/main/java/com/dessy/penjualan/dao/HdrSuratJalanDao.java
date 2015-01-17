package com.dessy.penjualan.dao;

import com.dessy.penjualan.bean.HdrSuratJalan;
import com.dessy.penjualan.common.GenericDao;

public abstract interface HdrSuratJalanDao extends GenericDao<HdrSuratJalan, String> { 
	public String generateSuratJalan(String noPicklist,String kdDlr);
}
