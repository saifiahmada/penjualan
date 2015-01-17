package com.dessy.penjualan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.StokDetail;
import com.dessy.penjualan.common.GenericService;
import com.dessy.penjualan.dao.StokDetailDao;

@Transactional
@Service
public class StokDetailServiceImpl extends GenericService implements StokDetailService {

	@Autowired
	private StokDetailDao dao;
	
	public List<StokDetail> findAll() {
		return dao.findAll();
	}

	public void saveOrUpdate(StokDetail domain) {
		dao.saveOrUpdate(domain); 
	}

	public String getNoMesin(String kdItem) {
		return dao.getNoMesin(kdItem); 
	}

	public String getNoRangkaByNoMesin(String noMesin) {
		return dao.getNoRangkaByNoMesin(noMesin);
	}


}
