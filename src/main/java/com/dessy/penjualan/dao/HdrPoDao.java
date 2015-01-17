package com.dessy.penjualan.dao;

import java.util.List;
import java.util.Set;

import com.dessy.penjualan.bean.HdrPo;
import com.dessy.penjualan.common.GenericDao;

public abstract interface HdrPoDao extends GenericDao<HdrPo, String> { 
	public List<HdrPo> getPOByDealer(String idDealer);
	public List<HdrPo> findListBy(HdrPo hdrPo);
	public void updateStatus(String noPo, String status);
}
