package com.dessy.penjualan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.MstRole;
import com.dessy.penjualan.dao.MstRoleDao;


@Service
@Transactional
public class MstRoleServiceImpl implements MstRoleService {
	
	@Autowired
	private MstRoleDao dao;

	public void saveOrUpdate(MstRole domain, String user) {
		dao.saveOrUpdate(domain, user);
	}

	public void save(MstRole domain, String user) {
		dao.save(domain, user); 
	}

	public void update(MstRole domain, String user) {
		dao.update(domain, user);
	}

	public void delete(MstRole domain) {
		dao.delete(domain);
	}

	public List<MstRole> findAll() {
		return dao.findAll();
	}

	public List<MstRole> findByExample(MstRole domain) {
		return dao.findByExample(domain); 
	}

	public List<MstRole> findByCriteria(MstRole domain) {
		return dao.findByCriteria(domain); 
	}

	public MstRole findByPrimaryKey(MstRole domain) {
		return dao.findByPrimaryKey(domain); 
	}

	
}

