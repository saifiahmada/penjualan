package com.dessy.penjualan.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.DtlDo;
import com.dessy.penjualan.bean.DtlPicklist;
import com.dessy.penjualan.bean.DtlPicklistPK;
import com.dessy.penjualan.bean.HdrDo;
import com.dessy.penjualan.bean.HdrPicklist;
import com.dessy.penjualan.bean.StokDetail;
import com.dessy.penjualan.common.GenericHibernateDao;
import com.dessy.penjualan.util.DateConv;
import com.dessy.penjualan.util.StringUtil;

@Repository
public class HdrPicklistDaoImpl extends GenericHibernateDao<HdrPicklist, String> implements HdrPicklistDao { 
	
	@Autowired
	private HdrDoDao hdrDoDao;
	
	@Autowired
	private StokDetailDao stokDetailDao;
	
	@Autowired
	private StokGlobalDao stokGlobalDao;
	@Autowired
	private MstRunnumDao mstRunnumDao;
	
	public HdrPicklist prosesPicklist(String noDo){
		
		String idDoc = "PL";
		String reseter = DateConv.format(new Date(), "yyyyMM");
		int no = mstRunnumDao.getRunningNumber(idDoc, reseter);
        String noPicklist = StringUtil.getFormattedRunno(idDoc, Integer.valueOf(no));
		
		HdrPicklist hdrPicklist = new HdrPicklist(noPicklist);
		
		HdrDo hdrDo = hdrDoDao.get(noDo);
		Set<DtlDo> dtlDos = hdrDo.getDtlDos();
		
		hdrPicklist.setLokasi("G13");
		hdrPicklist.setStatus("A");
		hdrPicklist.setTglPick(new Date()); 
		hdrPicklist.setKdDlr(hdrDo.getKdDlr()); 
		Set<DtlPicklist> dtlPicks = new HashSet<DtlPicklist>();
		for (DtlDo dtlDo : dtlDos) {
			String kdItem = dtlDo.getDtlDoPK().getKdItem();
			Long qty = dtlDo.getQty();
			for (int i=0; i<qty; i++) {
				String noMesin = stokDetailDao.getNoMesin(kdItem);
				String noRangka = stokDetailDao.getNoRangkaByNoMesin(noMesin);
				System.out.println("NOMESIN = " + noMesin);
				System.out.println("NOPick  = " + noPicklist);
				DtlPicklist dtlPick = new DtlPicklist(noPicklist, noMesin);
				dtlPick.setKdItem(kdItem);
				dtlPick.setNoRangka(noRangka);
				dtlPick.setHdrPicklist(hdrPicklist);
				dtlPicks.add(dtlPick);
				//update status B untuk nomesin pada stok_detail
				StokDetail stokDetail = stokDetailDao.get(noMesin);
				stokDetail.setStatus("B");
				stokDetailDao.update(stokDetail);
				
				
			}
			//kurangi stok_global sejumlah qty
			stokGlobalDao.updateStok(kdItem, qty.intValue());
			
		}
		hdrDo.setStatus("B");
		hdrDoDao.update(hdrDo);
		hdrPicklist.setDtlpicklists(dtlPicks); 
		getCurrentSession().saveOrUpdate(hdrPicklist); 
		return hdrPicklist;
	}
	
	@SuppressWarnings("unchecked")
	public List<HdrPicklist> findByStatusAndKdDlr(String kdDlr, String status){
		String sql = "select p from HdrPicklist p where p.kdDlr = :kdDlr and p.status = :status";
		Query q = getCurrentSession().createQuery(sql);
		q.setString("kdDlr", kdDlr);
		q.setString("status", status);
		return q.list();
	}
	
}
