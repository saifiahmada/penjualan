package com.dessy.penjualan.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.MstUserRole;
import com.dessy.penjualan.dao.MstUserRoleDao;


@Service
@Transactional
public class MstUserRoleServiceImpl implements MstUserRoleService {
	
	@Autowired
	private MstUserRoleDao dao;

	public void saveOrUpdate(MstUserRole domain, String user) {
		dao.saveOrUpdate(domain, user);
	}

	public void save(MstUserRole domain, String user) {
		dao.save(domain, user); 
	}

	public void update(MstUserRole domain, String user) {
		dao.update(domain, user);
	}

	public void delete(MstUserRole domain) {
		dao.delete(domain); 
	}

	public List<MstUserRole> findAll() {
		return dao.findAll();
	}

	public List<MstUserRole> findByExample(MstUserRole domain) {
		return dao.findByExample(domain);
	}

	public List<MstUserRole> findByCriteria(MstUserRole domain) {
		return dao.findByCriteria(domain);
	}

	public MstUserRole findByPrimaryKey(MstUserRole domain) {
		return dao.findByPrimaryKey(domain);
	}

	
}

