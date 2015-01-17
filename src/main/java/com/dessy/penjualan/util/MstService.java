package com.dessy.penjualan.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dessy.penjualan.service.DtlPoService;
import com.dessy.penjualan.service.HdrDoService;
import com.dessy.penjualan.service.HdrPicklistService;
import com.dessy.penjualan.service.HdrPoService;
import com.dessy.penjualan.service.HdrSuratJalanService;
import com.dessy.penjualan.service.MstDealerService;
import com.dessy.penjualan.service.MstGudangService;
import com.dessy.penjualan.service.MstHargaService;
import com.dessy.penjualan.service.MstItemService;
import com.dessy.penjualan.service.MstMenuService;
import com.dessy.penjualan.service.MstUserService;
import com.dessy.penjualan.service.PendapatanService;
import com.dessy.penjualan.service.StokDetailService;
import com.dessy.penjualan.service.StokGlobalService;

@Component
public class MstService {
	
	@Autowired
	private MstUserService mstUserService;
	
	@Autowired
	private MstMenuService mstMenuService;
	
	@Autowired
	private MstDealerService mstDealerService;
	
	@Autowired
	private StokGlobalService stokGlobalService;
	
	@Autowired
	private StokDetailService stokDetailService;
	
	@Autowired
	private MstItemService mstItemService;
	
	@Autowired
	private HdrPoService hdrPoService;
	
	@Autowired
	private DtlPoService dtlPoService;
	
	@Autowired
	private MstHargaService mstHargaService;
	
	@Autowired
	private HdrDoService hdrDoService;
	
	@Autowired
	private HdrPicklistService hdrPickinglistService;
	
	@Autowired
	private HdrSuratJalanService hdrSuratJalanService;
	@Autowired
	private MstGudangService mstGudangService;
	
	@Autowired
	private PendapatanService pendapatanService;
	
	public PendapatanService getPendapatanService() {
		return pendapatanService;
	}

	public void setPendapatanService(PendapatanService pendapatanService) {
		this.pendapatanService = pendapatanService;
	}

	public MstGudangService getMstGudangService() {
		return mstGudangService;
	}

	public void setMstGudangService(MstGudangService mstGudangService) {
		this.mstGudangService = mstGudangService;
	}

	public HdrSuratJalanService getHdrSuratJalanService() {
		return hdrSuratJalanService;
	}

	public void setHdrSuratJalanService(HdrSuratJalanService hdrSuratJalanService) {
		this.hdrSuratJalanService = hdrSuratJalanService;
	}

	public HdrPicklistService getHdrPickinglistService() {
		return hdrPickinglistService;
	}

	public void setHdrPickinglistService(HdrPicklistService hdrPickinglistService) {
		this.hdrPickinglistService = hdrPickinglistService;
	}

	public HdrDoService getHdrDoService() {
		return hdrDoService;
	}

	public void setHdrDoService(HdrDoService hdrDoService) {
		this.hdrDoService = hdrDoService;
	}

	public MstHargaService getMstHargaService() {
		return mstHargaService;
	}

	public void setMstHargaService(MstHargaService mstHargaService) {
		this.mstHargaService = mstHargaService;
	}

	public HdrPoService getHdrPoService() {
		return hdrPoService;
	}

	public void setHdrPoService(HdrPoService hdrPoService) {
		this.hdrPoService = hdrPoService;
	}

	public DtlPoService getDtlPoService() {
		return dtlPoService;
	}

	public void setDtlPoService(DtlPoService dtlPoService) {
		this.dtlPoService = dtlPoService;
	}

	public MstItemService getMstItemService() {
		return mstItemService;
	}

	public void setMstItemService(MstItemService mstItemService) {
		this.mstItemService = mstItemService;
	}

	public StokDetailService getStokDetailService() {
		return stokDetailService;
	}

	public void setStokDetailService(StokDetailService stokDetailService) {
		this.stokDetailService = stokDetailService;
	}

	public StokGlobalService getStokGlobalService() {
		return stokGlobalService;
	}

	public void setStokGlobalService(StokGlobalService stokGlobalService) {
		this.stokGlobalService = stokGlobalService;
	}

	public MstDealerService getMstDealerService() {
		return mstDealerService;
	}

	public void setMstDealerService(MstDealerService mstDealerService) {
		this.mstDealerService = mstDealerService;
	}

	public MstMenuService getMstMenuService() {
		return mstMenuService;
	}

	public void setMstMenuService(MstMenuService mstMenuService) {
		this.mstMenuService = mstMenuService;
	}

	public MstUserService getMstUserService() {
		return mstUserService;
	}

	public void setMstUserService(MstUserService mstUserService) {
		this.mstUserService = mstUserService;
	}

}


