package com.comcast.crm.genericwebdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random= new Random();
		int randomnum=random.nextInt(5000);
		return randomnum;
	}
	
	public String getSystemDateYYYYDDMM() {
		Date dateobj= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-dd");
		String date= sdf.format(dateobj);
		return date;
	}
public String getrequiredDateYYYYDDMM(int days) {
	
	SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-dd");
	
	Calendar cal= sdf.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String requiredate= sdf.format(cal.getTime());
return requiredate;
}
}
