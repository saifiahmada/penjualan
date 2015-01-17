package com.dessy.penjualan.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.MstAccessRole;


@Repository
public class MstAccessRoleDaoImpl implements MstAccessRoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void saveOrUpdate(MstAccessRole domain, String user) {
		// TODO Auto-generated method stub
		
	}

	public void save(MstAccessRole domain, String user) {
		// TODO Auto-generated method stub
		
	}

	public void update(MstAccessRole domain, String user) {
		// TODO Auto-generated method stub
		
	}

	public void delete(MstAccessRole domain) {
		// TODO Auto-generated method stub
		
	}

	public List<MstAccessRole> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MstAccessRole> findByExample(MstAccessRole domain) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MstAccessRole> findByCriteria(MstAccessRole domain) {
		// TODO Auto-generated method stub
		return null;
	}

	public MstAccessRole findByPrimaryKey(MstAccessRole domain) {
		// TODO Auto-generated method stub
		return null;
	}



}

