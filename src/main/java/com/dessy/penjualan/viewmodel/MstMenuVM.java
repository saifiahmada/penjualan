package com.dessy.penjualan.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.MstMenu;
import com.dessy.penjualan.bean.MstMenu;
import com.dessy.penjualan.util.PasswordUtil;


public class MstMenuVM extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MstMenu current;
	
	private ListModelList<MstMenu> listModel = new ListModelList<MstMenu>();
	
	@Init
	public void init(){
		getCurrent().setVstatus("T");
		List<MstMenu> listMenu = getMstService().getMstMenuService().findAll();
		listModel.addAll(listMenu);
		
	}
	
	private boolean validasi() {
		if (getCurrent().getVmenuid() == null || getCurrent().getVmenuid().equalsIgnoreCase("")) {
			Clients.showNotification("Id Menu kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		if (getCurrent().getVtitle() == null || getCurrent().getVtitle().equalsIgnoreCase("")) {
			Clients.showNotification("Title kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		if (getCurrent().getVlocation() == null || getCurrent().getVlocation().equalsIgnoreCase("")) {
			Clients.showNotification("Lokasi kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		if (getCurrent().getVimage() == null || getCurrent().getVimage().equalsIgnoreCase("")) {
			Clients.showNotification("Image kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		if (getCurrent().getVstatus() == null || getCurrent().getVstatus().equalsIgnoreCase("")) {
			Clients.showNotification("Status kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		
		return true;
	}
	
	@Command("simpan")
	@NotifyChange({"listModel","current"})
	public void simpan(){
		if (! validasi()) {
			return;
		}
		
		try {
			getMstService().getMstMenuService().save(getCurrent(), getUserSession());
		} catch (Exception e) {
			getMstService().getMstMenuService().update(getCurrent(), getUserSession());
		}
		
		Clients.showNotification("Data berhasil disimpan", Clients.NOTIFICATION_TYPE_INFO, null , "top_right", 2000);
		reset();
	}
	
	@Command("cari")
	@NotifyChange({"listModel"})
	public void cari(){
		List<MstMenu> list = getMstService().getMstMenuService().findByObject(getCurrent());
		listModel = new ListModelList<MstMenu>();
		listModel.addAll(list);
	}
	
	@Command("reset")
	@NotifyChange({"listModel","current"})
	public void reset(){
		current = new MstMenu();
		List<MstMenu> listMenu = getMstService().getMstMenuService().findAll();
		listModel = new ListModelList<MstMenu>();
		listModel.addAll(listMenu); 
		getCurrent().setVstatus("T"); 
	}

	public MstMenu getCurrent() {
		if (current == null) {
			current = new MstMenu();
		}
		return current;
	}

	public void setCurrent(MstMenu current) {
		this.current = current;
	}

	public ListModelList<MstMenu> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<MstMenu> listModel) {
		this.listModel = listModel;
	}
	

}
