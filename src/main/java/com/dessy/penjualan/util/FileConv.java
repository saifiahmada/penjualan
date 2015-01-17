package com.dessy.penjualan.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileConv {
	
	public static final String DEFAULT_SEPARATOR = ";";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector<String> castToStringVector(File file)  {
		Vector contents = null;
		FileInputStream fis = null;
		if ((file != null) && (file.exists()) && (file.isFile())) {
			contents = new Vector();
			try
			{
				fis = new FileInputStream(file);
				StringBuffer strContent = new StringBuffer("");
				int readStatus;
				while ((readStatus = fis.read()) != -1) {
					if (readStatus == 13) {
						contents.add(strContent.toString());
						strContent.delete(0, strContent.length());
					} else if (readStatus != 10) {
						strContent.append((char)readStatus);
					}
				}
				if (strContent.length() > 0)
					contents.add(strContent.toString());
			}
			catch (IOException iOException) {
				Logger.getLogger(FileConv.class.getName()).log(Level.INFO, iOException.getMessage(), iOException);
			}
			finally {
				try {
					if (fis != null)
						fis.close();
				}
				catch (IOException ex)
				{
					Logger.getLogger(FileConv.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

		}

		return contents;
	}

	public static Vector<String[]> castToStringArrayVector(File file) {
		return castToStringArrayVector(file, ";");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector<String[]> castToStringArrayVector(File file, String separator) {
		Vector contents = null;
		Vector<String> rawContents = castToStringVector(file);

		if (rawContents != null) {
			contents = new Vector();
			for (String rawContent : rawContents) {
				contents.add(rawContent.split(separator));
			}
		}
		return contents;
	}

}
