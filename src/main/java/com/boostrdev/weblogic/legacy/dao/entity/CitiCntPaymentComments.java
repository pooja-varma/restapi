package com.boostrdev.weblogic.legacy.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @author panchal_p
 *
 */
@Entity
public class CitiCntPaymentComments implements Serializable {
	private static final long serialVersionUID = 1213321L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "CITI_CNT_PAY_COMM_SEQ")
	private Long comment_id;
	
	private Long payment_id;
	private String comments;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation_date;
	private Long created_by;
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_update_date;
	private Long last_updated_by;
	private Long org_id;
	private String status;
	private Long payment_instruction_id;
	public CitiCntPaymentComments() {
		// Default Constructor
	}


	public CitiCntPaymentComments(Long comment_id, Long payment_id, String comments, Date creation_date,
			Long created_by, Date last_update_date, Long last_updated_by, Long org_id, String status,
			Long payment_instruction_id) {
		super();
		this.comment_id = comment_id;
		this.payment_id = payment_id;
		this.comments = comments;
		this.creation_date = creation_date;
		this.created_by = created_by;
		this.last_update_date = last_update_date;
		this.last_updated_by = last_updated_by;
		this.org_id = org_id;
		this.status = status;
		this.payment_instruction_id = payment_instruction_id;
	}

	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Long getPayment_instruction_id() {
		return payment_instruction_id;
	}


	public void setPayment_instruction_id(Long payment_instruction_id) {
		this.payment_instruction_id = payment_instruction_id;
	}


	public Long getComment_id() {
		return comment_id;
	}

	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
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

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Long getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public Long getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(Long last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Long getOrg_id() {
		return org_id;
	}

	public void setOrg_id(Long org_id) {
		this.org_id = org_id;
	}
	
}
