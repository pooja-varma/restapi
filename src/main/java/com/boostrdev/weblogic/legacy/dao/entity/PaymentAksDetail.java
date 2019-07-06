package com.boostrdev.weblogic.legacy.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CITI_CNT_PAYMENT_ACK_DETAILS")
public class PaymentAksDetail implements Serializable {
	private static final long serialVersionUID = 1313321L;
	@Id
	private String ack_id;
	private BigDecimal payment_instruction_id; 
	private BigDecimal payment_id;
	private String ack_status;
	private String file_name;
	private BigDecimal org_id;
	private String file_status;
	private String payment_amount;
	@Column(name = "PAYMENT_CURRENCY_CODE")
	private String payment_currenc_code;
	@Temporal(TemporalType.TIMESTAMP)
	private Date payment_date;
	private String payment_status;
	@Column(name = "ADDITIONAL_INFO")
	private String add_Info;
	private Integer created_by;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE")
	private Date created_date;
	@Column(name = "LAST_UPDATED_BY")
	private Integer updated_by;
	
	@Column(name = "LAST_UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date  updated_date;
	
	@Column(name = "PAYMENT_NUMBER")
	private BigDecimal paymentNumber;
	
	@Column(name = "LOGICAL_GROUP_REFERENCE")
	private String logicalGrpRef;
	
    public BigDecimal getPayment_instruction_id() {
		return payment_instruction_id;
	}
	public void setPayment_instruction_id(BigDecimal payment_instruction_id) {
		this.payment_instruction_id = payment_instruction_id;
	}
	public BigDecimal getOrg_id() {
		return org_id;
	}
	public void setOrg_id(BigDecimal org_id) {
		this.org_id = org_id;
	}
	public String getFile_status() {
		return file_status;
	}
	public void setFile_status(String file_status) {
		this.file_status = file_status;
	}
	public String getAck_id() {
		return ack_id;
	}
	public void setAck_id(String ack_id) {
		this.ack_id = ack_id;
	}
	public BigDecimal getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(BigDecimal payment_id) {
		this.payment_id = payment_id;
	}
	public String getAck_status() {
		return ack_status;
	}
	public void setAck_status(String ack_status) {
		this.ack_status = ack_status;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(String payment_amount) {
		this.payment_amount = payment_amount;
	}
	public String getPayment_currenc_code() {
		return payment_currenc_code;
	}
	public void setPayment_currenc_code(String payment_currenc_code) {
		this.payment_currenc_code = payment_currenc_code;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public String getAdd_Info() {
		return add_Info;
	}
	public void setAdd_Info(String add_Info) {
		this.add_Info = add_Info;
	}
	
	public Integer getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Integer getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(Integer updated_by) {
		this.updated_by = updated_by;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	public BigDecimal getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(BigDecimal paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	public String getLogicalGrpRef() {
		return logicalGrpRef;
	}
	public void setLogicalGrpRef(String logicalGrpRef) {
		this.logicalGrpRef = logicalGrpRef;
	}
}
