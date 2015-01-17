package com.dessy.penjualan.service;

import java.util.List;

import com.dessy.penjualan.bean.Pendapatan;

public interface PendapatanService {
	public void saveOrUpdate(Pendapatan pendapatan);
	public List<Pendapatan> findAll();
	public Pendapatan get(String noMesin);
	public List<Pendapatan> getListByKdItem(String kdItem);
}
