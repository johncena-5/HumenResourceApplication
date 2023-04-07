package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	/**
	 * This method is used to read the data from property file
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key)  {

		FileInputStream fis=null;
		try {
			fis = new FileInputStream(IConstantPath.PROPERTIES_FILE_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Properties property = new Properties();

		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String value = property.getProperty(key);
		return value;
	}

}
