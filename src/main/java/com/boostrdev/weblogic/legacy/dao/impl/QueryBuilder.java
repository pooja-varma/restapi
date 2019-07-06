package com.boostrdev.weblogic.legacy.dao.impl;

import java.text.ParseException;

import  com.boostrdev.weblogic.legacy.model.Payment;
import  com.boostrdev.weblogic.legacy.model.PaymentFileView;
import  com.boostrdev.weblogic.legacy.model.PaymentView;
import  com.boostrdev.weblogic.legacy.model.Utility;

public class QueryBuilder {

	
	
	public static String countFileFilterQuery(Payment payment) throws ParseException {
		StringBuilder queryBuilder = new StringBuilder();
		String startDate = null, endDate = null;
		if (null != payment.getFromDate() && null != payment.getToDate()) {
			startDate = Utility.formatDate(payment.getFromDate());
			endDate = Utility.formatDate(payment.getToDate());
		}
		queryBuilder.append("select count(*) FROM citicnt_pay_batch_ack_view e Where ");
		if (null != payment.getFromDate() && null != payment.getToDate()) {
			queryBuilder.append("e.creation_date >= TO_DATE(" + "\'" + startDate + "\'" + ",'yyyy-MM-dd HH24:MI:ss')");
			queryBuilder.append(" AND e.creation_date <= TO_DATE(" + "\'" + endDate + "\'" + ",'yyyy-MM-dd HH24:MI:ss')");
		}
		if(null!=payment.getPmtGpSts()) {
			queryBuilder.append(" AND e.ack_status='" + payment.getPmtGpSts().trim()+ "'");
		}
		if (null != payment.getIdentification()) { 
			queryBuilder.append(" AND e.payment_instruction_id=" + payment.getIdentification().trim());
		}
		if (null != payment.getSelectedStatus()) {
					queryBuilder.append(" AND e.ack_status='" + payment.getSelectedStatus().getCode() + "'");
			}
				if (null != payment.getOrgName()) {
			queryBuilder.append(" AND e.org_name='" + payment.getOrgName().getName() + "'");
		}
		System.out.println(queryBuilder.toString());
		return queryBuilder.toString();
	}
	public static String createFileFilterQuery(Payment payment, int start, int end) throws ParseException {
		StringBuilder queryBuilder = new StringBuilder();
		String startDate = null, endDate = null;
		if (null != payment.getFromDate() && null != payment.getToDate()) {
			startDate = Utility.formatDate(payment.getFromDate());
			endDate = Utility.formatDate(payment.getToDate());
		}
		queryBuilder.append("select *  from ( ");
		queryBuilder.append("select e.*, ROWNUM rnum FROM citicnt_pay_batch_ack_view e Where ");
		if (null != payment.getFromDate() && null != payment.getToDate()) {
			queryBuilder.append("e.creation_date >= TO_DATE(" + "\'" + startDate + "\'" + ",'yyyy-MM-dd HH24:MI:ss')");
			queryBuilder.append(" AND e.creation_date <= TO_DATE(" + "\'" + endDate + "\'" + ",'yyyy-MM-dd HH24:MI:ss')");
		}
		if(null!=payment.getPmtGpSts()) {
			queryBuilder.append(" AND e.ack_status='" + payment.getPmtGpSts().trim()+ "'");
		}
		if (null != payment.getIdentification()) { 
			queryBuilder.append(" AND e.payment_instruction_id=" + payment.getIdentification().trim());
		}
		if (null != payment.getSelectedStatus()) {
					queryBuilder.append(" AND e.ack_status='" + payment.getSelectedStatus().getCode() + "'");
			}
				if (null != payment.getOrgName()) {
			queryBuilder.append(" AND e.org_name='" + payment.getOrgName().getName() + "'");
		}
		queryBuilder.append(" AND ROWNUM <=" + end );
		queryBuilder.append(") where rnum>="+start);
		System.out.println(queryBuilder.toString());
		return queryBuilder.toString();
	}
	
	

	
	public static String createFileFilterQuery(Payment payment) throws ParseException {
		StringBuilder queryBuilder = new StringBuilder();
		String startDate = null, endDate = null;
		if (null != payment.getFromDate() && null != payment.getToDate()) {
			startDate = Utility.formatDate(payment.getFromDate());
			endDate = Utility.formatDate(payment.getToDate());
		}
		queryBuilder.append("select * FROM citicnt_pay_batch_ack_view e Where ");
		if (null != payment.getFromDate() && null != payment.getToDate()) {
			queryBuilder.append("e.creation_date >= TO_DATE(" + "\'" + startDate + "\'" + ",'yyyy-MM-dd HH24:MI:ss')");
			queryBuilder.append(" AND e.creation_date <= TO_DATE(" + "\'" + endDate + "\'" + ",'yyyy-MM-dd HH24:MI:ss')");
		}
		if (null != payment.getIdentification()) { 
			queryBuilder.append(" AND e.payment_instruction_id=" + payment.getIdentification().trim());
		}
		if (null != payment.getSelectedStatus()) {
					queryBuilder.append(" AND e.ack_status='" + payment.getSelectedStatus().getCode() + "'");
			}
				if (null != payment.getOrgName()) {
			queryBuilder.append(" AND e.org_name='" + payment.getOrgName().getName() + "'");
		}
		System.out.println(queryBuilder.toString());
		return queryBuilder.toString();
	}

