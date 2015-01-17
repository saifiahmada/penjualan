package com.dessy.penjualan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.MstUser;
import com.dessy.penjualan.dao.MstUserDao;


@Service
@Transactional
public class MstUserServiceImpl implements MstUserService {
	
	@Autowired
	private MstUserDao dao;

	public void saveOrUpdate(MstUser domain) {
		dao.saveOrUpdate(domain); 
	}

	public List<MstUser> findAll() {
		return dao.findAll();
	}

	public MstUser findUserByUsername(String username) {
		return dao.findUserByUsername(username); 
	}

	public List<MstUser> findByObject(MstUser mstUser) {
		return dao.findByObject(mstUser); 
	}

		
}

