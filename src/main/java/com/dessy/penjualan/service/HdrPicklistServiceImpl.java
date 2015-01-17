package com.dessy.penjualan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.HdrPicklist;
import com.dessy.penjualan.dao.HdrPicklistDao;

@Service
@Transactional
public class HdrPicklistServiceImpl implements HdrPicklistService {

	@Autowired
	private HdrPicklistDao dao;
	
	public void saveOrUpdate(HdrPicklist hdrPicklist) {
		dao.saveOrUpdate(hdrPicklist); 
	}

	public HdrPicklist prosesPicklist(String noDo) {
		return dao.prosesPicklist(noDo); 
	}

	public List<HdrPicklist> findByStatusAndKdDlr(String kdDlr, String status) {
		return dao.findByStatusAndKdDlr(kdDlr, status); 
	}
	
	public HdrPicklist get(String key){
		return dao.get(key);
	}

	

}
