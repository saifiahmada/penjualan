package com.dessy.penjualan.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.MstItem;


public class MstItemVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private MstItem current;
	
	private ListModelList<MstItem> listModel = new ListModelList<MstItem>();
	
	@Init
	public void init(){
		listModel = new ListModelList<MstItem>();
		List<MstItem> listItem = getMstService().getMstItemService().findAll();
		listModel.addAll(listItem);
	}
	
	@Command("cari")
	@NotifyChange({"listModel"}) 
	public void cari(){
		List<MstItem> list = getMstService().getMstItemService().findByObject(getCurrent());
		listModel = new ListModelList<MstItem>();
		listModel.addAll(list);
	}
	
	@Command("reset")
	@NotifyChange({"current","listModel"})
	public void reset(){
		current = new MstItem();
		listModel = new ListModelList<MstItem>();
		List<MstItem> list = getMstService().getMstItemService().findAll();
		listModel.addAll(list);
	}

	public MstItem getCurrent() {
		if (current == null) {
			current = new MstItem();
		}
		return current;
	}

	public void setCurrent(MstItem current) {
		this.current = current;
	}

	public ListModelList<MstItem> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<MstItem> listModel) {
		this.listModel = listModel;
	}
	
	

}
