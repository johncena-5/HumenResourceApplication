package com.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * This method is used to take random number
	 * @param value
	 * @return
	 */
	public int randomNumber(int value) {

		Random r = new Random();
		int random = r.nextInt(value);
		return random;
	}
/**
 * This method is used get the system date
 * @return
 */
	public String systemDate() {

		Date d = new Date();
		String s = d.toString();
		return s;
	}
	
	/**
	 * This method is used to set the date format
	 * @return
	 */
	public String dateFormate() {
		
		Date d = new Date();
		SimpleDateFormat da = new SimpleDateFormat("dd_mm_hh mm_sss");
		String date = da.format(d);
		return date;

	}
}
