package com.boostrdev.weblogic.legacy.service;

import java.util.List;

import com.boostrdev.weblogic.legacy.model.EncodedData;
import com.boostrdev.weblogic.legacy.model.FilterData;
import com.boostrdev.weblogic.legacy.model.HistoryCommentView;
import com.boostrdev.weblogic.legacy.model.InvoiceDtlsView;
import com.boostrdev.weblogic.legacy.model.Payment;
import com.boostrdev.weblogic.legacy.model.PaymentFileView;
import com.boostrdev.weblogic.legacy.model.PaymentStatistics;
import com.boostrdev.weblogic.legacy.model.PaymentView;

/*import com.citiconnect.payment.model.HistoryCommentView;
import com.citiconnect.payment.model.InvoiceDtlsView;
import com.citiconnect.payment.model.Payment;
import com.citiconnect.payment.model.PaymentFileView;
import com.citiconnect.payment.model.PaymentStatistics;
import com.citiconnect.payment.model.PaymentView;*/

public interface PaymentMonitorService {
    public List<PaymentStatistics> getPaymentStatusCount() ;
	List<PaymentView> advFilter(Payment payment);
	public List<PaymentFileView> advFileFilter(Payment obj);
	public List<PaymentView> filePaymentDtls(PaymentFileView obj);
	public List<InvoiceDtlsView> invoiceDtls(PaymentView obj);
	List<PaymentStatistics> getfileStatusCount();
	public void updateDeletePmtComment(PaymentView obj);
	public void updateDeleteFileComment(PaymentFileView obj);
	public List<HistoryCommentView> pmtCommentHistory(PaymentView obj);
	public List<HistoryCommentView> fileCommentHistory(PaymentFileView obj);
	public FilterData getdecryptedParams(EncodedData params);
	public List<PaymentFileView> advFilterFilePage(Payment obj, int pageNo, int pageSize);
}
