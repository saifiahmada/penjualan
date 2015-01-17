package com.dessy.penjualan.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.MstItem;
import com.dessy.penjualan.common.GenericService;
import com.dessy.penjualan.dao.MstItemDao;

@Service
@Transactional
public class MstItemServiceImpl extends GenericService implements MstItemService {

	@Autowired
	private MstItemDao dao;
	
	public MstItemDao getDao() {
		return dao;
	}

	public void setDao(MstItemDao dao) {
		this.dao = dao;
	}
	
	public void saveOrUpdate(MstItem mstItem, String user){
		try {
			updateCreationInfo(mstItem, user);
			dao.save(mstItem);
			
		} catch (DataIntegrityViolationException dive){
			updateLastModInfo(mstItem, user);
			dao.update(mstItem); 
		}
	}

	public void save(MstItem mstItem, String user){
		updateCreationInfo(mstItem, user); 
		dao.save(mstItem);
		System.out.println("save OK");
	}
	
	public void update(MstItem mstItem, String user){
		updateLastModInfo(mstItem, user);
		dao.update(mstItem);
		System.out.println("update OK");
	}
	
	public List<MstItem> findAll(){
		return dao.findAll();
	}

	public List<MstItem> findByObject(MstItem mstItem) {
		return dao.findByObject(mstItem); 
	}

	
}
