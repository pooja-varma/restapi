package com.boostrdev.weblogic.legacy.service.impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boostrdev.weblogic.legacy.dao.PaymentMonitorDao;
import com.boostrdev.weblogic.legacy.model.EncodedData;
import com.boostrdev.weblogic.legacy.model.FilterData;
import com.boostrdev.weblogic.legacy.model.HistoryCommentView;
import com.boostrdev.weblogic.legacy.model.InvoiceDtlsView;
import com.boostrdev.weblogic.legacy.model.Payment;
import com.boostrdev.weblogic.legacy.model.PaymentFileView;
import com.boostrdev.weblogic.legacy.model.PaymentStatistics;
import com.boostrdev.weblogic.legacy.model.PaymentView;
import com.boostrdev.weblogic.legacy.service.PaymentMonitorService;

@Service
public class PaymentMonitorServiceImpl implements PaymentMonitorService {

	@Autowired
	PaymentMonitorDao paymentMonitorDao;

	public List<PaymentView> advFilter(Payment payment) {
		return paymentMonitorDao.advFilter(payment);
	}

	@Override
	public List<PaymentStatistics> getPaymentStatusCount() {
		return paymentMonitorDao.getPaymentStatusCount();
	}

	@Override
	public List<PaymentStatistics> getfileStatusCount() {
		return paymentMonitorDao.getfileStatusCount();
	}

	@Override
	public List<PaymentFileView> advFileFilter(Payment obj) {
		return paymentMonitorDao.advFileFilter(obj);
	}

	@Override
	public List<PaymentFileView> advFilterFilePage(Payment obj, int pageNo, int pageSize) {
		return paymentMonitorDao.advFileFilter(obj,pageNo,pageSize);
	}

	@Override
	public List<PaymentView> filePaymentDtls(PaymentFileView obj) {
		return paymentMonitorDao.filePaymentDtls(obj);
	}

	@Override
	public List<InvoiceDtlsView> invoiceDtls(PaymentView obj) {
		return paymentMonitorDao.invoiceDtls(obj);

	}

	@Override
	public void updateDeletePmtComment(PaymentView obj) {
		paymentMonitorDao.updateDeletePmtComment(obj);
	}

	@Override
	public void updateDeleteFileComment(PaymentFileView obj) {
		paymentMonitorDao.updateDeleteFileComment(obj);

	}

	@Override
	public List<HistoryCommentView> pmtCommentHistory(PaymentView obj) {
		return paymentMonitorDao.pmtCommentHistory(obj);

	}

	@Override
	public List<HistoryCommentView> fileCommentHistory(PaymentFileView obj) {
		return paymentMonitorDao.fileCommentHistory(obj);
	}

	@Override
	public FilterData getdecryptedParams(EncodedData value) {

		byte[] actualByte = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.decode(value.getParams());
		FilterData decodedData=new FilterData();
		String actualString = new String(actualByte);

		// print actual String 
		System.out.println("actual String:\n" + actualString);
		String strparams[]=actualString.split("\\&");
		
		String ouName[]=strparams[0].split("\\;");
		String respId[]=strparams[1].split("\\=");
		String userId[]=strparams[2].split("\\=");
		String orgId[]=strparams[3].split("\\=");
		//Vision Operations;&respId=20639&userId=1318&orgId=204;
		
		decodedData.setOuName(ouName);
		decodedData.setRespId(respId[1]);
		decodedData.setUserId(userId[1]);
		decodedData.setOrgId(orgId[1]);
		
		List<Integer> count=new ArrayList<Integer>();
		count=paymentMonitorDao.validateUser(respId[1],userId[1]);
		System.out.println(count.get(0));
		int countrow=count.get(0);
		if(countrow>0) {
		return decodedData;
		}
		else
		return null;
	}

}
