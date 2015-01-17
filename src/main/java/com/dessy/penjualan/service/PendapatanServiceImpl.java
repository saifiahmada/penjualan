package com.dessy.penjualan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.Pendapatan;
import com.dessy.penjualan.dao.PendapatanDao;

@Service
@Transactional
public class PendapatanServiceImpl implements PendapatanService {

	@Autowired
	private PendapatanDao dao;

	public void saveOrUpdate(Pendapatan pendapatan) {
		dao.saveOrUpdate(pendapatan);
	}

	public List<Pendapatan> findAll() {
		return dao.findAll();
	}
	
	public Pendapatan get(String kdItem) {
		return dao.get(kdItem);
	}

	public List<Pendapatan> getListByKdItem(String kdItem) {
		return dao.getListByKdItem(kdItem); 
	}


}
