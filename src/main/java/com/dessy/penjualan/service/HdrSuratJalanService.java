package com.dessy.penjualan.service;

import com.dessy.penjualan.bean.HdrSuratJalan;


public interface HdrSuratJalanService  {
	
	public void saveOrUpdate(HdrSuratJalan hdrSuratJalan);
	
	public String generateSuratJalan(String noPicklist,String kdDlr);

}
