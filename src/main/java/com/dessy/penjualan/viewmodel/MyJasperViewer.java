package com.dessy.penjualan.viewmodel;

import java.awt.Dimension;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/** @author Saifi Ahmada Nov 30, 2014 4:38:04 PM  **/

public class  MyJasperViewer extends JasperViewer {

	public MyJasperViewer(JasperPrint jasperPrint) { 
		super(jasperPrint);
	}
	
	@Override
	public void setSize(Dimension d) {
		
		Dimension newDim = new Dimension(2000, 2000);
		super.setSize(newDim);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	

}
