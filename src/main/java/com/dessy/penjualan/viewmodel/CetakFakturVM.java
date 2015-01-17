package com.dessy.penjualan.viewmodel;

import java.awt.Frame;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;

public class CetakFakturVM extends BasePage {

	private static final long serialVersionUID = 1L;
	
	private String noFaktur;
	
	@Command("cetakFaktur")
	public void cetakFaktur() throws JRException{ 
		
		System.out.println("cetak Picking");
		String noFaktur = getNoFaktur();
		if (noFaktur == null) {
			Clients.showNotification("No Faktur masih kosong", Clients.NOTIFICATION_TYPE_INFO, null , "top_right", 2000);
			return;
		} 

		String reportFile = Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/report");
		//reportFile = reportFile + "/Picking.jasper";
		reportFile = reportFile + "/fakturPenjualan.jasper";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("NOFAKTUR", noFaktur);
 
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile,
				map , getReportConnection());
		
		//MyJasperViewer.viewReport(jasperPrint); 
		JasperViewer jv = new JasperViewer(null);
		jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
		System.out.println("H " + jv.getMaximumSize().height);
		System.out.println("W" + jv.getMaximumSize().width);
		boolean gede = jv.isMinimumSizeSet();
		System.out.println("gede = " + gede);
		//jv.setUndecorated(true);  
		jv.viewReport(jasperPrint); 
		
		//JasperViewer.viewReport(jasperPrint, false);
		
	}
	
	public String getNoFaktur() {
		return noFaktur;
	}

	public void setNoFaktur(String noFaktur) {
		this.noFaktur = noFaktur;
	}
	
}
