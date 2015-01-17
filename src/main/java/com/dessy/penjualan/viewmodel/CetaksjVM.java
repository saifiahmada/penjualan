package com.dessy.penjualan.viewmodel;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zul.Window;


public class CetaksjVM extends BasePage {

	private static final long serialVersionUID = 1L;

	private String noSuratJalan;

	@Init
	public void init() {
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


	public String getNoSuratJalan() {
		return noSuratJalan;
	}

	public void setNoSuratJalan(String noSuratJalan) {
		this.noSuratJalan = noSuratJalan;
	}

}
