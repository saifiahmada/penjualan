package com.dessy.penjualan.viewmodel;

import java.util.List;
import java.util.Set;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Base;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.DtlPo;
import com.dessy.penjualan.bean.HdrPo;

public class MaintainPoVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private HdrPo current;
	
	private ListModelList<HdrPo> listModel = new ListModelList<HdrPo>();
	
	
	@Init
	public void init(){
		listModel = new ListModelList<HdrPo>();
		List<HdrPo> listPo = getMstService().getHdrPoService().findAll();
		listModel.addAll(listPo);
	}
	
	@Command("reset")
	@NotifyChange({"current","listModel"})
	public void reset(){
		current = new HdrPo();
		listModel = new ListModelList<HdrPo>();
		List<HdrPo> listPo = getMstService().getHdrPoService().findAll();
		listModel.addAll(listPo);
	}
	
	@Command("cari")
	@NotifyChange({"listModel"})
	public void cari(){
		listModel = new ListModelList<HdrPo>();
		List<HdrPo> list = getMstService().getHdrPoService().findListBy(getCurrent());
		listModel.addAll(list); 
		System.out.println("sieze = " + list.size());
	}
	
	public HdrPo getCurrent() {
		if (current == null) {
			current = new HdrPo();
		}
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
