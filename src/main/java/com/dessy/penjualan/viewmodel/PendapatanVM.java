package com.dessy.penjualan.viewmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.MstDealer;
import com.dessy.penjualan.bean.Pendapatan;
import com.dessy.penjualan.bean.MstItem;


public class PendapatanVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private Pendapatan current;
	
	private ListModelList<Pendapatan> listModel = new ListModelList<Pendapatan>();
	
	private String kdItem;
	
	@Init
	public void init(){
		listModel = new ListModelList<Pendapatan>();
		List<Pendapatan> listItem = getMstService().getPendapatanService().findAll();
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
		current = new Pendapatan();
		current.setKdItem(kdItem);
	}

	@Command("cari")
	@NotifyChange({"listModel"})
	public void cari(){
		listModel = new ListModelList<Pendapatan>();
		List<Pendapatan> list = getMstService().getPendapatanService().getListByKdItem(getKdItem());
		listModel.addAll(list);
	}
	
	@Command("simpan")
	@NotifyChange({"listModel","current"})
	public void simpan(){
		System.out.println("memanggil method ini");
		getMstService().getPendapatanService().saveOrUpdate(getCurrent());
		reset();
	}
	
	@Command("reset")
	@NotifyChange({"listModel","current","kdItem"})
	public void reset(){
		current = new Pendapatan();
		kdItem = null;
		listModel = new ListModelList<Pendapatan>();
		List<Pendapatan> list = getMstService().getPendapatanService().findAll();
		listModel.addAll(list);
	}
	
	
	
	public Pendapatan getCurrent() {
		if (current == null) {
			current = new Pendapatan();
		}
		return current;
	}

	public void setCurrent(Pendapatan current) {
		this.current = current;
	}

	public ListModelList<Pendapatan> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<Pendapatan> listModel) {
		this.listModel = listModel;
	}
	
	@Command("cetakPendapatan")
	@NotifyChange({"kdItem"})
	public void cetakPendapatan() throws JRException { 
		
		String reportFile = Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/report");
		reportFile = reportFile + "/pendapatan.jasper";
		System.out.println("KDITEM = " + getKdItem());
		
		if (getKdItem() == null) {
			kdItem = "";
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("KDITEMPARAM", getKdItem());
 
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile,
				map , getReportConnection());
		
		
		JasperViewer.viewReport(jasperPrint, false);
		
	}

	public String getKdItem() {
		return kdItem;
	}

	public void setKdItem(String kdItem) {
		this.kdItem = kdItem;
	}
	
	
	

}
