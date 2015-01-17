package com.dessy.penjualan.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.HdrPo;
import com.dessy.penjualan.common.GenericService;
import com.dessy.penjualan.dao.HdrPoDao;

@Service
@Transactional
public class HdrPoServiceImpl implements HdrPoService {
	
	@Autowired
	private HdrPoDao dao;
	
	public void save(HdrPo po){
		
		dao.save(po);
	}

	public void update(HdrPo po) {
		
		dao.update(po);
		
	}

	public List<HdrPo> findAll() {
		return dao.findAll();
	}
	
	public HdrPo get(String key){
		return dao.get(key);
	}

	public List<HdrPo> getPOByDealer(String idDealer) {
		return dao.getPOByDealer(idDealer);
	}

	public List<HdrPo> findListBy(HdrPo hdrPo) {
		return dao.findListBy(hdrPo); 
	}

	public void updateStatus(String noPo, String status) {
		dao.updateStatus(noPo, status); 
	}
	
}
