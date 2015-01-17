package com.dessy.penjualan.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dessy.penjualan.bean.DtlPo;
import com.dessy.penjualan.bean.HdrPo;
import com.dessy.penjualan.bean.StokGlobal;
import com.dessy.penjualan.common.GenericService;
import com.dessy.penjualan.dao.StokGlobalDao;

@Service
@Transactional
public class StokGlobalServiceImpl extends GenericService implements StokGlobalService {

	@Autowired
	private StokGlobalDao dao;

	public List<StokGlobal> findAll() {
		return dao.findAll();
	}
	
	public boolean isOKCekStok(HdrPo hdrPO){
		boolean bool = false;
		Set<DtlPo> listDtl = hdrPO.getDtlPos();
		for (DtlPo po : listDtl) {
			Integer qty = getStokByKdItem(po.getDtlPoPK().getKdItem());
			if (qty > po.getQty()) {
				System.out.println("qty stok = " + qty);
				System.out.println("qty PO = " + po.getQty());
				bool = true; 
			} else {
				return false;
			}
		}
		
		return bool;
	}

	public Integer getStokByKdItem(String kdItem) {
		return dao.getStokByKdItem(kdItem); 
	}

	public void saveOrUpdate(StokGlobal domain) {
		dao.saveOrUpdate(domain); 
	}

	public void updateStok(String kdItem, Integer qtyPick) {
		dao.updateStok(kdItem, qtyPick); 
	}

	
}
