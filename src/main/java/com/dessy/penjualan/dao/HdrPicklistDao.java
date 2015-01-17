package com.dessy.penjualan.dao;

import java.util.List;

import com.dessy.penjualan.bean.HdrPicklist;
import com.dessy.penjualan.common.GenericDao;

public abstract interface HdrPicklistDao extends GenericDao<HdrPicklist, String> {
	public HdrPicklist prosesPicklist(String noDo);
	public List<HdrPicklist> findByStatusAndKdDlr(String kdDlr, String status);
}
