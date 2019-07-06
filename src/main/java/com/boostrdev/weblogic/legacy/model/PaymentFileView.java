package com.boostrdev.weblogic.legacy.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentFileView {

	private String createdDate;
	private Long id;
	private Long orgMsgId;
	private String orgCreDt;
	private String orgGroup;
	private String proposalRun;
	private String status;
	private String duplicate;
	private String incomingMsgType;
	private Long noOfTrasn;
	private String orgCntrlSum;
	private Long psrMsgId;
	private String psrAckCreDt;
	private String pmtGrpStatus;
	private String addInfo;
	private Long createdBy;
	private Long modifiedBy;
	private String modifiedDt;
	private String comments;
	private Long org_id;
	private Long payment_instruction_id;
	private String ackStatus;
	private String file_name;
	private int countRows;
	public PaymentFileView() {
	//default constructor
	}
	public PaymentFileView(String createdDate, Long id, Long orgMsgId, String orgCreDt, String orgGroup,
			String proposalRun, String status, String duplicate, String incomingMsgType, Long noOfTrasn,
			String orgCntrlSum, Long psrMsgId, String psrAckCreDt, String pmtGrpStatus, String addInfo, Long createdBy,
			Long modifiedBy, String modifiedDt, String comments, Long org_id, Long payment_instruction_id,String ackStatus, String file_name) {
		super();
		this.createdDate = createdDate;
		this.id = id;
		this.orgMsgId = orgMsgId;
		this.orgCreDt = orgCreDt;
		this.orgGroup = orgGroup;
		this.proposalRun = proposalRun;
		this.status = status;
		this.duplicate = duplicate;
		this.incomingMsgType = incomingMsgType;
		this.noOfTrasn = noOfTrasn;
		this.orgCntrlSum = orgCntrlSum;
		this.psrMsgId = psrMsgId;
		this.psrAckCreDt = psrAckCreDt;
		this.pmtGrpStatus = pmtGrpStatus;
		this.addInfo = addInfo;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.modifiedDt = modifiedDt;
		this.comments = comments;
		this.org_id = org_id;
		this.payment_instruction_id = payment_instruction_id;
		this.ackStatus=ackStatus;
		this.file_name=file_name;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getAckStatus() {
		return ackStatus;
	}
	public void setAckStatus(String ackStatus) {
		this.ackStatus = ackStatus;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getCountRows() {
		return countRows;
	}
	public void setCountRows(int countRows) {
		this.countRows = countRows;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrgMsgId() {
		return orgMsgId;
	}
	public void setOrgMsgId(Long orgMsgId) {
		this.orgMsgId = orgMsgId;
	}
	public String getOrgCreDt() {
		return orgCreDt;
	}
	public void setOrgCreDt(String orgCreDt) {
		this.orgCreDt = orgCreDt;
	}
	public String getOrgGroup() {
		return orgGroup;
	}
	public void setOrgGroup(String orgGroup) {
		this.orgGroup = orgGroup;
	}
	public String getProposalRun() {
		return proposalRun;
	}
	public void setProposalRun(String proposalRun) {
		this.proposalRun = proposalRun;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDuplicate() {
		return duplicate;
	}
	public void setDuplicate(String duplicate) {
		this.duplicate = duplicate;
	}
	public String getIncomingMsgType() {
		return incomingMsgType;
	}
	public void setIncomingMsgType(String incomingMsgType) {
		this.incomingMsgType = incomingMsgType;
	}
	public Long getNoOfTrasn() {
		return noOfTrasn;
	}
	public void setNoOfTrasn(Long noOfTrasn) {
		this.noOfTrasn = noOfTrasn;
	}
	public String getOrgCntrlSum() {
		return orgCntrlSum;
	}
	public void setOrgCntrlSum(String orgCntrlSum) {
		this.orgCntrlSum = orgCntrlSum;
	}
	public Long getPsrMsgId() {
		return psrMsgId;
	}
	public void setPsrMsgId(Long psrMsgId) {
		this.psrMsgId = psrMsgId;
	}
	public String getPsrAckCreDt() {
		return psrAckCreDt;
	}
	public void setPsrAckCreDt(String psrAckCreDt) {
		this.psrAckCreDt = psrAckCreDt;
	}
	public String getPmtGrpStatus() {
		return pmtGrpStatus;
	}
	public void setPmtGrpStatus(String pmtGrpStatus) {
		this.pmtGrpStatus = pmtGrpStatus;
	}
	public String getAddInfo() {
		return addInfo;
	}
	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDt() {
		return modifiedDt;
	}
	public void setModifiedDt(String modifiedDt) {
		this.modifiedDt = modifiedDt;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Long getOrg_id() {
		return org_id;
	}
	public void setOrg_id(Long org_id) {
		this.org_id = org_id;
	}
	public Long getPayment_instruction_id() {
		return payment_instruction_id;
	}
	public void setPayment_instruction_id(Long payment_instruction_id) {
		this.payment_instruction_id = payment_instruction_id;
	}
	@Override
	public String toString() {
		return "PaymentFileView [createdDate=" + createdDate + ", id=" + id + ", orgMsgId=" + orgMsgId + ", orgCreDt="
				+ orgCreDt + ", orgGroup=" + orgGroup + ", proposalRun=" + proposalRun + ", status=" + status
				+ ", duplicate=" + duplicate + ", incomingMsgType=" + incomingMsgType + ", noOfTrasn=" + noOfTrasn
				+ ", orgCntrlSum=" + orgCntrlSum + ", psrMsgId=" + psrMsgId + ", psrAckCreDt=" + psrAckCreDt
				+ ", pmtGrpStatus=" + pmtGrpStatus + ", addInfo=" + addInfo + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", modifiedDt=" + modifiedDt + ", comments=" + comments + ", org_id="
				+ org_id + ", payment_instruction_id=" + payment_instruction_id + ", ackStatus=" + ackStatus
				+ ", file_name=" + file_name + "]";
	}



	



	
	
	
}
