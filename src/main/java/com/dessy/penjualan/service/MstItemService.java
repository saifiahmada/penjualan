package com.dessy.penjualan.service;

import java.util.List;

import com.dessy.penjualan.bean.MstItem;

public abstract interface MstItemService {
	public void saveOrUpdate(MstItem mstItem, String user);
	public void save(MstItem mstItem, String user);
	public void update(MstItem mstItem, String user);
	public List<MstItem> findAll();
	public List<MstItem> findByObject(MstItem mstItem);
}
