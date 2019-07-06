package com.boostrdev.weblogic.legacy.model;

import java.util.Date;

public class HistoryCommentView {


	private Long comment_id;
	private Long payment_instruction_id;
	private Long payment_id;
	private String comments;
	private String status;
	private Long created_by;
	private Date creation_date;
	private Date last_update_date;
	private Long last_update_by;
	private Long org_id;
	
	
	public HistoryCommentView() {
		super();
	}
	public HistoryCommentView(Long comment_id, Long payment_instruction_id, Long payment_id, String comments,
			String status, Long created_by, Date creation_date, Date last_update_date, Long last_update_by,
			Long org_id) {
		super();
		this.comment_id = comment_id;
		this.payment_instruction_id = payment_instruction_id;
		this.payment_id = payment_id;
		this.comments = comments;
		this.status = status;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
		this.last_update_by = last_update_by;
		this.org_id = org_id;
	}
	public Long getComment_id() {
		return comment_id;
	}
	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
	}
	public Long getPayment_instruction_id() {
		return payment_instruction_id;
	}
	public void setPayment_instruction_id(Long payment_instruction_id) {
		this.payment_instruction_id = payment_instruction_id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public Date getLast_update_date() {
		return last_update_date;
	}
	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}
	public Long getLast_update_by() {
		return last_update_by;
	}
	public void setLast_update_by(Long last_update_by) {
		this.last_update_by = last_update_by;
	}
	public Long getOrg_id() {
		return org_id;
	}
	public void setOrg_id(Long org_id) {
		this.org_id = org_id;
	}
	@Override
	public String toString() {
		return "HistoryCommentView [comment_id=" + comment_id + ", payment_instruction_id=" + payment_instruction_id
				+ ", payment_id=" + payment_id + ", comments=" + comments + ", status=" + status + ", created_by="
				+ created_by + ", creation_date=" + creation_date + ", last_update_date=" + last_update_date
				+ ", last_update_by=" + last_update_by + ", org_id=" + org_id + "]";
	}
	
	
}

