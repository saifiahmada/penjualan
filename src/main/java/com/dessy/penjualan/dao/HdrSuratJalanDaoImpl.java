package com.dessy.penjualan.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.DtlPicklist;
import com.dessy.penjualan.bean.DtlSuratJalan;
import com.dessy.penjualan.bean.DtlSuratJalanPK;
import com.dessy.penjualan.bean.HdrPicklist;
import com.dessy.penjualan.bean.HdrSuratJalan;
import com.dessy.penjualan.bean.MstDealer;
import com.dessy.penjualan.common.GenericHibernateDao;
import com.dessy.penjualan.util.DateConv;
import com.dessy.penjualan.util.StringUtil;
import com.dessy.penjualan.viewmodel.SuratJalanVM;

@Repository
public class HdrSuratJalanDaoImpl extends GenericHibernateDao<HdrSuratJalan, String> implements HdrSuratJalanDao {
	
	@Autowired
	private HdrPicklistDao hdrPicklistDao;
	@Autowired
	private MstRunnumDao mstRunnumDao;
	@Autowired
	private MstDealerDao mstDealerDao;
	
	public String generateSuratJalan(String noPicklist,String kdDlr) {
		
		HdrPicklist pick = hdrPicklistDao.get(noPicklist);
		
		MstDealer dealer = mstDealerDao.get(kdDlr);
		
		String idDoc = "SJ";
		String reseter = DateConv.format(new Date(), "yyyyMM");
		int no = mstRunnumDao.getRunningNumber(idDoc, reseter);
        String noSj = StringUtil.getFormattedRunno(idDoc, Integer.valueOf(no));
		
		HdrSuratJalan sj = new HdrSuratJalan(noSj);
		sj.setAlamatPenerima(dealer.getAlamat()); 
		sj.setKdDlr(kdDlr);
		sj.setNamaPenerima(dealer.getNamaDealer());
		sj.setNoPicklist(noPicklist);
		sj.setStatus("A");
		sj.setTglSj(new Date());
		
		Set<DtlSuratJalan> dtlSjs = new HashSet<DtlSuratJalan>(); 
		
		for (DtlPicklist dtlPick : pick.getDtlpicklists()) {
			String noMesin = dtlPick.getDtlPicklistPK().getNoMesin();
			String kdItem = dtlPick.getKdItem();
			String noRangka = dtlPick.getNoRangka();
			DtlSuratJalan dtlSj = new DtlSuratJalan(new DtlSuratJalanPK(noMesin, noSj));
			dtlSj.setKdItem(kdItem);
			dtlSj.setNoRangka(noRangka);
			dtlSj.setHdrSuratJalan(sj);
			dtlSjs.add(dtlSj);
		}
		
		sj.setDtlSuratJalans(dtlSjs);
		pick.setStatus("B");
		hdrPicklistDao.update(pick);
		super.saveOrUpdate(sj); 
		
		return noSj;
		
	}

}
