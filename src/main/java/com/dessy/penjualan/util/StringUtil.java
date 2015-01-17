package com.dessy.penjualan.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class StringUtil {

	private static final String[] DEFAULT_RANDOM_CHAR = {
			"QWERTYUIOPASDFGHJKLZXCVBNM", "qwertyuiopasdfghjklzxcvbnm",
			"0123456789", "~!@#$%^&*()-" };

	public static String lpad(String strSource, int width, char symbol) {
		String tempStr = strSource;
		if ((strSource == null) || (strSource.equalsIgnoreCase(""))) {
			return "";
		}
		int pjgSource = strSource.length();

		if (width < 0) {
			return "";
		}

		if (width >= pjgSource) {
			for (int i = 0; i < width - pjgSource; i++)
				tempStr = symbol + tempStr;
		} else {
			tempStr = tempStr.substring(0, width);
		}

		return tempStr;
	}

	public static String lpad(String strSource, int width, String symbol) {
		String tempStr = strSource;
		if ((strSource == null) || (strSource.equalsIgnoreCase(""))) {
			return "";
		}
		int pjgSource = strSource.length();

		if (width < 0) {
			return "";
		}

		if (width >= pjgSource) {
			for (int i = 0; i < width - pjgSource; i++) {
				tempStr = symbol + tempStr;
			}
			if (tempStr.length() > width)
				tempStr = tempStr.substring(tempStr.length() - width);
		} else {
			tempStr = tempStr.substring(0, width);
		}

		return tempStr;
	}

	public static String rpad(String strSource, int width, char symbol) {
		String tempStr = strSource;
		if ((strSource == null) || (strSource.equalsIgnoreCase(""))) {
			return "";
		}
		int pjgSource = strSource.length();

		if (width < 0) {
			return "";
		}

		if (width >= pjgSource) {
			for (int i = 0; i < width - pjgSource; i++)
				tempStr = tempStr + symbol;
		} else {
			tempStr = tempStr.substring(0, width);
		}

		return tempStr;
	}

	public static String rpad(String strSource, int width, String symbol) {
		String tempStr = strSource;
		if ((strSource == null) || (strSource.equalsIgnoreCase(""))) {
			return "";
		}
		int pjgSource = strSource.length();

		if (width < 0) {
			return "";
		}

		if (width >= pjgSource) {
			for (int i = 0; i < width - pjgSource; i++) {
				tempStr = tempStr + symbol;
			}
		}

		if (tempStr.length() > width) {
			tempStr = tempStr.substring(0, width);
		}

		return tempStr;
	}

	// public static String substring(String sourceData, int beginIndex, int
	// endIndex)
	// {
	// int length = 0;
	// try {
	// if (sourceData == null) {
	// return "";
	// }
	// length = sourceData.length();
	// return sourceData.substring(beginIndex, endIndex);
	// }
	// catch (StringIndexOutOfBoundsException sex) {
	// if ((beginIndex >= length) || (endIndex <= 0))
	// return "";
	// if ((beginIndex < 0) && (endIndex > length))
	// return sourceData;
	// if ((beginIndex < 0) && (endIndex <= length))
	// return substring(sourceData, 0, endIndex);
	// if (endIndex > length)
	// return substring(sourceData, beginIndex, length);
	// }
	// throw new AhmException(sex.getMessage(), AhmMessageType.LIB);
	// }

	// public static String substring(String sourceData, int beginIndex)
	// {
	// return substring(sourceData, beginIndex,
	// TrioNvl.nvl(sourceData).length());
	// }

	public static boolean isEmpty(String s) {
		return (s == null) || (s.equals(""));
	}

	public static boolean isEmpty(Object o) {
		return (o == null) || (o.toString().equals(""));
	}

	public static boolean isContain(String sourceData, String[] comparedData) {
		boolean reverseCheck = false;

		if (sourceData == null) {
			if (comparedData == null) {
				return true;
			}
			reverseCheck = true;
		} else if (comparedData == null) {
			return false;
		}

		for (int i = 0; i < comparedData.length; i++) {
			if (reverseCheck) {
				if (comparedData[i] == null) {
					return true;
				}
			} else if (sourceData.equalsIgnoreCase(comparedData[i])) {
				return true;
			}

		}

		return false;
	}

	public static String getRandomPassword(int n) {
		return getRandomPassword(n, DEFAULT_RANDOM_CHAR,
				DEFAULT_RANDOM_CHAR.length - 1);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String getRandomPassword(int nCharacter, String[] charValues,
			int nAccept) {
		HashMap hm = null;
		String result = null;
		int nTipe = 0;
		int tipeChar = 0;

		nAccept = nAccept > charValues.length ? charValues.length : nAccept;
		do {
			hm = new HashMap();
			result = "";
			nTipe = 0;

			for (int i = 0; i < nCharacter; i++) {
				tipeChar = (int) (Math.random() * charValues.length);
				if (hm.get(new Integer(tipeChar)) == null) {
					nTipe++;
					hm.put(new Integer(tipeChar), null);
				}
				result = result.concat(String.valueOf(charValues[tipeChar]
						.charAt((int) (Math.random() * charValues[tipeChar]
								.length()))));
			}

		}

		while (nTipe < nAccept);

		return result;
	}

	public static String toUpperCase(String value) {
		return value == null ? null : value.toUpperCase();
	}

	public static String toLowerCase(String value) {
		return value == null ? null : value.toLowerCase();
	}

	public static String getFormattedRunno(String idDoc, Integer runnum,
			Integer counter) {
		return idDoc
				+ "/"
				+ DateConv.format(new Date(), "yy/MM")
				+ "/"
				+ lpad(new StringBuilder().append(runnum).append("").toString(),
						counter, "0");
	}

	public static String getFormattedRunno(String idDoc, Integer runnum) {
		return idDoc
				+ "/"
				+ DateConv.format(new Date(), "yy/MM")
				+ "/"
				+ lpad(new StringBuilder().append(runnum).append("").toString(),
						5, "0");
	}

	public static String getFormattedRunno(Integer runnum, String idDoc) {

		return lpad(new StringBuilder().append(runnum).append("").toString(),
				5, "0")
				+ "/"
				+ idDoc
				+ "/"
				+ DateConv.format(new Date(), "yyyy");
	}

	public static String getFormattedRunno(Integer runnum) {

		return lpad(new StringBuilder().append(runnum).append("").toString(),
				5, "0");
	}

	public static String getPemisahRibuan(String angka) {
		BigInteger bi = new BigInteger(angka);
		NumberFormat formatter = NumberFormat
				.getInstance(new Locale("id", "ID"));
		return formatter.format(bi);
	}

	public static String getPemisahRibuan(Double angka) {
		BigDecimal bd = new BigDecimal(angka);
		NumberFormat formatter = NumberFormat
				.getInstance(new Locale("id", "ID"));
		return formatter.format(bd);
	}

	public static String getPemisahRibuan(int angka) {
		BigDecimal bd = new BigDecimal(angka);
		NumberFormat formatter = NumberFormat
				.getInstance(new Locale("id", "ID"));
		return formatter.format(bd);
	}

}
