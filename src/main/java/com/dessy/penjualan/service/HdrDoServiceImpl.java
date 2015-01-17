package com.dessy.penjualan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.HdrDo;
import com.dessy.penjualan.dao.HdrDoDao;

@Service
@Transactional
public class HdrDoServiceImpl implements HdrDoService {

	@Autowired
	private HdrDoDao dao;
	
	public void saveOrUpdate(HdrDo hdrDo) {
		dao.saveOrUpdate(hdrDo); 
	}

	public List<HdrDo> findByStatusAnKodeDealer(String status, String kdDlr) {
		return dao.findByStatusAnKodeDealer(status, kdDlr); 
	}
	
	public void update(HdrDo hdrDo){
		dao.update(hdrDo);
	}

	public String saveTransaksi(HdrDo newEntity) {
		return dao.saveTransaksi(newEntity); 
	}

	public String prosesFaktur(String noDO, String kdDlr) {
		return dao.prosesFaktur(noDO, kdDlr); 
	}
	
	public List<HdrDo> findAll(){
		return dao.findAll();
	}


}
