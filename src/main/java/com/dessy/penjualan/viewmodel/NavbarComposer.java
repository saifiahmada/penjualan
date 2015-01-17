package com.dessy.penjualan.viewmodel;

import java.awt.MenuItem;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.OpenEvent;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.A;
import org.zkoss.zul.Menu;
import org.zkoss.zul.Menuitem;

import com.dessy.penjualan.util.LoginManager;

public class NavbarComposer extends BasePage {
	
	private static final long serialVersionUID = 1L;

	@Wire
	A atask, anoti, amsg;
	
	@Wire
	Menuitem logout;
	
	@Wire
	Menu menu;
	
	private String user;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		menu.setLabel("Welcome, "+ getUserSession());
		user = getUserSession();
	}
	
	@Listen("onOpen = #taskpp")
	public void toggleTaskPopup(OpenEvent event) {
		toggleOpenClass(event.isOpen(), atask);
	}
	
	@Listen("onOpen = #notipp")
	public void toggleNotiPopup(OpenEvent event) {
		toggleOpenClass(event.isOpen(), anoti);
	}
	
	@Listen("onOpen = #msgpp")
	public void toggleMsgPopup(OpenEvent event) {
		toggleOpenClass(event.isOpen(), amsg);
	}

	// Toggle open class to the component
	public void toggleOpenClass(Boolean open, Component component) {
		HtmlBasedComponent comp = (HtmlBasedComponent) component;
		String scls = comp.getSclass();
		if (open) {
			comp.setSclass(scls + " open");
		} else {
			comp.setSclass(scls.replace(" open", ""));
		}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	@Listen("onClick=#logout")
	public void logout(){
		System.out.println("LOGOUT");
		LoginManager.getIntance().logOff();
		Executions.sendRedirect("index.zul");
	}
	
}
