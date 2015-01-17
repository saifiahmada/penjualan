package com.dessy.penjualan.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.StokGlobal;
import com.dessy.penjualan.common.GenericHibernateDao;
import com.dessy.penjualan.util.DateUtil;

@Repository
public class StokGlobalDaoImpl extends GenericHibernateDao<StokGlobal, String> implements StokGlobalDao {
	
	public Integer getStokByKdItem(String kdItem){
		Integer qty = (Integer) getCurrentSession().createQuery("select s.qty from StokGlobal s where s.kdItem = :kdItem").setString("kdItem", kdItem).uniqueResult();
		return qty;
	}
	
	public void updateStok(String kdItem, Integer qtyPick ){
		StokGlobal sg = (StokGlobal) getCurrentSession().get(StokGlobal.class, kdItem);
		Integer stokAsal = sg.getQty();
		Integer stokAkhir = stokAsal - qtyPick;
		sg.setQty(stokAkhir);
		getCurrentSession().saveOrUpdate(sg); 
		
	}
	
}
