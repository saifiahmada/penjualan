package com.dessy.penjualan.dao;

import org.springframework.stereotype.Repository;

import com.dessy.penjualan.bean.DtlPo;
import com.dessy.penjualan.common.GenericHibernateDao;

@Repository
public class DtlPoDaoImpl extends GenericHibernateDao<DtlPo, String> implements DtlPoDao {

}
