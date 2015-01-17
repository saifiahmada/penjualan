package com.dessy.penjualan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.MstDealer;
import com.dessy.penjualan.common.GenericService;
import com.dessy.penjualan.dao.MstDealerDao;

@Service
@Transactional
public class MstDealerServiceImpl extends GenericService implements MstDealerService {
	
	@Autowired
	private MstDealerDao dao;

	public void save(MstDealer domain, String user) {
		dao.save(domain); 
	}

	public void update(MstDealer domain, String user) {
		dao.update(domain); 
	}
	
	public List<MstDealer> findAll() {
		return dao.findAll();
	}

	public void saveOrUpdate(MstDealer domain, String user) {
		dao.saveOrUpdate(domain); 
	}

	public List<MstDealer> findByObject(MstDealer mstDealer) {
		return dao.findByObject(mstDealer); 
	}

}
