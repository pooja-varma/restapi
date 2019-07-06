package com.boostrdev.weblogic.legacy.model;


import java.util.Date;

public class Payment {
	
	private Date fromDate;
	private Date toDate;
	private Date pmtfromDate;
	private Date pmttoDate;
	private String identification;
	private String pmtGpSts;
	private String houseBk;
	private String accId;
	private String payingCmpCode;
	private String sendingCmpCode;
	private String busiPartRef;
	private String pmtMethod;
	private String pmtMtSupp;
	private StatusCombo orgName;
	private StatusCombo pmtselectedStatus;
	private StatusCombo selectedStatus;
	private StatusCombo selectedOrgname;
	private Integer pageNo;
    private Integer pageSize;
    private Integer totalRecords;
    
	public Payment() {
		//Default constructor
	}
	public Integer getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public StatusCombo getSelectedOrgname() {
		return selectedOrgname;
	}
	public void setSelectedOrgname(StatusCombo selectedOrgname) {
		this.selectedOrgname = selectedOrgname;
	}
	
	public Date getPmtfromDate() {
		return pmtfromDate;
	}
	public void setPmtfromDate(Date pmtfromDate) {
		this.pmtfromDate = pmtfromDate;
	}
	public Date getPmttoDate() {
		return pmttoDate;
	}
	public void setPmttoDate(Date pmttoDate) {
		this.pmttoDate = pmttoDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getPmtGpSts() {
		return pmtGpSts;
	}
	public void setPmtGpSts(String pmtGpSts) {
		this.pmtGpSts = pmtGpSts;
	}
	public String getHouseBk() {
		return houseBk;
	}
	public void setHouseBk(String houseBk) {
		this.houseBk = houseBk;
	}
	public String getAccId() {
		return accId;
	}
	public void setAccId(String accId) {
		this.accId = accId;
	}
	public String getPayingCmpCode() {
		return payingCmpCode;
	}
	public void setPayingCmpCode(String payingCmpCode) {
		this.payingCmpCode = payingCmpCode;
	}
	public String getSendingCmpCode() {
		return sendingCmpCode;
	}
	public void setSendingCmpCode(String sendingCmpCode) {
		this.sendingCmpCode = sendingCmpCode;
	}
	public String getBusiPartRef() {
		return busiPartRef;
	}
	public void setBusiPartRef(String busiPartRef) {
		this.busiPartRef = busiPartRef;
	}
	public String getPmtMethod() {
		return pmtMethod;
	}
	public void setPmtMethod(String pmtMethod) {
		this.pmtMethod = pmtMethod;
	}
	public String getPmtMtSupp() {
		return pmtMtSupp;
	}
	public void setPmtMtSupp(String pmtMtSupp) {
		this.pmtMtSupp = pmtMtSupp;
	}

	public StatusCombo getOrgName() {
		return orgName;
	}

	public void setOrgName(StatusCombo orgName) {
		this.orgName = orgName;
	}

	public StatusCombo getPmtselectedStatus() {
		return pmtselectedStatus;
	}

	public void setPmtselectedStatus(StatusCombo pmtselectedStatus) {
		this.pmtselectedStatus = pmtselectedStatus;
	}

	public StatusCombo getSelectedStatus() {
		return selectedStatus;
	}

	public void setSelectedStatus(StatusCombo selectedStatus) {
		this.selectedStatus = selectedStatus;
	}

	@Override
	public String toString() {
		return "Payment [fromDate=" + fromDate + ", toDate=" + toDate + ", pmtfromDate=" + pmtfromDate + ", pmttoDate="
				+ pmttoDate + ", identification=" + identification + ", pmtGpSts=" + pmtGpSts + ", houseBk=" + houseBk
				+ ", accId=" + accId + ", payingCmpCode=" + payingCmpCode + ", sendingCmpCode=" + sendingCmpCode
				+ ", busiPartRef=" + busiPartRef + ", pmtMethod=" + pmtMethod + ", pmtMtSupp=" + pmtMtSupp
				+ ", orgName=" + orgName + ", pmtselectedStatus=" + pmtselectedStatus + ", selectedStatus="
				+ selectedStatus + ", selectedOrgname=" + selectedOrgname + ", pageNo=" + pageNo + ", pageSize="
				+ pageSize + ", totalRecords=" + totalRecords + "]";
	}	

}
