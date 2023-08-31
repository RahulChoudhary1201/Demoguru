package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	public static Properties readPropertiesFile(String filePath)
			throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fis.close();
		}

		return prop;
	}
	/*
	 * public static void main(String[] args) throws IOException { Properties
	 * prop = readPropertiesFile(
	 * ".\\src\\test\\java\\com\\testdata\\config.properties");
	 * System.out.println(prop.getProperty("user"));
	 * System.out.println(prop.getProperty("pass")); }
	 */
}
