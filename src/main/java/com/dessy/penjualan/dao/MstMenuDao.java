package com.dessy.penjualan.dao;

import java.util.List;

import com.dessy.penjualan.bean.MstMenu;
import com.dessy.penjualan.common.GenericDao;

public abstract interface MstMenuDao extends GenericDao<MstMenu, String>  {  
	public List<MstMenu> findByObject(MstMenu mstMenu);
	public List<MstMenu> findOrderer();
}

