package com.boostrdev.weblogic.legacy.model;

import java.util.Date;

public class InvoiceDtlsView {

	private Long payment_id;
	private String invoice_num;
	private String invoice_amount; 
	private String invoice_currency_code; 
	private String invoice_date; 
	private Long invoice_id; 
	private Long created_by; 
	private String creation_date; 
	private String last_update_date; 
	private Long last_updated_by; 
	private String org_id; 
	private String payment_method_code; 
	private Long request_id; 
	private String supplier_name; 
	private String supplier_site_name;
	public InvoiceDtlsView() {
		super();
	}
	public Long getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}
	public String getInvoice_num() {
		return invoice_num;
	}
	public void setInvoice_num(String invoice_num) {
		this.invoice_num = invoice_num;
	}
	public String getInvoice_amount() {
		return invoice_amount;
	}
	public void setInvoice_amount(String invoice_amount) {
		this.invoice_amount = invoice_amount;
	}
	public String getInvoice_currency_code() {
		return invoice_currency_code;
	}
	public void setInvoice_currency_code(String invoice_currency_code) {
		this.invoice_currency_code = invoice_currency_code;
	}
	public String getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(String invoice_date) {
		this.invoice_date = invoice_date;
	}
	public Long getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(Long invoice_id) {
		this.invoice_id = invoice_id;
	}
	public Long getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	public String getLast_update_date() {
		return last_update_date;
	}
	public void setLast_update_date(String last_update_date) {
		this.last_update_date = last_update_date;
	}
	public Long getLast_updated_by() {
		return last_updated_by;
	}
	public void setLast_updated_by(Long last_updated_by) {
		this.last_updated_by = last_updated_by;
	}
	public String getOrg_id() {
		return org_id;
	}
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	public String getPayment_method_code() {
		return payment_method_code;
	}
	public void setPayment_method_code(String payment_method_code) {
		this.payment_method_code = payment_method_code;
	}
	public Long getRequest_id() {
		return request_id;
	}
	public void setRequest_id(Long request_id) {
		this.request_id = request_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_site_name() {
		return supplier_site_name;
	}
	public void setSupplier_site_name(String supplier_site_name) {
		this.supplier_site_name = supplier_site_name;
	}
	@Override
	public String toString() {
		return "InvoiceDtlsView [payment_id=" + payment_id + ", invoice_num=" + invoice_num + ", invoice_amount="
				+ invoice_amount + ", invoice_currency_code=" + invoice_currency_code + ", invoice_date=" + invoice_date
				+ ", invoice_id=" + invoice_id + ", created_by=" + created_by + ", creation_date=" + creation_date
				+ ", last_update_date=" + last_update_date + ", last_updated_by=" + last_updated_by + ", org_id="
				+ org_id + ", payment_method_code=" + payment_method_code + ", request_id=" + request_id
				+ ", supplier_name=" + supplier_name + ", supplier_site_name=" + supplier_site_name + "]";
	}
	
	
		
}
