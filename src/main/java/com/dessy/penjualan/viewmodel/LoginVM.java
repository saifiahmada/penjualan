package com.dessy.penjualan.viewmodel;

import java.util.Random;




import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;

import com.dessy.penjualan.util.LoginManager;
import com.dessy.penjualan.util.PasswordUtil;

public class LoginVM extends BasePage {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;

	@Init
	public void init(){

	}


	public void onClick$btnLogin(){
		doLogin();
	}

	@Command
	public void onOk(){
		doLogin();
	}

	@Command
	public void doLogin(){
		if(getUserName() == null || getPassword() == null){
			alert("Username dan Password Harus Diisi");
			return;
		}

		LoginManager lm = LoginManager.getIntance(Sessions.getCurrent());
		Sessions.getCurrent().setAttribute("username", getUserName());

		String encryptedPassword = PasswordUtil.getMD5Digest(getPassword());

		lm.logIn(getUserName(), encryptedPassword);

		if(lm.isAuthenticated()){
			System.out.println("login success");
			Executions.sendRedirect("index.zul");
		}else{
			alert("Login gagal, username/password salah");
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
