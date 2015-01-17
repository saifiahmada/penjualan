package com.dessy.penjualan.viewmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.HdrPicklist;


public class PopupPickingVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private String kdDlr;
	
	private HdrPicklist current;
	
	private ListModelList<HdrPicklist> listModel = new ListModelList<HdrPicklist>();
	
	@SuppressWarnings("unchecked")
	@Init
	public void init(){
		
		Map<String, Object> map =  (HashMap<String, Object>) Executions.getCurrent().getArg();
		System.out.println("KD DEALER " + map.get("kdDealer"));
		kdDlr = (String) map.get("kdDealer");
		
		List<HdrPicklist> list = getMstService().getHdrPickinglistService().findByStatusAndKdDlr(kdDlr, "A");
		listModel = new ListModelList<HdrPicklist>();
		listModel.addAll(list);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Command("pilih")
	public void pilih(@ContextParam (ContextType.VIEW) Component view){
		Map param = new HashMap();
		param.put("paramPick", getCurrent());
		Binder bind = (Binder) view.getParent().getAttribute("binder");
		if (bind == null) return;
		bind.postCommand("sendParamPick", param);
		view.detach();
	}

	public HdrPicklist getCurrent() {
		if (current == null) {
			current = new HdrPicklist();
		}
		return current;
	}

	public void setCurrent(HdrPicklist current) {
		this.current = current;
	}

	public ListModelList<HdrPicklist> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<HdrPicklist> listModel) {
		this.listModel = listModel;
	}

	public String getKdDlr() {
		return kdDlr;
	}

	public void setKdDlr(String kdDlr) {
		this.kdDlr = kdDlr;
	}
	
	
	

}
