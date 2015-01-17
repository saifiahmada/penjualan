package com.dessy.penjualan.viewmodel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.xmlbeans.impl.common.ReaderInputStream;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.io.Files;
import org.zkoss.util.media.Media;
import org.zkoss.zhtml.Dl;
import org.zkoss.zhtml.Filedownload;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.xel.ExValue;
import org.zkoss.zul.Messagebox;

import com.dessy.penjualan.bean.DtlPo;
import com.dessy.penjualan.bean.DtlPoPK;
import com.dessy.penjualan.bean.HdrPo;
import com.dessy.penjualan.bean.StokDetail;
import com.dessy.penjualan.util.DateConv;
import com.dessy.penjualan.util.DateUtil;
import com.dessy.penjualan.util.FileConv;


public class UploadPoDealerVM extends BasePage {

	private static final long serialVersionUID = 1L;

	@Command
	public void getUploadedFile(@BindingParam("media") Media media)
			throws IOException {

		if (media == null) {
			Messagebox.show("File belum dipilih");
			return;
		}
		File dst = new File("PO_"+ DateUtil.formatddMMyyyy_HHmmS(new Date()) + media.getName()); 

		if (media.isBinary()) {
			System.out.println("binary");
			Files.copy(dst, media.getStreamData());
		} else {
			System.out.println("not binary");
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(dst));
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Files.copy(writer, media.getReaderData());
			writer.close();
		}
		Vector<String[]> vcString = FileConv.castToStringArrayVector(dst);
		
		HdrPo po = null;
		Set<DtlPo> listDtl = new HashSet<DtlPo>();
		for (String[] st : vcString) {
			String noPo = st[0];
			String idDealer = st[1];
			String kdItem = st[2];
			String qty = st[3];
			String tglShiplist = st[4];
			System.out.println(""+noPo);
			System.out.println(""+idDealer);
			System.out.println(""+kdItem);
			System.out.println(""+qty);
			System.out.println("TGL SL = " + tglShiplist);
			po = new HdrPo(noPo);
			po.setIdDealer(idDealer);
			po.setTglPo(DateConv.valueOf(tglShiplist, "yyyyMMdd"));
			po.setStatus("A");

			DtlPo dtl = new DtlPo();
			dtl.setDtlPoPK(new DtlPoPK(noPo, kdItem));
			dtl.setQty(Integer.parseInt(qty));
			dtl.setHdrPo(po);
			listDtl.add(dtl);

		}
		
		po.setDtlPos(listDtl);
		try {
		getMstService().getHdrPoService().save(po);
		} catch (Exception e) {
			Clients.showNotification("PO sudah pernah diupload",
					Clients.NOTIFICATION_TYPE_WARNING, null, "top_right", 2000);
		}
		
		Clients.showNotification("Transaksi Sukses",
				Clients.NOTIFICATION_TYPE_INFO, null, "top_right", 2000);
	}

}
