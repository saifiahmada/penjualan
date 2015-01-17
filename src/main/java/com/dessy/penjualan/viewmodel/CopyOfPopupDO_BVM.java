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

import com.dessy.penjualan.bean.HdrDo;
import com.dessy.penjualan.bean.HdrPo;


public class CopyOfPopupDO_BVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private HdrDo current;
	
	private String kdDlr;
	
	private ListModelList<HdrDo> listModel = new ListModelList<HdrDo>();
	
	@SuppressWarnings("unchecked")
	@Init
	public void init(){
		
		Map<String, Object> map =  (HashMap<String, Object>) Executions.getCurrent().getArg();
		System.out.println("KD DEALER " + map.get("kdDealer"));
		kdDlr = (String) map.get("kdDealer");
		current = new HdrDo();
		listModel = new ListModelList<HdrDo>();
		List<HdrDo> listDO = getMstService().getHdrDoService().findByStatusAnKodeDealer("A", kdDlr);
		listModel.addAll(listDO);
	}
	
	@Command("reset")
	@NotifyChange({"current","listModel"})
	public void reset(){
		current = new HdrDo();
		listModel = new ListModelList<HdrDo>();
		List<HdrDo> listPO = getMstService().getHdrDoService().findByStatusAnKodeDealer("A", kdDlr);
		listModel.addAll(listPO);
	}
	
	@Command("cari")
	public void cari(){
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Command("pilih")
	public void pilih(@ContextParam (ContextType.VIEW) Component view){
		Map param = new HashMap();
		param.put("paramDO", getCurrent());
		Binder bind = (Binder) view.getParent().getAttribute("binder");
		if (bind == null) return;
		bind.postCommand("sendParamDO", param);
		view.detach();
	}

	public HdrDo getCurrent() {
		if (current == null) {
			current = new HdrDo();
		}
		return current;
	}

	public void setCurrent(HdrDo current) {
		this.current = current;
	}

	public ListModelList<HdrDo> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<HdrDo> listModel) {
		this.listModel = listModel;
	}

	public String getKdDlr() {
		return kdDlr;
	}

	public void setKdDlr(String kdDlr) {
		this.kdDlr = kdDlr;
	}


}
