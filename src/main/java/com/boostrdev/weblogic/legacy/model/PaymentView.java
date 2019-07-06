package com.boostrdev.weblogic.legacy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentView {

	// comments
	private Long payment_id;
	private Long payment_number;
	private String comments;
	private Long payment_instruction_id;

	// payment details
	private Long supplier_id;
	private String supplier_name;
	private Long supplier_site_id;
	private String supplier_site_name;
	private String payment_method_code;
	private String payment_status;
	private String already_exists;
	private String payment_amount;
	private String payment_currency_code;
	private Long org_id;
	private Long bank_id;
	private String bank_account_number;
	private String bank_account_name;
	private String bank_branch_name;
	private Long request_id;
	private String payment_date;
	private String creation_date;
	private Long created_by;
	private String last_update_date;
	private Long last_updated_by;
	private String file_status;

	// Acknowledgement
	private Long payment_ack_id;
	private String ack_status;

	private String file_name;
	public PaymentView() {
		// default Constructor
	}

	public PaymentView(Long payment_id, Long payment_number, String comments, Long payment_instruction_id,
			Long supplier_id, String supplier_name, Long supplier_site_id, String supplier_site_name,
			String payment_method_code, String payment_status, String already_exists, String payment_amount,
			String payment_currency_code, Long org_id, Long bank_id, String bank_account_number,
			String bank_account_name, String bank_branch_name, Long request_id, String payment_date, String creation_date,
			Long created_by, String last_update_date, Long last_updated_by, String file_status, Long payment_ack_id,
			String ack_status,String file_name) {
		super();
		this.payment_id = payment_id;
		this.payment_number = payment_number;
		this.comments = comments;
		this.payment_instruction_id = payment_instruction_id;
		this.supplier_id = supplier_id;
		this.supplier_name = supplier_name;
		this.supplier_site_id = supplier_site_id;
		this.supplier_site_name = supplier_site_name;
		this.payment_method_code = payment_method_code;
		this.payment_status = payment_status;
		this.already_exists = already_exists;
		this.payment_amount = payment_amount;
		this.payment_currency_code = payment_currency_code;
		this.org_id = org_id;
		this.bank_id = bank_id;
		this.bank_account_number = bank_account_number;
		this.bank_account_name = bank_account_name;
		this.bank_branch_name = bank_branch_name;
		this.request_id = request_id;
		this.payment_date = payment_date;
		this.creation_date = creation_date;
		this.created_by = created_by;
		this.last_update_date = last_update_date;
		this.last_updated_by = last_updated_by;
		this.file_status = file_status;
		this.payment_ack_id = payment_ack_id;
		this.ack_status = ack_status;
		this.file_name=file_name;
	}

	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public Long getPayment_number() {
		return payment_number;
	}

	public void setPayment_number(Long payment_number) {
		this.payment_number = payment_number;
	}

	public Long getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getPayment_instruction_id() {
		return payment_instruction_id;
	}

	public void setPayment_instruction_id(Long payment_instruction_id) {
		this.payment_instruction_id = payment_instruction_id;
	}

	public Long getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public Long getSupplier_site_id() {
		return supplier_site_id;
	}

	public void setSupplier_site_id(Long supplier_site_id) {
		this.supplier_site_id = supplier_site_id;
	}

	public String getSupplier_site_name() {
		return supplier_site_name;
	}

	public void setSupplier_site_name(String supplier_site_name) {
		this.supplier_site_name = supplier_site_name;
	}

	public String getPayment_method_code() {
		return payment_method_code;
	}

	public void setPayment_method_code(String payment_method_code) {
		this.payment_method_code = payment_method_code;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getAlready_exists() {
		return already_exists;
	}

	public void setAlready_exists(String already_exists) {
		this.already_exists = already_exists;
	}

	public String getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(String payment_amount) {
		this.payment_amount = payment_amount;
	}

	public String getPayment_currency_code() {
		return payment_currency_code;
	}

	public void setPayment_currency_code(String payment_currency_code) {
		this.payment_currency_code = payment_currency_code;
	}

	public Long getOrg_id() {
		return org_id;
	}

	public void setOrg_id(Long org_id) {
		this.org_id = org_id;
	}

	public Long getBank_id() {
		return bank_id;
	}

	public void setBank_id(Long bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_account_number() {
		return bank_account_number;
	}

	public void setBank_account_number(String bank_account_number) {
		this.bank_account_number = bank_account_number;
	}

	public String getBank_account_name() {
		return bank_account_name;
	}

	public void setBank_account_name(String bank_account_name) {
		this.bank_account_name = bank_account_name;
	}

	public String getBank_branch_name() {
		return bank_branch_name;
	}

	public void setBank_branch_name(String bank_branch_name) {
		this.bank_branch_name = bank_branch_name;
	}

	public Long getRequest_id() {
		return request_id;
	}

	public void setRequest_id(Long request_id) {
		this.request_id = request_id;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public Long getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
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

	public String getFile_status() {
		return file_status;
	}

	public void setFile_status(String file_status) {
		this.file_status = file_status;
	}

	public Long getPayment_ack_id() {
		return payment_ack_id;
	}

	public void setPayment_ack_id(Long payment_ack_id) {
		this.payment_ack_id = payment_ack_id;
	}

	public String getAck_status() {
		return ack_status;
	}

	public void setAck_status(String ack_status) {
		this.ack_status = ack_status;
	}

	@Override
	public String toString() {
		return "PaymentView [payment_id=" + payment_id + ", payment_number=" + payment_number + ", comments=" + comments
				+ ", payment_instruction_id=" + payment_instruction_id + ", supplier_id=" + supplier_id
				+ ", supplier_name=" + supplier_name + ", supplier_site_id=" + supplier_site_id
				+ ", supplier_site_name=" + supplier_site_name + ", payment_method_code=" + payment_method_code
				+ ", payment_status=" + payment_status + ", already_exists=" + already_exists + ", payment_amount="
				+ payment_amount + ", payment_currency_code=" + payment_currency_code + ", org_id=" + org_id
				+ ", bank_id=" + bank_id + ", bank_account_number=" + bank_account_number + ", bank_account_name="
				+ bank_account_name + ", bank_branch_name=" + bank_branch_name + ", request_id=" + request_id
				+ ", payment_date=" + payment_date + ", creation_date=" + creation_date + ", created_by=" + created_by
				+ ", last_update_date=" + last_update_date + ", last_updated_by=" + last_updated_by + ", file_status="
				+ file_status + ", payment_ack_id=" + payment_ack_id + ", ack_status=" + ack_status + ", file_name="
				+ file_name + "]";
	}


}
