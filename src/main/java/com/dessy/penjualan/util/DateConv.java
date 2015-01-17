package com.dessy.penjualan.util;


import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateConv {
	
	public static final String DEFAULT_DATE_FORMAT = "dd-MMM-yyyy";
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	public static final String DEFAULT_TIMESTAMP_FORMAT = "dd-MMM-yyyy HH:mm:ss";

	public static java.util.Date valueOf(String date) {
	    return valueOf(date, Locale.getDefault(), "dd-MMM-yyyy");
	}

	public static java.util.Date valueOf(String date, String pattern) {
		return valueOf(date, Locale.getDefault(), pattern);
	}	
	
	public static java.util.Date valueOf(String date, Locale locale)  {
		return valueOf(date, locale, "dd-MMM-yyyy");
	}

	public static java.util.Date valueOf(String date, Locale locale, String pattern) {
    
		try{
	      if ((date == null) || (locale == null) || (pattern == null)) {
	        return null;
	      }
	      SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
	      return sdf.parse(date);
	    }
	    catch (Exception ex) {
	      Logger.getLogger(DateConv.class.getName()).log(Level.SEVERE, null, ex);
	    }
    return null;
  }

  public static java.util.Date valueOf(int year, int month, int day) {
    return valueOf(Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day), "yyyy-MM-dd");
  }

  public static java.util.Date valueOf(int year, int month, int day, int hour, int min)  {
    return valueOf(Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day) + " " + Integer.toString(hour) + ":" + Integer.toString(min), "yyyy-MM-dd HH:mm");
  }

  public static java.util.Date valueOf(int year, int month, int day, int hour, int min, int sec)  {
    return valueOf(Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day) + " " + Integer.toString(hour) + ":" + Integer.toString(min) + ":" + Integer.toString(sec), "yyyy-MM-dd HH:mm:ss");
  }

  public static String format(java.util.Date date)  {
    return format(date, Locale.getDefault(), getDefaultFormat(date));
  }

  public static String format(Long date)  {
    return format(date == null ? null : new java.util.Date(date.longValue()), Locale.getDefault(), "dd-MMM-yyyy");
  }

  public static String format(java.util.Date date, Locale locale)  {
    return format(date, locale, getDefaultFormat(date));
  }

  public static String format(Long date, Locale locale)  {
    return format(date == null ? null : new java.util.Date(date.longValue()), locale, "dd-MMM-yyyy");
  }

  public static String format(java.util.Date date, String pattern)  {
    return format(date, Locale.getDefault(), pattern);
  }

  public static String format(Long date, String pattern)  {
    return format(date == null ? null : new java.util.Date(date.longValue()), Locale.getDefault(), pattern);
  }

  public static String format(java.util.Date date, Locale locale, String pattern)  {
    if ((date == null) || (locale == null) || (pattern == null)) {
      return null;
    }
    SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
    return sdf.format(date);
  }

  public static String format(Long date, Locale locale, String pattern)  {
    return format(date == null ? null : new java.util.Date(date.longValue()), locale, pattern);
  }

  public static String format(Object date, String initialFormat, String expectedFormat)  {
    return format(date, Locale.getDefault(), initialFormat, expectedFormat);
  }

  public static String format(Object date, Locale locale, String initialFormat, String expectedFormat)  {
    if ((date == null) || (locale == null) || (initialFormat == null) || (expectedFormat == null))    {
      return null; } 
    SimpleDateFormat fAwal = new SimpleDateFormat(initialFormat, locale); SimpleDateFormat fHasil = new SimpleDateFormat(expectedFormat, locale);
    String string;
    try { 
    	string = fHasil.format(fAwal.parse(date.toString()));
    } catch (Exception e) {
      string = null;
    }
    return string;
  }

  public static String formatExt(java.util.Date date)  {
    String DEFAULT_DATE_FORMAT_EXT = "ddMMyyyy";
    String DEFAULT_TIME_FORMAT_EXT = "HHmmss";
    String DEFAULT_TIMESTAMP_FORMAT_EXT = "ddMMyyyyHHmmss";
    String conv = "";

    if (date != null) {
      if ((date instanceof java.sql.Date))
        conv = format(date, DEFAULT_DATE_FORMAT_EXT);
      else if ((date instanceof Time))
        conv = format(date, DEFAULT_TIME_FORMAT_EXT);
      else if ((date instanceof Timestamp)) {
        conv = format(date, DEFAULT_TIMESTAMP_FORMAT_EXT);
      }
      else {
        conv = "";
      }
    }

    return conv;
  }

  private static String getDefaultFormat(java.util.Date date) {
    if ((date instanceof java.sql.Date))
      return "dd-MMM-yyyy";
    if ((date instanceof Time))
      return "HH:mm:ss";
    if ((date instanceof Timestamp))
      return "dd-MMM-yyyy HH:mm:ss";
    if ((date instanceof java.util.Date)) {
      return "dd-MMM-yyyy";
    }
    return "dd-MMM-yyyy";
  }

}

