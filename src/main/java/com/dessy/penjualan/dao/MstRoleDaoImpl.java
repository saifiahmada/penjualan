package com.dessy.penjualan.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.MstRole;


@Repository
public class MstRoleDaoImpl implements MstRoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void saveOrUpdate(MstRole domain, String user) {
		// TODO Auto-generated method stub
		
	}

	public void save(MstRole domain, String user) {
		// TODO Auto-generated method stub
		
	}

	public void update(MstRole domain, String user) {
		// TODO Auto-generated method stub
		
	}

	public void delete(MstRole domain) {
		// TODO Auto-generated method stub
		
	}

	public List<MstRole> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MstRole> findByExample(MstRole domain) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MstRole> findByCriteria(MstRole domain) {
		// TODO Auto-generated method stub
		return null;
	}

	public MstRole findByPrimaryKey(MstRole domain) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

