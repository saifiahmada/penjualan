package com.dessy.penjualan.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dessy.penjualan.bean.MstUserRole;

@Repository
public class MstUserRoleDaoImpl implements MstUserRoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void saveOrUpdate(MstUserRole domain, String user) {
		// TODO Auto-generated method stub
		
	}

	public void save(MstUserRole domain, String user) {
		// TODO Auto-generated method stub
		
	}

	public void update(MstUserRole domain, String user) {
		// TODO Auto-generated method stub
		
	}

	public void delete(MstUserRole domain) {
		// TODO Auto-generated method stub
		
	}

	public List<MstUserRole> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MstUserRole> findByExample(MstUserRole domain) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MstUserRole> findByCriteria(MstUserRole domain) {
		// TODO Auto-generated method stub
		return null;
	}

	public MstUserRole findByPrimaryKey(MstUserRole domain) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

