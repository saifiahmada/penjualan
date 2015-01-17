package com.dessy.penjualan.viewmodel;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.zkoss.zk.ui.Component;


import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;

import com.dessy.penjualan.util.MstService;


public class BasePage extends SelectorComposer<Component> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String userSession;
	
	private MstService mstService;

	public MstService getMstService() {
		this.mstService = (MstService) SpringUtil.getBean("mstService");
		return mstService;
	}

	public static String getUserSession() {
		String userName = (String) Sessions.getCurrent().getAttribute("username");
		userSession = userName;
		return userSession;
	}

	public static void setUserSession(String userSession) {
		BasePage.userSession = userSession;
	}
	
	public Connection getReportConnection(){
		
		DataSource ds = (DataSource) SpringUtil.getBean("dataSource");
		Connection con = DataSourceUtils.getConnection(ds);
		return con;
	}


}
