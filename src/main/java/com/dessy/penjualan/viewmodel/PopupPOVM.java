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

import com.dessy.penjualan.bean.HdrPo;


public class PopupPOVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private HdrPo current;
	
	private ListModelList<HdrPo> listModel = new ListModelList<HdrPo>();
	
	private String kdDealer;
	
	@SuppressWarnings("unchecked")
	@Init
	public void init(){
		
		Map<String, Object> map =  (HashMap<String, Object>) Executions.getCurrent().getArg();
		kdDealer = (String) map.get("kdDealer");
		current = new HdrPo();
		listModel = new ListModelList<HdrPo>();
		List<HdrPo> listPO = getMstService().getHdrPoService().getPOByDealer(kdDealer);
		listModel.addAll(listPO);
		
	}
	
	@Command("reset")
	@NotifyChange({"current","listModel"})
	public void reset(){
		current = new HdrPo();
		listModel = new ListModelList<HdrPo>();
		List<HdrPo> listPO = getMstService().getHdrPoService().getPOByDealer(kdDealer);
		listModel.addAll(listPO);
	}
	
	@Command("cari")
	public void cari(){
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Command("pilih")
	public void pilih(@ContextParam (ContextType.VIEW) Component view){
		Map param = new HashMap();
		param.put("paramPO", getCurrent().getNoPo());
		Binder bind = (Binder) view.getParent().getAttribute("binder");
		if (bind == null) return;
		bind.postCommand("sendParamPO", param);
		view.detach();
	}

	public String getKdDealer() {
		return kdDealer;
	}

	public void setKdDealer(String kdDealer) {
		this.kdDealer = kdDealer;
	}

	public HdrPo getCurrent() {
		return current;
	}

	public void setCurrent(HdrPo current) {
		this.current = current;
	}

	public ListModelList<HdrPo> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<HdrPo> listModel) {
		this.listModel = listModel;
	}
	
	

}
