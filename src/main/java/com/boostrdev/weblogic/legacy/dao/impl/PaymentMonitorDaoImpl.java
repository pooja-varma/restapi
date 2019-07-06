package com.boostrdev.weblogic.legacy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.boostrdev.weblogic.legacy.dao.PaymentMonitorDao;
import com.boostrdev.weblogic.legacy.model.HistoryCommentView;
import com.boostrdev.weblogic.legacy.model.InvoiceDtlsView;
import com.boostrdev.weblogic.legacy.model.Payment;
import com.boostrdev.weblogic.legacy.model.PaymentFileView;
/*import com.boostrdev.weblogic.legacy.dao.entity.CitiCntPaymentComments;
import com.boostrdev.weblogic.legacy.dao.repository.CommentRepository;
import com.citiconnect.payment.model.HistoryCommentView;
import com.citiconnect.payment.model.InvoiceDtlsView;
import com.citiconnect.payment.model.Payment;
import com.citiconnect.payment.model.PaymentFileView;
import com.citiconnect.payment.model.PaymentStatistics;
import com.citiconnect.payment.model.PaymentView;*/
import com.boostrdev.weblogic.legacy.model.PaymentStatistics;
import com.boostrdev.weblogic.legacy.model.PaymentView;


@Repository
public class PaymentMonitorDaoImpl implements PaymentMonitorDao {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<PaymentFileView> advFileFilter(Payment obj, int pageNo, int pageSize) {
		List<PaymentFileView> paymentslist = new ArrayList<PaymentFileView>();

		
		int startRowIndex, endRowIndex = 0;
		startRowIndex = ((pageNo - 1) * pageSize) + 1;
		endRowIndex = (startRowIndex - 1) + pageSize;

		try {

			final int result = jdbcTemplate.queryForObject(QueryBuilder.countFileFilterQuery(obj), Integer.class);
			paymentslist = jdbcTemplate.query(QueryBuilder.createFileFilterQuery(obj, startRowIndex, endRowIndex),
					new RowMapper<PaymentFileView>() {
						public PaymentFileView mapRow(ResultSet rs, int rowNum) throws SQLException {
							PaymentFileView pmtRow = new PaymentFileView();
							DecimalFormat decimalFormat = new DecimalFormat("#0.00");
							pmtRow.setCreatedDate(rs.getString("CREATION_DATE"));
							pmtRow.setStatus(rs.getString("PAYMENT_INSTRUCTION_STATUS"));
							pmtRow.setFile_name(rs.getString("FILE_NAME"));
							pmtRow.setIncomingMsgType(rs.getString("PIUID"));
							pmtRow.setNoOfTrasn(rs.getLong("PAYMENT_COUNT"));
							pmtRow.setOrgCntrlSum(decimalFormat.format(rs.getFloat("PAYMENT_AMOUNT")));
							pmtRow.setPmtGrpStatus(rs.getString("PAYMENT_INSTRUCTION_STATUS"));
							pmtRow.setAddInfo(rs.getString("additional_info"));
							pmtRow.setCreatedBy(rs.getLong("CREATED_BY"));
							pmtRow.setModifiedBy(rs.getLong("LAST_UPDATED_BY"));
							pmtRow.setModifiedDt(rs.getString("LAST_UPDATE_DATE"));
							pmtRow.setComments(rs.getString("COMMENTS"));
							pmtRow.setOrg_id(rs.getLong("ORG_ID"));
							pmtRow.setPayment_instruction_id(rs.getLong("payment_instruction_id"));
							pmtRow.setAckStatus(rs.getString("ACK_STATUS"));
							pmtRow.setCountRows(result);
							return pmtRow;
						}
						
					});
			for (PaymentFileView aContact : paymentslist) {
				System.out.println(aContact);
			}
			

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// return filteredData;
		return paymentslist;

	}

