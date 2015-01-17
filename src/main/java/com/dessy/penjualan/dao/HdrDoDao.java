package com.dessy.penjualan.dao;

import java.util.List;

import com.dessy.penjualan.bean.HdrDo;
import com.dessy.penjualan.common.GenericDao;

public abstract interface HdrDoDao extends GenericDao<HdrDo, String> {
	public List<HdrDo> findByStatusAnKodeDealer(String status, String kdDlr);
	public String saveTransaksi(HdrDo newEntity);
	public String prosesFaktur(String noDO, String kdDlr);
}
