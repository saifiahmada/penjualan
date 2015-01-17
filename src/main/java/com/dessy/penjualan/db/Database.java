package com.dessy.penjualan.db;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Database {

	public static void main(String[] args) throws IOException, InterruptedException { 

		File file = new File("src/main/java/com/dessy/penjualan/db/tes.txt");
		
		String folder = file.getParentFile().getAbsolutePath();
		String savePath = folder+"/"+getNamaFile(); 
		System.out.println("" + savePath);
		String dbName = "penjualandb";
		String dbUser = "root";
		String dbPass = "ahmids";
		
		String executeCmd = "mysqldump -u" + dbUser + " -p" + dbPass + " --database " + dbName + " --complete-insert --add-drop-database -r " + savePath;
		System.out.println("" + executeCmd);
		
		Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int processComplete = runtimeProcess.waitFor();

        if (processComplete == 0) {
            System.out.println("Backup Complete");
        } else {
            System.out.println("Backup Failure");
        }
		
	}
	
	private static String getNamaFile(){
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyyHHmm");
		return "penjualandb_"+sdf.format(new Date())+".sql";
	}

}
