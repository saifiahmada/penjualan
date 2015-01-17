package com.dessy.penjualan.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;

import com.dessy.penjualan.bean.MstGudang;
import com.dessy.penjualan.bean.MstGudang;

public class MstGudangVM extends BasePage {

	private static final long serialVersionUID = 1L;

	private MstGudang current;

	private ListModelList<MstGudang> listModel = new ListModelList<MstGudang>();

	@Init
	public void init() {
		listModel = new ListModelList<MstGudang>();
		List<MstGudang> listItem = getMstService().getMstGudangService()
				.findAll();
		listModel.addAll(listItem);
	}

	@Command("cari")
	@NotifyChange({ "listModel" })
	public void cari() {
		List<MstGudang> list = getMstService().getMstGudangService()
				.findByObject(getCurrent());
		listModel = new ListModelList<MstGudang>();
		listModel.addAll(list);
	}

	@Command("simpan")
	@NotifyChange({ "listModel", "current", "password2" })
	public void simpan() {

		getMstService().getMstGudangService().saveOrUpdate(getCurrent()); 
		Clients.showNotification("Data berhasil disimpan",
				Clients.NOTIFICATION_TYPE_INFO, null, "top_right", 2000);
		reset();
	}

	@Command("reset")
	@NotifyChange({ "current", "listModel" })
	public void reset() {
		current = new MstGudang();
		listModel = new ListModelList<MstGudang>();
		List<MstGudang> list = getMstService().getMstGudangService().findAll();
		listModel.addAll(list);
	}

	public MstGudang getCurrent() {
		if (current == null) {
			current = new MstGudang();
		}
		return current;
	}

	public void setCurrent(MstGudang current) {
		this.current = current;
	}

	public ListModelList<MstGudang> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<MstGudang> listModel) {
		this.listModel = listModel;
	}

}
