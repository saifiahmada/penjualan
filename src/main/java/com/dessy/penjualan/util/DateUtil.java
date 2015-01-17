package com.dessy.penjualan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DateUtil {
	
	private static GregorianCalendar getGregorianCalendar(int year, int month, int day, int hour, int min, int sec)
	  {
	    return new GregorianCalendar(year, month - 1, day, hour, min, sec);
	  }

	  private static GregorianCalendar getGregorianCalendar(java.util.Date date)
	  {
	    return getGregorianCalendar(getYear(date), getMonth(date), getDate(date), getHour(date), getMinute(date), getSecond(date));
	  }

	  private static java.util.Date gregCalToDate(GregorianCalendar greg)
	  {
	    int year = greg.get(1);
	    int month = greg.get(2) + 1;
	    int day = greg.get(5);
	    int hour = greg.get(11);
	    int min = greg.get(12);
	    int sec = greg.get(13);
	    if ((hour == 0) && (min == 0) && (sec == 0))
	      return DateConv.valueOf(year, month, day);
	    if (sec == 0) {
	      return DateConv.valueOf(year, month, day, hour, min);
	    }
	    return DateConv.valueOf(year, month, day, hour, min, sec);
	  }

	  public static java.util.Date getSysDate()
	  {
	    return trunc(getLongSysDate());
	  }

	  public static java.util.Date getLongSysDate()
	  {
	    return DateConv.valueOf(getCurrentDateTime("dd-MM-yyyy HH:mm:ss"), "dd-MM-yyyy HH:mm:ss");
	  }

	  public static java.util.Date getLongSysDateOracle()
	  {
	    return getLongSysDate();
	  }

	  public static int[] getAll(java.util.Date date)
	  {
	    if (date == null) {
	      return null;
	    }
	    int[] retVal = { getYear(date), getMonth(date), getDate(date), getHour(date), getMinute(date), getSecond(date) };

	    return retVal;
	  }

	  public static int[] getAll(Long date)
	  {
	    return getAll(date == null ? null : new java.util.Date(date.longValue()));
	  }

	  public static int getDate(java.util.Date date)
	  {
	    if (date == null) {
	      return 0;
	    }
	    return Integer.valueOf(DateConv.format(date, "dd")).intValue();
	  }

	  public static int getDate(Long date)
	  {
	    return getDate(date == null ? null : new java.util.Date(date.longValue()));
	  }

	  public static int getMonth(java.util.Date date)
	  {
	    if (date == null) {
	      return 0;
	    }
	    return Integer.valueOf(DateConv.format(date, "MM")).intValue();
	  }

	  public static int getMonth(Long date)
	  {
	    return getMonth(date == null ? null : new java.util.Date(date.longValue()));
	  }

	  public static int getYear(java.util.Date date)
	  {
	    if (date == null) {
	      return 0;
	    }
	    return Integer.valueOf(DateConv.format(date, "yyyy")).intValue();
	  }

	  public static int getYear(Long date)
	  {
	    return getYear(date == null ? null : new java.util.Date(date.longValue()));
	  }

	  public static int getHour(java.util.Date date)
	  {
	    if (date == null) {
	      return 0;
	    }
	    return Integer.valueOf(DateConv.format(date, "HH")).intValue();
	  }

	  public static int getHour(Long date)
	  {
	    return getHour(date == null ? null : new java.util.Date(date.longValue()));
	  }

	  public static int getMinute(java.util.Date date)
	  {
	    if (date == null) {
	      return 0;
	    }
	    return Integer.valueOf(DateConv.format(date, "mm")).intValue();
	  }

	  public static int getMinute(Long date)
	  {
	    return getMinute(date == null ? null : new java.util.Date(date.longValue()));
	  }

	  public static int getSecond(java.util.Date date)
	  {
	    if (date == null) {
	      return 0;
	    }
	    return Integer.valueOf(DateConv.format(date, "ss")).intValue();
	  }

	  public static int getSecond(Long date)
	  {
	    return getSecond(date == null ? null : new java.util.Date(date.longValue()));
	  }

	  public static long dateDiff(java.util.Date first, java.util.Date second)
	  {
	    if ((first != null) && (second != null)) {
	      long deviation = trunc(first).getTime() - trunc(second).getTime();
	      return deviation / 86400000L;
	    }

	    return 0L;
	  }

	  public static int lastDayOf(java.util.Date date)
	  {
	    if (date == null) {
	      return 0;
	    }
	    GregorianCalendar greg = getGregorianCalendar(date);
	    return greg.getActualMaximum(5);
	  }

	  public static java.util.Date addDay(java.util.Date date, int days)
	  {
	    if (date == null) {
	      return null;
	    }
	    GregorianCalendar greg = getGregorianCalendar(date);
	    greg.add(5, days);
	    return gregCalToDate(greg);
	  }

	  public static java.util.Date addMonth(java.util.Date date, int months)
	  {
	    if (date == null) {
	      return null;
	    }
	    GregorianCalendar greg = getGregorianCalendar(date);
	    greg.add(2, months);
	    return gregCalToDate(greg);
	  }

	  public static java.util.Date addYear(java.util.Date date, int years)
	  {
	    if (date == null) {
	      return null;
	    }
	    GregorianCalendar greg = getGregorianCalendar(date);
	    greg.add(1, years);
	    return gregCalToDate(greg);
	  }

	  public static java.util.Date addHour(java.util.Date date, int hours)
	  {
	    if (date == null) {
	      return null;
	    }
	    GregorianCalendar greg = getGregorianCalendar(date);
	    greg.add(11, hours);
	    return gregCalToDate(greg);
	  }

	  public static java.util.Date addMinute(java.util.Date date, int minutes)
	  {
	    if (date == null) {
	      return null;
	    }
	    GregorianCalendar greg = getGregorianCalendar(date);
	    greg.add(12, minutes);
	    return gregCalToDate(greg);
	  }

	  public static java.util.Date addSecond(java.util.Date date, int seconds)
	  {
	    if (date == null) {
	      return null;
	    }
	    GregorianCalendar greg = getGregorianCalendar(date);
	    greg.add(13, seconds);
	    return gregCalToDate(greg);
	  }

	  public static String getCurrentDateTime()
	  {
	    return getCurrentDateTime("dd-MM-yyyy HH:mm:ss");
	  }

	  public static String getCurrentDateTime(String dateFormat)
	  {
	    return DateConv.format(new java.util.Date(), dateFormat);
	  }

	  public static String getCurrentDate()
	  {
	    return getCurrentDateTime().substring(0, 10) + " 00:00:00";
	  }

	  public static String getCurrentDateOnly()
	  {
	    return getCurrentDateTime().substring(0, 10);
	  }

	  public static String getCurrentTimeOnly()
	  {
	    return getCurrentDateTime().substring(11);
	  }

//	  public static java.util.Date trunc(String truncFormat)
//	    throws AhmException	  {
//	    return trunc(getLongSysDate(), truncFormat);
//	  }

//	  public static java.util.Date trunc(java.util.Date date, String truncFormat)
//	    throws AhmException	  {
//	    if (date == null) {
//	      return null;
//	    }
//	    String yyyy = AdvDateConv.format(date, "yyyy"); String MM = AdvDateConv.format(date, "MM");
//	    String dd = AdvDateConv.format(date, "dd");
//	    String HH = AdvDateConv.format(date, "HH"); String mm = AdvDateConv.format(date, "mm");
//	    String ss = "00";
//
//	    if (truncFormat.equalsIgnoreCase("yyyy")) {
//	      MM = "01";
//	      dd = "01";
//	      HH = "00";
//	      mm = "00";
//	    } else if (truncFormat.equals("MM")) {
//	      dd = "01";
//	      HH = "00";
//	      mm = "00";
//	    } else if (truncFormat.equalsIgnoreCase("dd")) {
//	      HH = "00";
//	      mm = "00";
//	    } else if (truncFormat.equalsIgnoreCase("hh")) {
//	      mm = "00";
//	    } else if (!truncFormat.equals("mm"))
//	    {
//	      throw new AhmException("Format (" + truncFormat + ") untuk proses TRUNC tidak dikenal !!", AhmMessageType.LIB);
//	    }
//
//	    return AdvDateConv.valueOf(yyyy + "-" + MM + "-" + dd + " " + HH + ":" + mm + ":" + ss, "yyyy-MM-dd HH:mm:ss");
//	  }

	  public static java.util.Date trunc(java.util.Date date) {
	    if (date == null) {
	      return null;
	    }
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return java.sql.Date.valueOf(sdf.format(date));
	  }
	  
	  public static java.util.Date getDateFromString(String dateString){
		  java.util.Date tgl = null;
		  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		  try {
				tgl = sdf.parse(dateString);
			} catch (ParseException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return tgl;
	  }
	  
	  public static String getPeriode(java.util.Date tglAwal){
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		  return sdf.format(tglAwal);
	  }
	  
	  public static String formatyyyyMMdd(java.util.Date tglAwal){
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  return sdf.format(tglAwal);
	  }
	  
	  public static String formatddMMyyyy(java.util.Date tglAwal){
		  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		  return sdf.format(tglAwal);
	  }
	  
	  public static String formatddMMyyyy_HHmmS(java.util.Date tglAwal){
		  SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmmS");
		  return sdf.format(tglAwal);
	  }
	  
	  public static void main(String[] args) {
	  }
}

