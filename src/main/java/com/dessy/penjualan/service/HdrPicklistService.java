package com.dessy.penjualan.service;

import java.util.List;

import com.dessy.penjualan.bean.HdrPicklist;

public interface HdrPicklistService {
	public void saveOrUpdate(HdrPicklist hdrPicklist);
	public HdrPicklist prosesPicklist(String noDo);
	public List<HdrPicklist> findByStatusAndKdDlr(String kdDlr, String status);
	public HdrPicklist get(String key);
}
