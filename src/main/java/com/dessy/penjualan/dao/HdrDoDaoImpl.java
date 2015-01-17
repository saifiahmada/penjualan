package com.dessy.penjualan.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.DtlDo;
import com.dessy.penjualan.bean.HdrDo;
import com.dessy.penjualan.bean.MstDealer;
import com.dessy.penjualan.common.GenericHibernateDao;
import com.dessy.penjualan.util.DateConv;
import com.dessy.penjualan.util.StringUtil;

@Repository
public class HdrDoDaoImpl extends GenericHibernateDao<HdrDo, String> implements
		HdrDoDao {

	@Autowired
	private MstRunnumDao mstRunnumDao;
	@Autowired
	private HdrPoDao hdrPoDao;
	@Autowired
	private MstDealerDao mstDealerDao; 

	public String saveTransaksi(HdrDo newEntity) {

		String idDoc = "DO";
		String reseter = DateConv.format(new Date(), "yyyyMM");
		int no = mstRunnumDao.getRunningNumber(idDoc, reseter);
		String noDO = StringUtil.getFormattedRunno(idDoc, Integer.valueOf(no));

		newEntity.setNoDo(noDO);
		for (DtlDo dtlDo : newEntity.getDtlDos()) {
			dtlDo.getDtlDoPK().setNoDo(noDO);
		}

		// update status PO
		hdrPoDao.updateStatus(newEntity.getNoPo(), "B");
		newEntity.setTglDO(new Date()); 
		super.saveOrUpdate(newEntity);  
		return noDO;
	}

	@SuppressWarnings("unchecked")
	public List<HdrDo> findByStatusAnKodeDealer(String status, String kdDlr) {
		String sql = "";
		if (kdDlr == null) {
			sql = "from HdrDo d where d.status = :status";
		} 
		if (status == null) {
			sql = "from HdrDo d where d.kdDlr = :kdDlr";
		}
		
		if (kdDlr != null && status != null) {
			sql = "from HdrDo d where d.status = :status and d.kdDlr = :kdDlr";
		}
		
		Query q = getCurrentSession().createQuery(sql);
		
		if (kdDlr == null) {
			q.setString("status", status);
			
		} 
		if (status == null) {
			q.setString("kdDlr", kdDlr);
		}
		
		if (kdDlr != null && status != null) {
			q.setString("kdDlr", kdDlr);
			q.setString("status", status);
		}
		System.out.println("SQL = " + sql);
		return q.list();
	}
	
	public String prosesFaktur(String noDO, String kdDlr){
		
		String idDoc = "FAK";
		String reseter = DateConv.format(new Date(), "yyyyMM");
		int no = mstRunnumDao.getRunningNumber(idDoc, reseter);
        String noFaktur = StringUtil.getFormattedRunno(idDoc, Integer.valueOf(no));
        
		HdrDo hdrDo = super.get(noDO);
		hdrDo.setNoFaktur(noFaktur);
		
		MstDealer mstDealer = mstDealerDao.get(kdDlr);
		
		hdrDo.setAlamatTagihan(mstDealer.getAlamat());
		hdrDo.setNamaPenerima(mstDealer.getNamaDealer()); 
		hdrDo.setTglFaktur(new Date()); 
		hdrDo.setStatus("C");
		
		super.update(hdrDo); 
		return noFaktur;
	}

}
