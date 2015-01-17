package com.dessy.penjualan.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.dessy.penjualan.bean.DtlPo;
import com.dessy.penjualan.bean.DtlPoPK;
import com.dessy.penjualan.bean.HdrPo;
import com.dessy.penjualan.bean.MstDealer;
import com.dessy.penjualan.util.MstService;



public class TestDao {

	public static void main(String[] args) {
		
		List<MstDealer> list = getMstService().getMstDealerService().findAll();
		for (MstDealer md : list) {
			System.out.println("" + md.getNamaDealer()); 
		}
		
		
			
	}
	
	private static MstService getMstService(){
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				"src/main/webapp/WEB-INF/applicationContext.xml");
		
		MstService services = (MstService) ac.getBean("mstService");
		return services;
	}

}
