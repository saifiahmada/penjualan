package com.dessy.penjualan.service;

import java.util.List;
import java.util.Set;

import com.dessy.penjualan.bean.HdrPo;

public abstract interface HdrPoService  { 
	public void save(HdrPo po);
	public void update(HdrPo po);
	public List<HdrPo> findAll();
	public HdrPo get(String key);
	public List<HdrPo> getPOByDealer(String idDealer);
	public List<HdrPo> findListBy(HdrPo hdrPo);
	public void updateStatus(String noPo, String status);
}
