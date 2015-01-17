package com.dessy.penjualan.viewmodel;

import java.util.List;


import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.MstDealer;

public class MstDealerVM extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MstDealer current;
	
	private ListModelList<MstDealer> listModel = new ListModelList<MstDealer>();
	
	@Init
	public void init(){
		
		List<MstDealer> listDealer = getMstService().getMstDealerService().findAll();
		listModel.addAll(listDealer);
	}
	
	private boolean validasi() {
		if (getCurrent().getId() == null || getCurrent().getId().equalsIgnoreCase("")) {
			Clients.showNotification("Id kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		if (getCurrent().getNamaDealer() == null || getCurrent().getNamaDealer().equalsIgnoreCase("")) {
			Clients.showNotification("Nama kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		if (getCurrent().getAlamat() == null || getCurrent().getAlamat().equalsIgnoreCase("")) {
			Clients.showNotification("Alamat kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		if (getCurrent().getTelpon() == null || getCurrent().getTelpon().equalsIgnoreCase("")) {
			Clients.showNotification("Telpon kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		if (getCurrent().getPimpinan() == null || getCurrent().getPimpinan().equalsIgnoreCase("")) {
			Clients.showNotification("Pimpinan kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return false;
		}
		if (getCurrent().getNpwp() == null || getCurrent().getNpwp().equalsIgnoreCase("")) {
			Clients.showNotification("NPWP kosong", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
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
		getMstService().getMstDealerService().saveOrUpdate(getCurrent(), getUserSession());
		Clients.showNotification("Data berhasil disimpan", Clients.NOTIFICATION_TYPE_INFO, null , "top_right", 2000);
		reset();
	}
	
	@Command("cari")
	@NotifyChange({"listModel"})
	public void cari(){
		List<MstDealer> list = getMstService().getMstDealerService().findByObject(getCurrent());
		listModel = new ListModelList<MstDealer>();
		listModel.addAll(list);
		
	}
	
	@Command("reset")
	@NotifyChange({"listModel","current","password2"})
	public void reset(){
		current = new MstDealer();
		List<MstDealer> listDealer = getMstService().getMstDealerService().findAll();
		listModel = new ListModelList<MstDealer>();
		listModel.addAll(listDealer); 
		 
	}

	public MstDealer getCurrent() {
		if (current == null) {
			current = new MstDealer();
		}
		return current;
	}

	public void setCurrent(MstDealer current) {
		this.current = current;
	}

	public ListModelList<MstDealer> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<MstDealer> listModel) {
		this.listModel = listModel;
	}

}
