package com.dessy.penjualan.viewmodel;

import java.util.ArrayList;
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

import com.dessy.penjualan.bean.HdrDo;
import com.dessy.penjualan.bean.HdrDo;
import com.dessy.penjualan.bean.HdrPicklist;
import com.dessy.penjualan.bean.HdrPo;
import com.dessy.penjualan.bean.HdrDo;
import com.dessy.penjualan.bean.MstDealer;

public class MonPembayaranVM extends BasePage {

private static final long serialVersionUID = 1L;
	
	private String noPicking;
	
	private String kdDealer;
	
	private String noSuratJalan;
	
	private HdrDo current;

	private HdrDo current2;
	
	private String noDo;
	
	private String noFaktur;
	
	private String status;
	
	private ListModelList<HdrDo> listModel = new ListModelList<HdrDo>();
	
	@Init
	public void init(){
		listModel = new ListModelList<HdrDo>();
		List<HdrDo> list = getMstService().getHdrDoService().findAll();
		listModel.addAll(list);
	}
	
	@Command("prosesFaktur")
	@NotifyChange({"noFaktur"})
	public void prosesFaktur(){
		
		if (getNoDo()== null) {
			Clients.showNotification("No DO harus ada", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return;
		}
		
		if (getKdDealer() == null) {
			Clients.showNotification("Kode Dealer harus ada", Clients.NOTIFICATION_TYPE_WARNING, null , "top_right", 2000);
			return;
		}
		
		String noFaktur = getMstService().getHdrDoService().prosesFaktur(getNoDo(), getKdDealer());
		setNoFaktur(noFaktur); 
		Clients.showNotification("Data berhasil disimpan", Clients.NOTIFICATION_TYPE_INFO, null , "top_right", 2000);
		
	}
	
	
	
	@Command("cetakPembayaran")
	@NotifyChange({"kdDealer","status"})
	public void cetakPembayaran() throws JRException { 
		
		String reportFile = Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/report");
		reportFile = reportFile + "/pembayaran.jasper";
		
		if (getKdDealer() == null) {
			kdDealer = "";
		}
		
		if (getStatus() == null) {
			status = "";
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("KDDLR", getKdDealer());
		map.put("STATUS", getStatus());
 
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile,
				map , getReportConnection());
		
		
		JasperViewer.viewReport(jasperPrint, false);
		
	}

	
	@Command("cetakSJ")
	public void cetakSJ() throws JRException { 
		
		
		String noSj = getNoSuratJalan();
		if (noSj == null) {
			Clients.showNotification("No Surat Salan masih kosong", Clients.NOTIFICATION_TYPE_INFO, null , "top_right", 2000);
			return;
		} 

		String reportFile = Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/report");
		reportFile = reportFile + "/suratjalan.jasper";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("NOSJ", noSj);
 
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile,
				map , getReportConnection());
		
		
		JasperViewer.viewReport(jasperPrint, false);
		
	}
	
	@Command("lovDealer")
	public void lovDealer(@ContextParam (ContextType.VIEW) Component view){
		Executions.getCurrent().createComponents("popupDealer.zul", view, null);
	}
	
	@Command
	@NotifyChange({"kdDealer"})
	public void sendParamDealer(@BindingParam("paramDealer") MstDealer mstDealer) {
		setKdDealer(mstDealer.getId());  
	}
	
	@Command("lovPilihPicking")
	public void lovPilihPicking(@ContextParam (ContextType.VIEW) Component view){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kdDealer", getKdDealer());
		Executions.getCurrent().createComponents("popupPicking.zul", view, map);
	}
	
	@Command
	@NotifyChange({"noPicking"})
	public void sendParamPick(@BindingParam("paramPick") HdrPicklist hdrPicklist) {
		setNoPicking(hdrPicklist.getNopicklist());   
	}
	
	@Command
	@NotifyChange({"noPo","listModel"})
	public void sendParamPO(@BindingParam("paramPO") HdrPo hdrPO) {
		System.out.println("NOPO = " + hdrPO.getNoPo());
	
	}
	
	@Command("reset")
	@NotifyChange({"listModel","current","noPicking","kdDealer","status"}) 
	public void reset(){
		listModel = new ListModelList<HdrDo>();
		List<HdrDo> list = getMstService().getHdrDoService().findAll();
		listModel.addAll(list);
		current = new HdrDo();
		noPicking = null;
		kdDealer = null;
		status = null;
	}
	
	@Command("cari")
	@NotifyChange({"listModel"}) 
	public void cari(){
		
		listModel = new ListModelList<HdrDo>();
		List<HdrDo> list = new ArrayList<HdrDo>();	
		if (getStatus() == null && getKdDealer() == null) {
			list = getMstService().getHdrDoService().findAll();
		} else {
			list = getMstService().getHdrDoService().findByStatusAnKodeDealer(getStatus(), getKdDealer());
		}
		listModel.addAll(list);
		
	}
	
	@Command("lovPilihDO")
	@NotifyChange({"kdDealer"})
	public void lovPilihDO(@ContextParam (ContextType.VIEW) Component view){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kdDealer", getKdDealer());
		System.out.println("kode dealer = " + getKdDealer());
		Executions.getCurrent().createComponents("popupDOStatusB.zul", view, map);
	}
	
	@Command
	@NotifyChange({"noDo","listModel"})
	public void sendParamDO(@BindingParam("paramDO") HdrDo hdrDO) {
		setNoDo(hdrDO.getNoDo()); 
		
	}


	public String getNoPicking() {
		return noPicking;
	}

	public void setNoPicking(String noPicking) {
		this.noPicking = noPicking;
	}

	public String getKdDealer() {
		return kdDealer;
	}

	public void setKdDealer(String kdDealer) {
		this.kdDealer = kdDealer;
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

	public HdrDo getCurrent2() {
		if (current2 == null) {
			current2 = new HdrDo();
		}
		return current2;
	}

	public void setCurrent2(HdrDo current2) {
		this.current2 = current2;
	}

	public ListModelList<HdrDo> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<HdrDo> listModel) {
		this.listModel = listModel;
	}

	public String getNoSuratJalan() {
		return noSuratJalan;
	}

	public void setNoSuratJalan(String noSuratJalan) {
		this.noSuratJalan = noSuratJalan;
	}

	public String getNoDo() {
		return noDo;
	}

	public void setNoDo(String noDo) {
		this.noDo = noDo;
	}

	public String getNoFaktur() {
		return noFaktur;
	}

	public void setNoFaktur(String noFaktur) {
		this.noFaktur = noFaktur;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
