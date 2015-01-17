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

import com.dessy.penjualan.bean.MstDealer;
import com.dessy.penjualan.bean.MstDealer;


public class PopupDealerVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private MstDealer current;
	
	private ListModelList<MstDealer> listModel = new ListModelList<MstDealer>();
	
	@Init
	public void init(){
		current = new MstDealer();
		listModel = new ListModelList<MstDealer>();
		List<MstDealer> list = getMstService().getMstDealerService().findAll();
		listModel.addAll(list);
	}
	
	@Command("reset")
	@NotifyChange({"current","listModel"})
	public void reset(){
		current = new MstDealer();
		listModel = new ListModelList<MstDealer>();
		List<MstDealer> list = getMstService().getMstDealerService().findAll();
		listModel.addAll(list);
	}
	
	@Command("cari")
	public void cari(){
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Command("pilih")
	public void pilih(@ContextParam (ContextType.VIEW) Component view){
		Map param = new HashMap();
		param.put("paramDealer", getCurrent());
		Binder bind = (Binder) view.getParent().getAttribute("binder");
		if (bind == null) return;
		bind.postCommand("sendParamDealer", param);
		view.detach();
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
