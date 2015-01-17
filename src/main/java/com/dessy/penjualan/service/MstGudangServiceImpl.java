package com.dessy.penjualan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dessy.penjualan.bean.MstGudang;
import com.dessy.penjualan.dao.MstGudangDao;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MstGudangServiceImpl implements MstGudangService {

	@Autowired
	private MstGudangDao dao;
	
	public void saveOrUpdate(MstGudang mstGudang){
		dao.saveOrUpdate(mstGudang);
	}

	public List<MstGudang> findAll() {
		return dao.findAll();
	}

	public List<MstGudang> findByObject(MstGudang mstGudang) {
		return dao.findByObject(mstGudang); 
	}
	
	
}
