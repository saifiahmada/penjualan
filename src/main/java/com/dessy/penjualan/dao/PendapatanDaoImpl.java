package com.dessy.penjualan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.MstHarga;
import com.dessy.penjualan.bean.Pendapatan;
import com.dessy.penjualan.common.GenericHibernateDao;
@Repository
public class PendapatanDaoImpl extends GenericHibernateDao<Pendapatan, String> implements PendapatanDao {
	
	@SuppressWarnings("unchecked")
	public List<Pendapatan> getListByKdItem(String kdItem){
		String sql = "select p from Pendapatan p where p.kdItem = :kdItem";
		Query query = getCurrentSession().createQuery(sql);
		query.setString("kdItem", kdItem);
		return query.list();
	}
	
}
