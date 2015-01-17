package com.dessy.penjualan.viewmodel;

import java.util.List;


import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.MstUser;
import com.dessy.penjualan.util.PasswordUtil;


public class MstUserVM extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MstUser current;
	
	private ListModelList<MstUser> listModel = new ListModelList<MstUser>();
	
	private String password2;
	
	@Init
	public void init(){
		getCurrent().setVstat("T"); 
		List<MstUser> listUser = getMstService().getMstUserService().findAll();
		listModel.addAll(listUser);
	}
	
	private boolean validasi() {
		if (getCurrent().getVusername() == null || getCurrent().getVusername().equalsIgnoreCase("")) {
			Clients.showNotification("Username kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		if (getCurrent().getVpassword() == null || getCurrent().getVpassword().equalsIgnoreCase("")) {
			Clients.showNotification("Password kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		if (getPassword2() == null || getPassword2().equalsIgnoreCase("")) {
			Clients.showNotification("Confirm Password kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		if (! getPassword2().equals(getCurrent().getVpassword())) { 
			Clients.showNotification("Password dan Confirm Password tidak sama", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		
		if (getCurrent().getVstat() == null || getCurrent().getVstat().equalsIgnoreCase("")) {
			Clients.showNotification("Status kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		
		return true;
	}
	
	@Command("simpan")
	@NotifyChange({"listModel","current","password2"})
	public void simpan(){
		if (! validasi()) {
			return;
		}
		String passwd = PasswordUtil.getMD5Digest(getCurrent().getVpassword());
		getCurrent().setVpassword(passwd); 
		getMstService().getMstUserService().saveOrUpdate(getCurrent());
		Clients.showNotification("Data berhasil disimpan", Clients.NOTIFICATION_TYPE_INFO, null , "top_right", 2000);
		reset();
	}
	
	@Command("cari")
	@NotifyChange({"listModel"})
	public void cari(){
		List<MstUser> list = getMstService().getMstUserService().findByObject(getCurrent());
		listModel = new ListModelList<MstUser>();
		listModel.addAll(list);
	}
	
	@Command("reset")
	@NotifyChange({"listModel","current","password2"})
	public void reset(){
		current = new MstUser();
		List<MstUser> listUser = getMstService().getMstUserService().findAll();
		listModel = new ListModelList<MstUser>();
		listModel.addAll(listUser); 
		setPassword2(null); 
		getCurrent().setVstat("T"); 
	}

	public MstUser getCurrent() {
		if (current == null) {
			current = new MstUser();
		}
		return current;
	}

	public void setCurrent(MstUser current) {
		this.current = current;
	}

	public ListModelList<MstUser> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<MstUser> listModel) {
		this.listModel = listModel;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	

}
