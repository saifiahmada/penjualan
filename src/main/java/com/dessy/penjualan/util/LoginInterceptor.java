package com.dessy.penjualan.util;

import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

public class LoginInterceptor implements Initiator {

	public void doInit(Page arg0, Map<String, Object> arg1) throws Exception {
		if(!LoginManager.getIntance().isAuthenticated()){
			Executions.sendRedirect("login.zul");
		}
	}

}