	public static String createPaymentFilterQuery(Payment payment) throws ParseException {
		StringBuilder queryBuilder = new StringBuilder();
		String pmtstartDate = null, pmtendDate = null;
		if (null != payment.getFromDate() && null != payment.getToDate()) {
			pmtstartDate = Utility.formatDate(payment.getPmtfromDate());
			pmtendDate = Utility.formatDate(payment.getPmttoDate());
		}
	
		queryBuilder.append("select * FROM citicnt_payment_ack_view e Where ");
		if (null != payment.getPmtfromDate() && null != payment.getPmttoDate()) {
			queryBuilder.append("e.creation_date >= TO_DATE(" + "\'" + pmtstartDate + "\'" + ",'yyyy-MM-dd HH24:MI:ss')");
			queryBuilder.append(" AND e.creation_date <= TO_DATE(" + "\'" + pmtendDate + "\'" + ",'yyyy-MM-dd HH24:MI:ss')");
		}
		if (null != payment.getIdentification()) { 
			queryBuilder.append(" AND e.payment_number=" + payment.getIdentification().trim());
			
			//use payment_num
		}
		//search by supplier name
		if (null != payment.getSendingCmpCode()) {
			queryBuilder.append("AND e.supplier_name='" + payment.getSendingCmpCode().trim()+"'");
		}

		if (null != payment.getPmtMethod()) {
			queryBuilder.append(" AND e.payment_method_code='" + payment.getPmtMethod().trim() + "'");
		}
		if (null != payment.getPmtselectedStatus()) {
			if(payment.getPmtselectedStatus().getCode().equals("ACSP")||payment.getPmtselectedStatus().getCode().equals("ACCP"))
			{
				queryBuilder.append(" AND e.ack_status='ACSP' OR e.ack_status='ACCP'");
			}
			else{ 
				queryBuilder.append(" AND e.ack_status='" + payment.getPmtselectedStatus().getCode() + "'");
				}
		}
		if (null != payment.getOrgName()) {
			queryBuilder.append(" AND e.org_name='" + payment.getOrgName().getName() + "'");
		}
		System.out.println(queryBuilder.toString());
		return queryBuilder.toString();
	}
	
	
	public static String createFileCountQuery() {
		StringBuilder queryBuilder = new StringBuilder();
		
		queryBuilder.append("SELECT V.PAYMENT_INSTRUCTION_STATUS, COUNT(V.PAYMENT_INSTRUCTION_STATUS) FROM citicnt_pay_batch_ack_view V GROUP BY PAYMENT_INSTRUCTION_STATUS");
		
		System.out.println(queryBuilder.toString());
		return queryBuilder.toString();
	}
	
	
	public static String createPaymentCountQuery() {
		StringBuilder queryBuilder = new StringBuilder();
		
		queryBuilder.append("SELECT V.PAYMENT_STATUS, COUNT(V.PAYMENT_STATUS) FROM citicnt_payment_ack_view V GROUP BY PAYMENT_STATUS");
		
		System.out.println(queryBuilder.toString());
		return queryBuilder.toString();
	}
	

	public static String invoiceByPaymentId(PaymentView obj) {
		StringBuilder queryBuilder = new StringBuilder();
		
		queryBuilder.append("SELECT * FROM citi_cnt_pay_invoices V where V.payment_id="+obj.getPayment_id());
		
		System.out.println(queryBuilder.toString());
		return queryBuilder.toString();
	}
	
	public static String paymentDtlsByPaymentId(PaymentFileView obj) {
		StringBuilder queryBuilder = new StringBuilder();
		
		queryBuilder.append("SELECT * FROM citicnt_payment_ack_view V where V.payment_instruction_id="+obj.getPayment_instruction_id());
		
		System.out.println(queryBuilder.toString());
		return queryBuilder.toString();
	}
	
	public static String pmtCommentHistory(PaymentView obj) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select * from citi_cnt_payment_comments V where V.payment_id='"+obj.getPayment_id()+"' order by V.last_update_date desc");
		System.out.println(queryBuilder.toString());
		return queryBuilder.toString();
	}
	
	public static String fileCommentHistory(PaymentFileView obj) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select * from citi_cnt_payment_comments V where V.payment_instruction_id='"+obj.getPayment_instruction_id()+"' order by V.last_update_date desc");
		System.out.println(queryBuilder.toString());
		return queryBuilder.toString();
	}

	public static String validateUser(String resId, String userId) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select count ( * ) from FND_USER_RESP_GROUPS_DIRECT V where 1=1\r\n" + 
				"and V.user_id='"+userId+"' and "+" V.responsibility_id='"+resId +"' and trunc(sysdate) between trunc(nvl(start_Date,sysdate)) and trunc(nvl(end_Date,sysdate+1))");
		System.out.println(queryBuilder.toString());
		return queryBuilder.toString();
		
	}
	
	
	
	}

