package com.qa.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {

	public static void main(String[] args) 
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
		Date date = new Date();
		String Sysdate = dateFormat.format(date);
		System.out.println(Sysdate); 

	}

}
