package com.dessy.penjualan.viewmodel;

import java.util.HashMap;
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

import com.dessy.penjualan.bean.DtlSuratJalan;
import com.dessy.penjualan.bean.HdrDo;
import com.dessy.penjualan.bean.HdrPicklist;
import com.dessy.penjualan.bean.HdrPo;
import com.dessy.penjualan.bean.HdrSuratJalan;
import com.dessy.penjualan.bean.MstDealer;

public class FakturPenjualanVM extends BasePage {

private static final long serialVersionUID = 1L;
	
	private String noPicking;
	
	private String kdDealer;
	
	private String noSuratJalan;
	
	private HdrSuratJalan current;

	private DtlSuratJalan current2;
	
	private String noDo;
	
	private String noFaktur;
	
	private ListModelList<DtlSuratJalan> listModel = new ListModelList<DtlSuratJalan>();
	
	@Init
	public void init(){
		
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
	
	
	
	@Command("cetakFaktur")
	public void cetakFaktur() throws JRException { 
		
		
		String noFak = getNoFaktur();
		if (noFak == null) {
			Clients.showNotification("No Faktur masih kosong", Clients.NOTIFICATION_TYPE_INFO, null , "top_right", 2000);
			return;
		} 

		String reportFile = Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/report");
		reportFile = reportFile + "/fakturPenjualan.jasper";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("NOFAKTUR", noFak);
 
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
	@NotifyChange({"listModel","current","noPicking","kdDealer"}) 
	public void reset(){
		listModel = new ListModelList<DtlSuratJalan>();
		current = new HdrSuratJalan();
		noPicking = null;
		kdDealer = null;
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

	public HdrSuratJalan getCurrent() {
		if (current == null) {
			current = new HdrSuratJalan();
		}
		return current;
	}

	public void setCurrent(HdrSuratJalan current) {
		this.current = current;
	}

	public DtlSuratJalan getCurrent2() {
		if (current2 == null) {
			current2 = new DtlSuratJalan();
		}
		return current2;
	}

	public void setCurrent2(DtlSuratJalan current2) {
		this.current2 = current2;
	}

	public ListModelList<DtlSuratJalan> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<DtlSuratJalan> listModel) {
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
	

}
