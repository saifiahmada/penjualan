package com.dessy.penjualan.viewmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.dessy.penjualan.bean.DtlPicklist;
import com.dessy.penjualan.bean.DtlPo;
import com.dessy.penjualan.bean.HdrDo;
import com.dessy.penjualan.bean.HdrPicklist;
import com.dessy.penjualan.bean.HdrPo;
import com.dessy.penjualan.bean.MstDealer;


public class ProsesPickingVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private String noDo;
	
	private String kdDealer;
	
	private HdrPicklist current;
	
	private DtlPicklist current2;
	
	private ListModelList<DtlPicklist> listModel = new ListModelList<DtlPicklist>();
	
	@Init
	public void init(){
		
	}
	
	@Command("prosesPicking")
	@NotifyChange({"listModel"})
	public void prosesPicking(){
		
		HdrPicklist hdrPicklist = getMstService().getHdrPickinglistService().prosesPicklist(getNoDo());
		
		Set<DtlPicklist> listDtl = hdrPicklist.getDtlpicklists();
		
		listModel = new ListModelList<DtlPicklist>();
		listModel.addAll(listDtl);
		
		Clients.showNotification("Data berhasil disimpan", Clients.NOTIFICATION_TYPE_INFO, null , "top_right", 2000);
		setCurrent(hdrPicklist); 
	}
	
	@Command("reset")
	@NotifyChange({"listModel","current","noDo","kdDealer"}) 
	public void reset(){
		listModel = new ListModelList<DtlPicklist>();
		current = new HdrPicklist();
		noDo = null;
		kdDealer = null;
	}
	
	@Command("cetakPicking")
	public void cetakPicking() throws JRException { 
		
		System.out.println("cetak Picking");
		String noPick = getCurrent().getNopicklist();
		if (noPick == null) {
			Clients.showNotification("No Picklist masih kosong", Clients.NOTIFICATION_TYPE_INFO, null , "top_right", 2000);
			return;
		} 

		String reportFile = Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/report");
		reportFile = reportFile + "/Picking.jasper";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("NOPICKLIST", noPick);
 
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile,
				map , getReportConnection());
		
		
		JasperViewer.viewReport(jasperPrint, false);
		
	}
	
	@Command("lovDealer")
	public void lovDealer(@ContextParam (ContextType.VIEW) Component view){
		Map<String, Object> map = new HashMap<String, Object>();
		Executions.getCurrent().createComponents("popupDealer.zul", view, null);
	}
	
	@Command
	@NotifyChange({"kdDealer"})
	public void sendParamDealer(@BindingParam("paramDealer") MstDealer mstDealer) {
		setKdDealer(mstDealer.getId());  
	}
	
	@Command("lovPilihDO")
	@NotifyChange({"kdDealer"})
	public void lovPilihDO(@ContextParam (ContextType.VIEW) Component view){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kdDealer", getKdDealer());
		System.out.println("kode dealer = " + getKdDealer());
		Executions.getCurrent().createComponents("popupDO.zul", view, map);
	}
	
	@Command
	@NotifyChange({"noDo","listModel"})
	public void sendParamDO(@BindingParam("paramDO") HdrDo hdrDO) {
		setNoDo(hdrDO.getNoDo()); 
		
	}

	public String getNoDo() {
		return noDo;
	}

	public void setNoDo(String noDo) {
		this.noDo = noDo;
	}

	public String getKdDealer() {
		return kdDealer;
	}

	public void setKdDealer(String kdDealer) {
		this.kdDealer = kdDealer;
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

	public DtlPicklist getCurrent2() {
		if (current2 == null) {
			current2 = new DtlPicklist();
		}
		return current2;
	}

	public void setCurrent2(DtlPicklist current2) {
		this.current2 = current2;
	}

	public ListModelList<DtlPicklist> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<DtlPicklist> listModel) {
		this.listModel = listModel;
	}
	
}
