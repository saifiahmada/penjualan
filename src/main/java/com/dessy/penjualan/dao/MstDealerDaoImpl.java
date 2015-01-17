package com.dessy.penjualan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.MstDealer;
import com.dessy.penjualan.common.GenericHibernateDao;
import com.dessy.penjualan.util.DateUtil;

@Repository
public class MstDealerDaoImpl extends GenericHibernateDao<MstDealer, String> implements MstDealerDao {
	
	@SuppressWarnings("unchecked")
	public List<MstDealer> findByObject(MstDealer mstDealer){
		Criteria crit = getCurrentSession().createCriteria(MstDealer.class);
		if (mstDealer.getId() != null) {
			crit = crit.add(Restrictions.eq("id", mstDealer.getId()));
		}
		if (mstDealer.getNamaDealer() != null) {
			crit = crit.add(Restrictions.ilike("namaDealer", mstDealer.getNamaDealer(), MatchMode.ANYWHERE));
		}
		if (mstDealer.getAlamat() != null) {
			crit = crit.add(Restrictions.ilike("alamat", mstDealer.getAlamat(), MatchMode.ANYWHERE));
		}
		if (mstDealer.getNpwp() != null) {
			crit = crit.add(Restrictions.eq("npwp", mstDealer.getNpwp()));
		}
		if (mstDealer.getPimpinan() != null) {
			crit = crit.add(Restrictions.ilike("pimpinan", mstDealer.getPimpinan(),MatchMode.ANYWHERE));
		}
		if (mstDealer.getTelpon() != null) {
			crit = crit.add(Restrictions.eq("telpon", mstDealer.getTelpon()));
		}
		return crit.list();
	}
	
}
