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
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;

import com.dessy.penjualan.bean.HdrPicklist;


public class CetakPickingVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private String noPicking;
	
	@Command("cetakPicking")
	public void cetakPicking() throws JRException{ 
		
		System.out.println("cetak Picking");
		String noPick = getNoPicking();
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

	public String getNoPicking() {
		return noPicking;
	}

	public void setNoPicking(String noPicking) {
		this.noPicking = noPicking;
	}
	
}
