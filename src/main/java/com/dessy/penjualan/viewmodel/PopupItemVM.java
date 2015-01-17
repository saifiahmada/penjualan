package com.dessy.penjualan.viewmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.MstItem;
import com.dessy.penjualan.bean.MstItem;


public class PopupItemVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private MstItem current;
	
	private ListModelList<MstItem> listModel = new ListModelList<MstItem>();
	
	@Init
	public void init(){
		current = new MstItem();
		listModel = new ListModelList<MstItem>();
		List<MstItem> list = getMstService().getMstItemService().findAll();
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
	
	@Command("cari")
	@NotifyChange({"listModel"})
	public void cari(){
		List<MstItem> list = getMstService().getMstItemService().findByObject(getCurrent());
		listModel = new ListModelList<MstItem>();
		listModel.addAll(list);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Command("pilih")
	public void pilih(@ContextParam (ContextType.VIEW) Component view){
		Map param = new HashMap();
		param.put("param", getCurrent());
		Binder bind = (Binder) view.getParent().getAttribute("binder");
		if (bind == null) return;
		bind.postCommand("sendParam", param);
		view.detach();
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
