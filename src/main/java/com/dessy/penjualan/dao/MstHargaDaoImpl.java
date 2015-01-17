package com.dessy.penjualan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.MstHarga;
import com.dessy.penjualan.common.GenericHibernateDao;
@Repository
public class MstHargaDaoImpl extends GenericHibernateDao<MstHarga, String> implements MstHargaDao {
	
	@SuppressWarnings("unchecked")
	public List<MstHarga> findByObject(MstHarga mstHarga) {
		
		Criteria crit = getCurrentSession().createCriteria(MstHarga.class);
		if (mstHarga.getKdItem() != null) {
			crit = crit.add(Restrictions.eq("kdItem", mstHarga.getKdItem()));
		}
		if (mstHarga.getBbn() != null) {
			crit = crit.add(Restrictions.eq("bbn", mstHarga.getBbn()));
		}
		if (mstHarga.getHrgKmp() != null) {
			crit = crit.add(Restrictions.eq("hdrKmp", mstHarga.getHrgKmp()));
		}
		if (mstHarga.getHrgKsg() != null) {
			crit = crit.add(Restrictions.eq("hdrKsg", mstHarga.getHrgKsg()));
		}
		
		return crit.list();
		
	}
	
}
