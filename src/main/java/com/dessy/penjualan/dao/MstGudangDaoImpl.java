package com.dessy.penjualan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.MstGudang;
import com.dessy.penjualan.common.GenericHibernateDao;

@Repository
public class MstGudangDaoImpl extends GenericHibernateDao<MstGudang, String> implements MstGudangDao {

	@SuppressWarnings("unchecked")
	public List<MstGudang> findByObject(MstGudang mstGudang){
		Criteria crit = getCurrentSession().createCriteria(MstGudang.class);
		
		if (mstGudang.getId() == null) {
			crit = crit.add(Restrictions.eq("id", mstGudang.getId()));
		}
		if (mstGudang.getNamaGudang() == null) {
			crit = crit.add(Restrictions.eq("namaGudang", mstGudang.getNamaGudang()));
		}
		return crit.list();
		
	}
}
