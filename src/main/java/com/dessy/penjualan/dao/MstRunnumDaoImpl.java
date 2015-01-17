package com.dessy.penjualan.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.MstRunnum;
import com.dessy.penjualan.common.GenericHibernateDao;

@Repository
public class MstRunnumDaoImpl extends GenericHibernateDao<MstRunnum, String> implements MstRunnumDao {
	
	public int getRunningNumber(String idDoc, String reseter) {
		// TODO , masbro
		
		String sq = "select r from MstRunnum r where r.mstRunnumPK.idDoc = :idDoc and r.mstRunnumPK.reseter = :reseter ";
		
		Query q = getCurrentSession().createQuery(sq);
		q.setString("idDoc", idDoc);
		q.setString("reseter", reseter);
		List<MstRunnum> list = q.list();
		MstRunnum runnum;
		if (list.size() == 0){
			runnum = new MstRunnum(idDoc,reseter);
			runnum.setRunnum(0);
			
		} else {
			runnum = list.get(0);
		}
		Integer temp = runnum.getRunnum();
		temp = temp + 1;
		runnum.setRunnum(temp);
		
		getCurrentSession().saveOrUpdate(runnum);
		
		return runnum.getRunnum();
	}

}
