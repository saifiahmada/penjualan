package com.dessy.penjualan.dao;

import java.util.List;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.HdrPo;
import com.dessy.penjualan.common.GenericHibernateDao;

@Repository
public class HdrPoDaoImpl extends GenericHibernateDao<HdrPo, String> implements HdrPoDao {
	
	@SuppressWarnings("unchecked")
	public List<HdrPo> getPOByDealer(String idDealer){
		return getCurrentSession().createQuery("select h from HdrPo h where h.status = 'A' and h.idDealer = :idDealer").setString("idDealer", idDealer).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<HdrPo> findListBy(HdrPo hdrPo){
		
		Criteria crit = getCurrentSession().createCriteria(HdrPo.class);
		if (hdrPo.getIdDealer() != null) {
			crit = crit.add(Restrictions.eq("idDealer", hdrPo.getIdDealer()));
		}
		if (hdrPo.getNoPo() != null) {
			crit = crit.add(Restrictions.eq("noPo", hdrPo.getNoPo()));
		}
		if (hdrPo.getStatus() != null) {
			crit = crit.add(Restrictions.eq("status", hdrPo.getStatus()));
		}
		if (hdrPo.getTglPo() != null) {
			crit = crit.add(Restrictions.eq("tglPo", hdrPo.getTglPo()));
		}
		return crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
	
	public void updateStatus(String noPo, String status){
		String sql = "update HdrPo set status = :status where noPo = :noPo";
		Query q = getCurrentSession().createQuery(sql);
		q.setString("status", status);
		q.setString("noPo", noPo);
		int i = q.executeUpdate();
		System.out.println("updateLOG = " + i);
		
	}
	
}
