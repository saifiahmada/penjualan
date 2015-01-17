package com.dessy.penjualan.util;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import com.dessy.penjualan.bean.MstUser;
import com.dessy.penjualan.viewmodel.BasePage;

public class LoginManager extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private static final String KEY_USER_MODEL = LoginManager.class
			.getName()+"_MODEL";
	
	private MstUser user;
	
	public LoginManager() {

	}
	
	public static LoginManager getIntance(){
		return getIntance(Sessions.getCurrent());
	}
	
	public static LoginManager getIntance(Session zkSession){
		
		synchronized (zkSession) {
			LoginManager loginModel = (LoginManager) zkSession.getAttribute(KEY_USER_MODEL);
			if(loginModel == null){
				zkSession.setAttribute(KEY_USER_MODEL, 
						loginModel = new LoginManager());
			}
			return loginModel;
		}
		
	}
	
	public synchronized void logIn(String name, String password){
		 
		MstUser mstUser = getMstService().getMstUserService().findUserByUsername(name);
		
		if(mstUser  != null && mstUser.getVpassword().equals(password)){
			user = mstUser ;
		}else{
			user = null;
		}
	}
	
	public void logOff(){
		user = null;
	}
	
	public synchronized MstUser getUser(){
		return user;
	}
	
	public synchronized boolean isAuthenticated(){
		return user != null;
	}
	

}
