package com.dessy.penjualan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.MstMenu;
import com.dessy.penjualan.common.GenericHibernateDao;

@Repository
public class MstMenuDaoImpl extends GenericHibernateDao<MstMenu, String> implements MstMenuDao { 

	@SuppressWarnings("unchecked")
	public List<MstMenu> findByObject(MstMenu mstMenu){
		Criteria crit = getCurrentSession().createCriteria(MstMenu.class);
		if (mstMenu.getVmenuid() != null) {
			crit = crit.add(Restrictions.eq("vmenuid", mstMenu.getVmenuid()));
		}
		if (mstMenu.getVtitle() != null) {
			System.out.println("vtitle " + mstMenu.getVtitle());
			crit = crit.add(Restrictions.ilike("vtitle", mstMenu.getVtitle(), MatchMode.ANYWHERE));
		}
		if (mstMenu.getVlocation() != null) {
			crit = crit.add(Restrictions.ilike("vlocation", mstMenu.getVlocation(), MatchMode.ANYWHERE));
		}
		if (mstMenu.getVstatus() != null) {
			crit = crit.add(Restrictions.eq("vstatus", mstMenu.getVstatus()));
		}
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MstMenu> findOrderer(){
		String sql = "select m from MstMenu m where m.vstatus = 'T' order by m.norderer asc";
		return getCurrentSession().createQuery(sql).list();
	}
	
}

