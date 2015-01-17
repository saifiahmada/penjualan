package com.dessy.penjualan.service;

import java.util.List;

import com.dessy.penjualan.bean.MstUser;
import com.dessy.penjualan.util.GenericDao;


public abstract interface MstUserService { 
	public MstUser findUserByUsername(String username);
	public void saveOrUpdate(MstUser domain);
	public List<MstUser> findAll();
	public List<MstUser> findByObject(MstUser mstUser);
	
}

