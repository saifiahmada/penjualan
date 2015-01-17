package com.dessy.penjualan.dao;

import java.util.List;

import com.dessy.penjualan.bean.MstUser;
import com.dessy.penjualan.common.GenericDao;


public interface MstUserDao extends GenericDao<MstUser, String> { 
	public MstUser findUserByUsername(String username);
	public List<MstUser> findByObject(MstUser mstUser);
}

