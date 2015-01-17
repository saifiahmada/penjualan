package com.dessy.penjualan.service;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.MstAccessRole;
import com.dessy.penjualan.dao.MstAccessRoleDao;


@Service
@Transactional
public class MstAccessRoleServiceImpl implements MstAccessRoleService {
	
	@Autowired
	private MstAccessRoleDao dao;

	public void saveOrUpdate(MstAccessRole domain, String user) {
		dao.saveOrUpdate(domain, user); 
	}

	public void save(MstAccessRole domain, String user) {
		dao.save(domain, user); 
	}

	public void update(MstAccessRole domain, String user) {
		dao.update(domain, user); 
	}

	public void delete(MstAccessRole domain) {
		dao.delete(domain); 
	}

	public List<MstAccessRole> findAll() {
		return dao.findAll();
	}

	public List<MstAccessRole> findByExample(MstAccessRole domain) {
		return dao.findByExample(domain); 
	}

	public List<MstAccessRole> findByCriteria(MstAccessRole domain) {
		return dao.findByCriteria(domain); 
	}

	public MstAccessRole findByPrimaryKey(MstAccessRole domain) {
		return dao.findByPrimaryKey(domain); 
	}



}

