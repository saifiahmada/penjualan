package com.dessy.penjualan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.MstDealer;
import com.dessy.penjualan.bean.MstUser;
import com.dessy.penjualan.common.GenericHibernateDao;
import com.dessy.penjualan.util.DateUtil;

@Repository
public class MstUserDaoImpl extends GenericHibernateDao<MstUser, String> implements MstUserDao {
	
	public MstUser findUserByUsername(String username) {
		String hql = "from MstUser a where a.vusername = :username";
		Query q = getCurrentSession().createQuery(hql);
		q.setString("username", username);
		return (MstUser) q.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<MstUser> findByObject(MstUser mstUser){
		Criteria crit = getCurrentSession().createCriteria(MstUser.class);
		if (mstUser.getVusername() != null) {
			crit = crit.add(Restrictions.eq("vusername", mstUser.getVusername()));
		}
		if (mstUser.getVstat() != null) {
			crit = crit.add(Restrictions.eq("vstat", mstUser.getVstat()));
		}
		return crit.list();
	}

		
}

