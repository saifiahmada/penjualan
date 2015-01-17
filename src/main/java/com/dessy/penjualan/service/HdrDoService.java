package com.dessy.penjualan.service;

import java.util.List;

import com.dessy.penjualan.bean.HdrDo;


public abstract interface HdrDoService {
	public void saveOrUpdate(HdrDo hdrDo);
	public List<HdrDo> findByStatusAnKodeDealer(String status, String kdDlr);
	public void update(HdrDo hdrDo);
	public String saveTransaksi(HdrDo newEntity);
	public String prosesFaktur(String noDO, String kdDlr);
	public List<HdrDo> findAll();
}
