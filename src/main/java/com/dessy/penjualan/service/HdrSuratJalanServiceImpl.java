package com.dessy.penjualan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.HdrSuratJalan;
import com.dessy.penjualan.dao.HdrSuratJalanDao;


@Transactional
@Service
public class HdrSuratJalanServiceImpl implements HdrSuratJalanService {
	
	@Autowired
	private HdrSuratJalanDao dao;

	public void saveOrUpdate(HdrSuratJalan hdrSuratJalan) {
		dao.saveOrUpdate(hdrSuratJalan); 
	}

	public String generateSuratJalan(String noPicklist, String kdDlr) {
		return dao.generateSuratJalan(noPicklist, kdDlr); 
	}

}
