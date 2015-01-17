package com.dessy.penjualan.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.MstItem;
import com.dessy.penjualan.common.GenericHibernateDao;

@Repository
public class MstItemDaoImpl extends GenericHibernateDao<MstItem, String> implements MstItemDao {
	
	@SuppressWarnings("unchecked")
	public List<MstItem> findByObject(MstItem mstItem){
		Criteria crit = getCurrentSession().createCriteria(MstItem.class);
		if (mstItem.getKdItem() != null) {
			crit = crit.add(Restrictions.ilike("kdItem", mstItem.getKdItem(), MatchMode.ANYWHERE));
		}
		if (mstItem.getNama() != null) {
			crit = crit.add(Restrictions.ilike("nama", mstItem.getNama(), MatchMode.ANYWHERE));
		}
		if (mstItem.getTipe() != null) {
			crit = crit.add(Restrictions.ilike("tipe", mstItem.getTipe(), MatchMode.ANYWHERE));
		}
		if (mstItem.getWarna() != null) {
			crit = crit.add(Restrictions.ilike("warna", mstItem.getWarna(), MatchMode.ANYWHERE));
		}
		return crit.list();
	}
	
}                  
