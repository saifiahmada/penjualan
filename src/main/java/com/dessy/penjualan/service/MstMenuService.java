package com.dessy.penjualan.service;

import java.util.List;

import com.dessy.penjualan.bean.MstMenu;



public abstract interface MstMenuService  { 
	
	public void save(MstMenu mstMenu, String user);
	public void update(MstMenu mstMenu, String user);
	public List<MstMenu> findAll();
	public List<MstMenu> findByObject(MstMenu mstMenu);
	public List<MstMenu> findOrderer();

}

