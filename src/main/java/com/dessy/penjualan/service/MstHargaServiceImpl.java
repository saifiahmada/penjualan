package com.dessy.penjualan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.MstHarga;
import com.dessy.penjualan.common.GenericService;
import com.dessy.penjualan.dao.MstHargaDao;

@Service
@Transactional
public class MstHargaServiceImpl implements
		MstHargaService {

	@Autowired
	private MstHargaDao dao;

	public void saveOrUpdate(MstHarga mstHarga) {
		dao.saveOrUpdate(mstHarga);
	}

	public List<MstHarga> findAll() {
		return dao.findAll();
	}
	
	public MstHarga get(String kdItem) {
		return dao.get(kdItem);
	}

	public List<MstHarga> findByObject(MstHarga mstHarga) {
		return dao.findByObject(mstHarga); 
	}

}
