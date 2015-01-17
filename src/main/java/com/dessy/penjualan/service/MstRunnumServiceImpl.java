package com.dessy.penjualan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.dao.MstRunnumDao;

@Service
@Transactional
public class MstRunnumServiceImpl implements MstRunnumService {
	
	@Autowired
	private MstRunnumDao dao;
	
	

}
