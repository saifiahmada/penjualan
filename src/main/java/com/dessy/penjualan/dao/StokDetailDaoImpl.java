package com.dessy.penjualan.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.StokDetail;
import com.dessy.penjualan.bean.StokGlobal;
import com.dessy.penjualan.common.GenericHibernateDao;
import com.dessy.penjualan.util.DateUtil;

@Repository
public  class StokDetailDaoImpl extends GenericHibernateDao<StokDetail, String> implements StokDetailDao {
	
	public String getNoMesin(String kdItem){
		String sql = "select d from StokDetail d where d.kdItem = :kdItem and d.status = 'A' order by d.noMesin ";
		Query q = getCurrentSession().createQuery(sql);
		q.setString("kdItem", kdItem);
		List<StokDetail> list = q.list();
		StokDetail sd = list.get(0);
		return sd.getNoMesin();
	}
	
	public String getNoRangkaByNoMesin(String noMesin){
		StokDetail sd = (StokDetail) getCurrentSession().get(StokDetail.class, noMesin);
		return sd.getNoRangka();
	}
	
}
