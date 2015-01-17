package com.dessy.penjualan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.MstMenu;
import com.dessy.penjualan.common.GenericService;
import com.dessy.penjualan.dao.MstMenuDao;


@Service
@Transactional
public class MstMenuServiceImpl extends GenericService implements MstMenuService {
	
	@Autowired
	private MstMenuDao dao;

	public void save(MstMenu mstMenu, String user) {
		updateCreationInfo(mstMenu, user);
		dao.save(mstMenu); 
	}
	
	public void update(MstMenu mstMenu, String user) {
		updateLastModInfo(mstMenu, user); 
		dao.update(mstMenu); 
	}
	
	public List<MstMenu> findAll(){
		return dao.findAll();
	}

	public List<MstMenu> findByObject(MstMenu mstMenu) {
		return dao.findByObject(mstMenu);
	}

	public List<MstMenu> findOrderer() {
		return dao.findOrderer();
	}

	
}

