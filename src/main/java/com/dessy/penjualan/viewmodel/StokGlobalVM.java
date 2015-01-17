package com.dessy.penjualan.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.StokGlobal;


public class StokGlobalVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private StokGlobal current;
	
	private ListModelList<StokGlobal> listModel = new ListModelList<StokGlobal>();
	
	@Init
	public void init(){
		listModel = new ListModelList<StokGlobal>();
		List<StokGlobal> list = getMstService().getStokGlobalService().findAll();
		listModel.addAll(list);
		
	}

	public ListModelList<StokGlobal> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<StokGlobal> listModel) {
		this.listModel = listModel;
	}

	public StokGlobal getCurrent() {
		if (current == null) {
			current = new StokGlobal();
		}
		return current;
	}

	public void setCurrent(StokGlobal current) {
		this.current = current;
	}
	
	
	

}
