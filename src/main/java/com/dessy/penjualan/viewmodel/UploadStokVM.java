package com.dessy.penjualan.viewmodel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.io.Files;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Messagebox;

import com.dessy.penjualan.bean.StokDetail;
import com.dessy.penjualan.util.DateConv;
import com.dessy.penjualan.util.FileConv;


public class UploadStokVM extends BasePage {

	private static final long serialVersionUID = 1L;

	@Command
	public void getUploadedFile(@BindingParam("media") Media media) {

		if (media == null) {
			Messagebox.show("File belum dipilih");
			return;
		}
		File dst = new File("/home/saifi/Desktop/" + media.getName());
		System.out.println("MEDIA TYPE = " + media.getContentType());
		System.out.println("NAMA FILE = " + dst.getName());

		if (media.isBinary()) {
			try {
				Files.copy(dst, media.getStreamData());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// else {
		// BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
		// Files.copy(writer, media.getReaderData());
		// }
		Vector<String[]> vcString = FileConv.castToStringArrayVector(dst);
		List<StokDetail> listStok = new ArrayList<StokDetail>();
		StokDetail sd = null;
		for (String[] st : vcString) {
			String noShiplist = st[0];
			String noMesin = st[1];
			String noRangka = st[2];
			String kdItem = st[3];
			String qty = st[4];
			String tglShiplist = st[5];
			listStok.add(sd);
			
		}
		
		//getMstService().getStokDetailService().saveStokDetailAndGlobal(listStok, getUserSession()); 
		Clients.showNotification("Transaksi Sukses", Clients.NOTIFICATION_TYPE_INFO, null , "top_right", 2000);
	}

}