	@Override
	public List<PaymentFileView> advFileFilter(Payment obj) {
		List<PaymentFileView> paymentslist=new ArrayList<PaymentFileView>();
		try {
			 paymentslist = jdbcTemplate.query(QueryBuilder.createFileFilterQuery(obj), new RowMapper<PaymentFileView>() {
				public PaymentFileView mapRow(ResultSet rs, int rowNum) throws SQLException {
					PaymentFileView pmtRow = new PaymentFileView();
				//	decimalFormat.setRoundingMode(RoundingMode.CEILING);
					DecimalFormat decimalFormat = new DecimalFormat("#0.00");
					pmtRow.setCreatedDate(rs.getString("CREATION_DATE"));
			//		pmtRow.setId(rs.getLong("PAYMENT_INSTRUCTION_ID"));
					
				//	pmtRow.setOrgMsgId(rs.getLong("payment_instruction_id"));
				//	pmtRow.setOrgCreDt(rs.getDate("CREATION_DATE"));
				//	pmtRow.setOrgGroup(orgGroup);(rs.getLong("supplier_site_id"));
				//	pmtRow.setProposalRun(proposalRun);(rs.getString("supplier_site_name"));
					pmtRow.setStatus(rs.getString("PAYMENT_INSTRUCTION_STATUS"));
					pmtRow.setFile_name(rs.getString("FILE_NAME"));
				//	pmtRow.setDuplicate(rs.getString("already_exists"));
					pmtRow.setIncomingMsgType(rs.getString("PIUID"));
					pmtRow.setNoOfTrasn(rs.getLong("PAYMENT_COUNT"));
					pmtRow.setOrgCntrlSum(decimalFormat.format(rs.getFloat("PAYMENT_AMOUNT")));
				//	pmtRow.setPsrMsgId(rs.getString("bank_account_number"));
				//	pmtRow.setPsrAckCreDt(rs.getString("bank_account_name"));
					pmtRow.setPmtGrpStatus(rs.getString("PAYMENT_INSTRUCTION_STATUS"));
					pmtRow.setAddInfo(rs.getString("additional_info"));
					pmtRow.setCreatedBy(rs.getLong("CREATED_BY"));
					pmtRow.setModifiedBy(rs.getLong("LAST_UPDATED_BY"));
					pmtRow.setModifiedDt(rs.getString("LAST_UPDATE_DATE"));
					pmtRow.setComments(rs.getString("COMMENTS"));
					pmtRow.setOrg_id(rs.getLong("ORG_ID"));
					pmtRow.setPayment_instruction_id(rs.getLong("payment_instruction_id"));
					pmtRow.setAckStatus(rs.getString("ACK_STATUS"));
					
					return pmtRow;
				}

			});
			for (PaymentFileView aContact : paymentslist) {
				System.out.println(aContact);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// return filteredData;
		return paymentslist;
	
	}
	
	public List<PaymentView> advFilter(Payment payment) {
		List<PaymentView> paymentslist=new ArrayList<PaymentView>();
		try {
			 paymentslist = jdbcTemplate.query(QueryBuilder.createPaymentFilterQuery(payment), new RowMapper<PaymentView>() {
				public PaymentView mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					return mapPaymentDtls(rs);
				}

			});
			for (PaymentView aContact : paymentslist) {
				System.out.println(aContact);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// return filteredData;
		return paymentslist;
	}
	
	private PaymentView mapPaymentDtls(ResultSet rs) throws SQLException{
		PaymentView pmtRow = new PaymentView();
	//	decimalFormat.setRoundingMode(RoundingMode.CEILING);
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		pmtRow.setPayment_id(rs.getLong("payment_id"));
		pmtRow.setPayment_number(rs.getLong("payment_number"));
		pmtRow.setComments(rs.getString("comments"));
		pmtRow.setSupplier_id(rs.getLong("supplier_id"));
		pmtRow.setSupplier_name(rs.getString("supplier_name"));
		pmtRow.setSupplier_site_id(rs.getLong("supplier_site_id"));
		pmtRow.setSupplier_site_name(rs.getString("supplier_site_name"));
		pmtRow.setPayment_method_code(rs.getString("payment_method_code"));
		pmtRow.setPayment_status(rs.getString("payment_status"));
		pmtRow.setFile_name(rs.getString("FILE_NAME"));
		pmtRow.setPayment_amount(decimalFormat.format(rs.getFloat("payment_amount")));
		pmtRow.setPayment_currency_code(rs.getString("payment_currency_code"));
		pmtRow.setOrg_id(rs.getLong("org_id"));
	//	pmtRow.setBank_id(rs.getLong("bank_id"));
//		pmtRow.setBank_account_number(rs.getString("bank_account_number"));
	//	pmtRow.setBank_account_name(rs.getString("bank_account_name"));
	//	pmtRow.setBank_branch_name(rs.getString("bank_branch_name"));
		pmtRow.setRequest_id(rs.getLong("request_id"));
		pmtRow.setPayment_date(rs.getString("payment_date"));
		pmtRow.setCreation_date(rs.getString("creation_date"));
		pmtRow.setCreated_by(rs.getLong("created_by"));
		pmtRow.setLast_update_date(rs.getString("last_update_date"));
		pmtRow.setLast_updated_by(rs.getLong("last_updated_by"));
		pmtRow.setFile_status(rs.getString("file_status"));
		pmtRow.setAck_status(rs.getString("ack_status"));
		pmtRow.setPayment_instruction_id(rs.getLong("payment_instruction_id"));
		return pmtRow;
	}

	@Override
	public List<PaymentStatistics> getPaymentStatusCount() {
		List<PaymentStatistics> paymentStat=new ArrayList<PaymentStatistics>();
		paymentStat = jdbcTemplate.query(QueryBuilder.createPaymentCountQuery(), new RowMapper<PaymentStatistics>() {
			public PaymentStatistics mapRow(ResultSet rs, int rowNum) throws SQLException {
				PaymentStatistics pmtRow = new PaymentStatistics();
				pmtRow.setStatus(rs.getString("PAYMENT_STATUS"));
				pmtRow.setCnt(rs.getInt("COUNT(V.PAYMENT_STATUS)"));
				return pmtRow;
			}

		});
		for (PaymentStatistics aContact : paymentStat) {
			System.out.println(aContact);
		}

		// return filteredData;
		return paymentStat;
	}

	@Override
	public List<PaymentStatistics> getfileStatusCount() {
		List<PaymentStatistics> paymentStat=new ArrayList<PaymentStatistics>();
		paymentStat = jdbcTemplate.query(QueryBuilder.createFileCountQuery(), new RowMapper<PaymentStatistics>() {
			public PaymentStatistics mapRow(ResultSet rs, int rowNum) throws SQLException {
				PaymentStatistics pmtRow = new PaymentStatistics();
				pmtRow.setStatus(rs.getString("PAYMENT_STATUS"));
				pmtRow.setCnt(rs.getInt("COUNT(V.PAYMENT_STATUS)"));
				return pmtRow;
			}

		});
		for (PaymentStatistics aContact : paymentStat) {
			System.out.println(aContact);
		}

		// return filteredData;
		return paymentStat;
	}
	
	@Override
	public List<PaymentView> filePaymentDtls(PaymentFileView obj) {
		//return paymentDetailRepository.findByPayment_id(obj.getId());
		
		List<PaymentView> pmtDtls=new ArrayList<PaymentView>();
		pmtDtls = jdbcTemplate.query(QueryBuilder.paymentDtlsByPaymentId(obj), new RowMapper<PaymentView>() {
			public PaymentView mapRow(ResultSet rs, int rowNum) throws SQLException {
				return mapPaymentDtls(rs);
			}
		});
		for (PaymentView aContact : pmtDtls) {
			System.out.println(aContact);
		}
		return pmtDtls;
	}

	@Override
	public List<InvoiceDtlsView> invoiceDtls(PaymentView obj) {
		//return invoiceDetailsRepository.findByPayment_id(obj.getPayment_id());
		List<InvoiceDtlsView> invoiceDtls=new ArrayList<InvoiceDtlsView>();
		invoiceDtls = jdbcTemplate.query(QueryBuilder.invoiceByPaymentId(obj), new RowMapper<InvoiceDtlsView>() {
			public InvoiceDtlsView mapRow(ResultSet rs, int rowNum) throws SQLException {
				InvoiceDtlsView pmtRow = new InvoiceDtlsView();
				DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		//		decimalFormat.setRoundingMode(RoundingMode.CEILING);
				pmtRow.setPayment_id(rs.getLong("payment_id"));
				pmtRow.setInvoice_num(rs.getString("invoice_num"));
				pmtRow.setInvoice_amount(decimalFormat.format(rs.getFloat("invoice_amount")));
				pmtRow.setInvoice_currency_code(rs.getString("invoice_currency_code"));
				pmtRow.setInvoice_date(rs.getString("invoice_date"));
				pmtRow.setInvoice_id(rs.getLong("invoice_id"));
				pmtRow.setCreated_by(rs.getLong("created_by"));
				pmtRow.setCreation_date(rs.getString("creation_date"));
				pmtRow.setLast_update_date(rs.getString("last_update_date"));
				pmtRow.setLast_updated_by(rs.getLong("last_updated_by"));
				pmtRow.setOrg_id(rs.getString("org_id"));
				pmtRow.setPayment_method_code(rs.getString("payment_method_code"));
				pmtRow.setRequest_id(rs.getLong("request_id"));
				pmtRow.setSupplier_name(rs.getString("supplier_name"));
				pmtRow.setSupplier_site_name(rs.getString("supplier_site_name"));
				return pmtRow;
			}
		});
		for (InvoiceDtlsView aContact : invoiceDtls) {
			System.out.println(aContact);
		}
		return invoiceDtls;
	}

	
	@Override
	public void updateDeletePmtComment(PaymentView obj) {
		Date lastupdate=new Date();
		   final String insertSql = "INSERT INTO citi_cnt_payment_comments (" +
			"PAYMENT_INSTRUCTION_ID, " +
			"PAYMENT_ID, " +
			"COMMENTS, " +
			"CREATED_BY, " +
			"CREATION_DATE, " +
			"LAST_UPDATE_DATE, " +
			"LAST_UPDATED_BY, " +
			"ORG_ID, " +
			"STATUS) " +
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		   
		saveRecord(insertSql,0l,obj.getPayment_id(),obj.getComments(),obj.getCreated_by(),
		obj.getCreation_date(),lastupdate,obj.getLast_updated_by(),obj.getOrg_id(),"PmtCmt");
	}

	
	 public void saveRecord(String insertSql,Long payment_instruction_id,Long payment_id, String comments, Long created_by,
			 String creation_date,Date last_update_date, Long last_updated_by, Long org_id, String status) { 
	         
	        // define query arguments
	        Object[] params = new Object[] {payment_instruction_id,payment_id,comments,created_by,
	   			creation_date,last_update_date,last_updated_by,org_id,status};
	         
	        // define SQL types of the arguments
	       int[] types = new int[] { Types.NUMERIC, Types.NUMERIC, Types.VARCHAR, Types.NUMERIC, 
	        		Types.TIMESTAMP,Types.TIMESTAMP,Types.NUMERIC,Types.NUMERIC,Types.VARCHAR };
	 
	        // execute insert query to insert the data
	        // return number of row / rows processed by the executed query
	        int row = jdbcTemplate.update(insertSql, params, types);
	        System.out.println(row + " row inserted.");
	         
	    }
	
	@Override
	public void updateDeleteFileComment(PaymentFileView obj) {
	Date lastupdate=new Date();
		   final String insertSql = "INSERT INTO citi_cnt_payment_comments (" +
			"PAYMENT_INSTRUCTION_ID, " +
			"PAYMENT_ID, " +
			"COMMENTS, " +
			"CREATED_BY, " +
			"CREATION_DATE, " +
			"LAST_UPDATE_DATE, " +
			"LAST_UPDATED_BY, " +
			"ORG_ID, " +
			"STATUS) " +
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		   
		saveRecord(insertSql,obj.getPayment_instruction_id(),0l,obj.getComments(),obj.getCreatedBy(),
		obj.getCreatedDate(),lastupdate,obj.getModifiedBy(),obj.getOrg_id(),"FileCmt");
	}

	@Override
	public List<HistoryCommentView> pmtCommentHistory(PaymentView obj) {
		List<HistoryCommentView> cmtDtls=new ArrayList<HistoryCommentView>();
		cmtDtls = jdbcTemplate.query(QueryBuilder.pmtCommentHistory(obj), new RowMapper<HistoryCommentView>() {
			public HistoryCommentView mapRow(ResultSet rs, int rowNum) throws SQLException {
				 return mapComments(rs);
			}

		});
		for (HistoryCommentView aContact : cmtDtls) {
			System.out.println(aContact);
		}
		return cmtDtls;
	}

	private HistoryCommentView mapComments(ResultSet rs) throws SQLException {
		HistoryCommentView comment=new HistoryCommentView();
		comment.setComment_id(rs.getLong("comment_id"));
		comment.setPayment_instruction_id(rs.getLong("payment_instruction_id"));
		comment.setPayment_id(rs.getLong("payment_id"));
		comment.setComments(rs.getString("comments"));
		comment.setStatus(rs.getString("status"));
		comment.setCreated_by(rs.getLong("created_by"));
		comment.setCreation_date(rs.getDate("creation_date"));
		comment.setLast_update_date(rs.getDate("last_update_date"));
		comment.setLast_update_by(rs.getLong("last_updated_by"));
		comment.setOrg_id(rs.getLong("org_id"));
		
		return comment;
	}
	@Override
	public List<HistoryCommentView> fileCommentHistory(PaymentFileView obj) {
		List<HistoryCommentView> cmtDtls=new ArrayList<HistoryCommentView>();
		cmtDtls = jdbcTemplate.query(QueryBuilder.fileCommentHistory(obj), new RowMapper<HistoryCommentView>() {
			public HistoryCommentView mapRow(ResultSet rs, int rowNum) throws SQLException {
				 return mapComments(rs);
			}

		});
		for (HistoryCommentView aContact : cmtDtls) {
			System.out.println(aContact);
		}
		return cmtDtls;
	}

	@Override
	public List<Integer> validateUser(String resId, String userId) {
		List<Integer> count=new ArrayList<Integer>();
		count = jdbcTemplate.query(QueryBuilder.validateUser(resId,userId), new RowMapper<Integer>() {
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				 return rs.getRow();
			}

		});
		
		return count;
	}
	
}
