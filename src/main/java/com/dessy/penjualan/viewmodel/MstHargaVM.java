package com.dessy.penjualan.viewmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.MstDealer;
import com.dessy.penjualan.bean.MstHarga;
import com.dessy.penjualan.bean.MstItem;


public class MstHargaVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private MstHarga current;
	
	private ListModelList<MstHarga> listModel = new ListModelList<MstHarga>();
	
	@Init
	public void init(){
		listModel = new ListModelList<MstHarga>();
		List<MstHarga> listItem = getMstService().getMstHargaService().findAll();
		listModel.addAll(listItem);
	}
	
	@Command("pilihData")
	public void pilihData(@ContextParam (ContextType.VIEW) Component view){
		Executions.getCurrent().createComponents("popupItem.zul", view, null);
	}
	
	@Command
	@NotifyChange({"current"})
	public void sendParam(@BindingParam("param") MstItem mstItem) {
		String kdItem = mstItem.getKdItem();
		current = new MstHarga();
		current.setKdItem(kdItem);
	}

	@Command("cari")
	@NotifyChange({"listModel"})
	public void cari(){
		
		listModel = new ListModelList<MstHarga>();
		List<MstHarga> list = getMstService().getMstHargaService().findByObject(getCurrent());
		listModel.addAll(list);
	}
	
	@Command("simpan")
	@NotifyChange({"listModel","current"})
	public void simpan(){
		System.out.println("memanggil method ini");
		getMstService().getMstHargaService().saveOrUpdate(getCurrent());
		reset();
	}
	
	@Command("reset")
	@NotifyChange({"listModel","current"})
	public void reset(){
		current = new MstHarga();
		listModel = new ListModelList<MstHarga>();
		List<MstHarga> list = getMstService().getMstHargaService().findAll();
		listModel.addAll(list);
	}
	
	
	
	public MstHarga getCurrent() {
		if (current == null) {
			current = new MstHarga();
		}
		return current;
	}

	public void setCurrent(MstHarga current) {
		this.current = current;
	}

	public ListModelList<MstHarga> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<MstHarga> listModel) {
		this.listModel = listModel;
	}

	
	
	

}
