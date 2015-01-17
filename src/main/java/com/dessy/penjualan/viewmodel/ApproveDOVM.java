package com.dessy.penjualan.viewmodel;

import java.math.BigDecimal;
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
import org.zkoss.bind.annotation.NotifyChangeDisabled;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.DtlDo;
import com.dessy.penjualan.bean.DtlDoPK;
import com.dessy.penjualan.bean.DtlPo;
import com.dessy.penjualan.bean.HdrDo;
import com.dessy.penjualan.bean.HdrPo;
import com.dessy.penjualan.bean.MstDealer;
import com.dessy.penjualan.bean.MstHarga;

public class ApproveDOVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private String kdDealer;
	
	private String noPo;
	
	private HdrPo hdrPo;
	
	private DtlPo current;
	
	private String noDo;
	
	private ListModelList<DtlPo> listModel = new ListModelList<DtlPo>();
	
	
	@Init
	public void init(){
		
	}
	
	@Command("cariPO")
	public void cariPO(){
		
	}
	
	@Command("simpan")
	@NotifyChange({"noDo"})
	public void simpan(){
		HdrDo hdrDo = new HdrDo();
		String noDO = "DO-0001";
		hdrDo.setNoDo(noDO);
		hdrDo.setStatus("A");
		hdrDo.setNoPo(getNoPo());
		hdrDo.setKdDlr(getKdDealer()); 
		
		BigDecimal harga = new BigDecimal(0);
		
		for (DtlPo dtl : listModel) {
			String kdItem = dtl.getDtlPoPK().getKdItem();
			
			MstHarga mstHarga = getMstService().getMstHargaService().get(kdItem);
			DtlDo dtlDO = new DtlDo();
			dtlDO.setHargaKosong(mstHarga.getHrgKsg());
			BigDecimal hargaNetto = mstHarga.getHrgKsg().add(mstHarga.getBbn()) ;
			dtlDO.setHargaNetto(hargaNetto);
			dtlDO.setHargaStd(hargaNetto);
			dtlDO.setQty((long) dtl.getQtyApp());
			dtlDO.setHdrDo(hdrDo); 
			dtlDO.setDtlDoPK(new DtlDoPK(hdrDo.getNoDo(), kdItem)); 
			hdrDo.getDtlDos().add(dtlDO);
			BigDecimal temp = hargaNetto.multiply( new BigDecimal(dtlDO.getQty()));
			harga = harga.add(temp);
		}
		hdrDo.setHarga(harga); 
		String no = getMstService().getHdrDoService().saveTransaksi(hdrDo); 
		setNoDo(no); 
		Clients.showNotification("Data berhasil disimpan", Clients.NOTIFICATION_TYPE_INFO, null , "top_right", 2000);
		
	}
	
	@Command("reset")
	@NotifyChange({"kdDealer","noPo","listModel"})
	public void reset(){
		setKdDealer(null);
		setNoPo(null); 
		listModel = new ListModelList<DtlPo>();
	}
	
	
	
	@Command("lovPilihDealer")
	public void lovPilihDealer(@ContextParam (ContextType.VIEW) Component view){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kdDealer", getKdDealer());
		Executions.getCurrent().createComponents("popupDealer.zul", view, null);
	}
	
	@Command
	@NotifyChange({"kdDealer"})
	public void sendParamDealer(@BindingParam("paramDealer") MstDealer mstDealer) {
		setKdDealer(mstDealer.getId());
	}
	
	@Command("lovPilihPO")
	public void lovPilihFasKan(@ContextParam (ContextType.VIEW) Component view){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kdDealer", getKdDealer());
		Executions.getCurrent().createComponents("popupPO.zul", view, map);
	}
	
	@Command
	@NotifyChange({"noPo","listModel"})
	public void sendParamPO(@BindingParam("paramPO") String noPo) {
		
		setNoPo(noPo); 
		listModel = new ListModelList<DtlPo>();
		HdrPo hdr = getMstService().getHdrPoService().get(noPo);
		Set<DtlPo> listDtl = hdr.getDtlPos();
		listModel.addAll(listDtl);
	}
	
	@Command("cek")
	@NotifyChange({"current","listModel"})
	public void cek(@BindingParam("picked") DtlPo dtlPo ){
		String kdItem = dtlPo.getDtlPoPK().getKdItem();
		int qty = dtlPo.getQty();
		int stok = getMstService().getStokGlobalService().getStokByKdItem(kdItem);
		int stokApprove = 0;
		if (stok >= qty ) {
			stokApprove = qty;
		} else {
			stokApprove = 0;
		}
		dtlPo.setQtyApp(stokApprove); 
	}
	
	@Command("cetakDO")
	@NotifyChange({"noDo"})
	public void cetakDO() throws JRException { 
		
		
		if (getNoDo() == null) {
			Clients.showNotification("No DO masih kosong", Clients.NOTIFICATION_TYPE_INFO, null , "top_right", 2000);
			return;
		} 

		String reportFile = Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/report");
		reportFile = reportFile + "/DO.jasper";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("NODO", getNoDo());
 
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile,
				map , getReportConnection());
		
		
		JasperViewer.viewReport(jasperPrint, false);
		
	}

	public String getKdDealer() {
		return kdDealer;
	}

	public void setKdDealer(String kdDealer) {
		this.kdDealer = kdDealer;
	}

	public String getNoPo() {
		return noPo;
	}

	public void setNoPo(String noPo) {
		this.noPo = noPo;
	}

	public HdrPo getHdrPo() {
		if (hdrPo == null) {
			hdrPo = new HdrPo();
		}
		return hdrPo;
	}

	public void setHdrPo(HdrPo hdrPo) {
		this.hdrPo = hdrPo;
	}

	public DtlPo getCurrent() {
		if (current == null) {
			current = new DtlPo();
		}
		return current;
	}

	public void setCurrent(DtlPo current) {
		this.current = current;
	}

	public ListModelList<DtlPo> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<DtlPo> listModel) {
		this.listModel = listModel;
	}

	public String getNoDo() {
		return noDo;
	}

	public void setNoDo(String noDo) {
		this.noDo = noDo;
	}
	
}
