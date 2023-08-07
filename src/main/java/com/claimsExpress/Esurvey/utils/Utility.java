package com.claimsExpress.Esurvey.utils;


import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.Properties;

public class Utility {

	private static final String FILE_CONFIG_LOCATION = "C://appsfiles//EsurveyApi//EsurveyApi.properties";

	private static final String EMPTY_STRING_VALUE = "";

	public static String getPropStringValues(String propertuValue) {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(FILE_CONFIG_LOCATION);
			properties.load(inputStream);
			String value = properties.getProperty(propertuValue);
			if (!isEmpty(value)) {
				return value;
			}
			return propertuValue;
		} catch (Exception e) {
			e.printStackTrace();
			return propertuValue;
		}

	}

	public static String getMainDir(String propertuValue) {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(FILE_CONFIG_LOCATION);
			properties.load(inputStream);
			String value = properties.getProperty(propertuValue);
			if (!isEmpty(value)) {
				return value;
			}
			return "C:";
		} catch (Exception e) {
			e.printStackTrace();
			return "C:";
		}

	}

	public static Integer getPropIntegerValues(String propertuValue) {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream(FILE_CONFIG_LOCATION);
			properties.load(inputStream);
			String value = properties.getProperty(propertuValue);
			if (!isEmpty(value)) {
				return Integer.valueOf(value);
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public static boolean isEmpty(String str) {
		return (str == null || EMPTY_STRING_VALUE.equals(str.trim()));
	}

	public static boolean isProxyEnable(String str) {

		String value = getPropStringValues(str);
		if (value != null && !"".equals(value) && "true".equalsIgnoreCase(value)) {
			return true;
		}

		return false;
	}

	public static boolean isEmpty(Object currentObject) {
		if (currentObject == null || "".equals(currentObject)) {
			return true;
		}
		return false;
	}

	public static String getStringValue(String name, ResultSet rs) {
		String value = null;
		try {
			value = rs.getString(name);
		} catch (Exception e) {
			return value;
		}
		return value;
	}

	public static Integer getIntValue(String name, ResultSet rs) {
		Integer value = 0;
		try {
			value = rs.getInt(name);
		} catch (Exception e) {
			return value;
		}
		return value;
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();
		value = value + Double.valueOf(0.004);
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public static double roundGeneric(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public static double roundUP(double value) {
		return Math.round(value * 100.0) / 100.0;
	}
}
