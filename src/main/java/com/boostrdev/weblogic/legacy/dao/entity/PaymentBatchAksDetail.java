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

/**
 * @author dolai_p
 *
 */
@Entity
@Table(name="CITI_CNT_PAYBATCH_ACK_DETAILS")
public class PaymentBatchAksDetail implements Serializable {
	private static final long serialVersionUID = 1323221L;
	@Id
	@Column(name = "PAYBATCH_ACK_ID")
	private String paymentBatchAckID;
	@Column(name = "PAYMENT_INSTRUCTION_ID")
	private BigDecimal payment_instruction_id; 
	@Column(name = "ACK_STATUS")
	private String ack_status;
	@Column(name = "FILE_NAME")
	private String file_name;
	private Integer created_by;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE")
	private Date created_date;
	@Column(name = "LAST_UPDATED_BY")
	private Integer updated_by;
	@Column(name = "LAST_UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date  updated_date;
	private BigDecimal org_id;
	private String file_status;
	@Column(name = "ADDITIONAL_INFO")
	private String additional_Info;
	
	public String getPaymentBatchAckID() {
		return paymentBatchAckID;
	}
	public void setPaymentBatchAckID(String paymentBatchAckID) {
		this.paymentBatchAckID = paymentBatchAckID;
	}
	
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
	/*public String getAck_id() {
		return paymentBatchAckID;
	}
	public void setAck_id(String ack_id) {
		this.paymentBatchAckID = ack_id;
	}*/
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
	public String getAdditional_Info() {
		return additional_Info;
	}
	public void setAdditional_Info(String additional_Info) {
		this.additional_Info = additional_Info;
	}
	
}
