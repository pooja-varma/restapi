package com.boostrdev.weblogic.legacy.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;
@Component
public class Utility {
	

	public static String formatDate(Date date) throws ParseException
	{
	//	Date fromdate=null;
		
		String formattedDate=null;  
		
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
	//	DateFormat  inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
		Date fDate = outputFormat.parse(outputFormat.format(date));
		 formattedDate = outputFormat.format(fDate);
		
	
	// fromdate = outputFormat.parse(outputFormat.format(payment.getFromDate()));
	// Date fromdate = outputFormat.parse(formattedDate);
	 //System.out.println(fromdate.toString());
	//	Date todate = outputFormat.parse(outputFormat.format(payment.getToDate()));
	//	payment.setFromDate(fromdate);
		//payment.setToDate(todate);
		return formattedDate;
	};
	
	
	public static Date convertToDate(XMLGregorianCalendar calendar) throws DatatypeConfigurationException {
		GregorianCalendar cal = new GregorianCalendar();
		calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		Date date = calendar.toGregorianCalendar().getTime();
		return date;
	}
	
		
}