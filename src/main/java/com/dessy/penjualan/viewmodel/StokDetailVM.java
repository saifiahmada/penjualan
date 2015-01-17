package com.dessy.penjualan.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.StokDetail;


public class StokDetailVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private StokDetail current;
	
	private ListModelList<StokDetail> listModel = new ListModelList<StokDetail>();
	
	@Init
	public void init(){
		listModel = new ListModelList<StokDetail>();
		List<StokDetail> list = getMstService().getStokDetailService().findAll();
		listModel.addAll(list);
	}

	public StokDetail getCurrent() {
		return current;
	}

	public void setCurrent(StokDetail current) {
		this.current = current;
	}

	public ListModelList<StokDetail> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<StokDetail> listModel) {
		this.listModel = listModel;
	}
	

}
