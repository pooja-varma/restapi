package com.boostrdev.weblogic.legacy.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boostrdev.weblogic.legacy.model.EncodedData;
import com.boostrdev.weblogic.legacy.model.FilterData;
import com.boostrdev.weblogic.legacy.model.HistoryCommentView;
import com.boostrdev.weblogic.legacy.model.InvoiceDtlsView;
import com.boostrdev.weblogic.legacy.model.Payment;
import com.boostrdev.weblogic.legacy.model.PaymentFileView;
import com.boostrdev.weblogic.legacy.model.PaymentStatistics;
import com.boostrdev.weblogic.legacy.model.PaymentView;
import com.boostrdev.weblogic.legacy.service.PaymentMonitorService;

@RestController
@CrossOrigin(origins="*")
public class PaymentMonitorController {

	@Autowired
	private PaymentMonitorService paymentMonitorService;
	private final Logger logger = LoggerFactory.getLogger(PaymentMonitorController.class);

	@RequestMapping(value="/paymentDetailCount" ,method = RequestMethod.GET)
	public @ResponseBody List<PaymentStatistics> retrievePaymentCount() {
		return paymentMonitorService.getPaymentStatusCount();
	}

    @CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value="/decryptParams" ,method = RequestMethod.POST)
	public @ResponseBody FilterData decryptParams(@RequestBody EncodedData params) {
		return paymentMonitorService.getdecryptedParams(params);
	}
	@CrossOrigin(origins="*")
	@RequestMapping(value="/fileDetailCount" ,method = RequestMethod.GET)
	public @ResponseBody List<PaymentStatistics> retrievefileCount() {
		return paymentMonitorService.getfileStatusCount();
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/advFilter", method = RequestMethod.POST)
	public @ResponseBody List<PaymentView> advFileter(@RequestBody Payment obj) throws ParseException {
		List<PaymentView> item = new ArrayList<PaymentView>();
		if (obj != null) {
			logger.info("***advanced Filter Object Data -----");
			System.out.print(obj.toString());
		}
		item = paymentMonitorService.advFilter(obj);
		System.out.println(item);
		return item;
	}

	/*File based filter */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/advFilterFile", method = RequestMethod.POST)
	public @ResponseBody List<PaymentFileView> advFilterFile(@RequestBody Payment obj) throws ParseException {
		List<PaymentFileView> item = new ArrayList<PaymentFileView>();
		if (obj != null) {
			logger.info("***advanced Filter Object Data -----");
			System.out.print(obj.toString());
		}
		item = paymentMonitorService.advFileFilter(obj);
		System.out.println(item);
		return item;
	}
	
	/*File based filter */
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/advFilterFilePage", method = RequestMethod.POST)
	public @ResponseBody List<PaymentFileView> advFilterFilePage(@RequestBody Payment obj) throws ParseException {
		List<PaymentFileView> item = new ArrayList<PaymentFileView>();
		if (obj != null) {
			logger.info("***advanced Filter Object Data -----");
			System.out.print(obj.toString());
		}
		item = paymentMonitorService.advFilterFilePage(obj,obj.getPageNo(),10);
		System.out.println(item);
		return item;
	}
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/pmtDelComment", method = RequestMethod.POST)
	public void pmtDelComment(@RequestBody PaymentView obj)  {
		if (obj != null) {
			logger.info("***payment delete update comment table-----");
			System.out.print(obj.toString());

		}	
		paymentMonitorService.updateDeletePmtComment(obj);
		logger.info("***payment delete update comment table-----");
		System.out.println("Payment Delete Comment Update");
		
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value = "/fileDelComment", method = RequestMethod.POST)
	public void fileDelComment(@RequestBody PaymentFileView obj)  {
		if (obj != null) {
			logger.info("***file delete update comment table-----");
			System.out.print(obj.toString());
		}
		paymentMonitorService.updateDeleteFileComment(obj);
		logger.info("***File delete update comment table-----");
		System.out.println("file Delete comment update");
		
	}

	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/invoiceDtls", method = RequestMethod.POST)
	public @ResponseBody List<InvoiceDtlsView> invoiceDtls(@RequestBody PaymentView obj)  {
		List<InvoiceDtlsView> item = new ArrayList<InvoiceDtlsView>();
		if (obj != null) {
			logger.info("***file delete update comment table-----");
			System.out.print(obj.toString());
		}
		item = paymentMonitorService.invoiceDtls(obj);
		System.out.println("file Delete comment update");
		return item;	
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/filePaymentDtls", method = RequestMethod.POST)
	public @ResponseBody List<PaymentView> filePaymentDtls(@RequestBody PaymentFileView obj)  {
		List<PaymentView> item = new ArrayList<PaymentView>();
		if (obj != null) {
			logger.info("***file delete update comment table-----");
			System.out.print(obj.toString());
		}
		item = paymentMonitorService.filePaymentDtls(obj);
		return item;	
	}
	
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/pmtCommentHistory", method = RequestMethod.POST)
	public @ResponseBody List<HistoryCommentView> pmtCommentHistory(@RequestBody PaymentView obj)  {
		if (obj != null) {
			logger.info("***payment delete update comment table-----");
			System.out.print(obj.toString());

		}	
		List<HistoryCommentView> listComments=new ArrayList<HistoryCommentView>();
		
		listComments=paymentMonitorService.pmtCommentHistory(obj);
		logger.info("***payment delete update comment table-----");
		System.out.println("Payment Delete Comment Update");
		return listComments;	
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value = "/fileCommentHistory", method = RequestMethod.POST)
	public @ResponseBody List<HistoryCommentView> fileCommentHistory(@RequestBody PaymentFileView obj)  {
		if (obj != null) {
			logger.info("***file delete update comment table-----");
			System.out.print(obj.toString());
		}
		List<HistoryCommentView> listComments=new ArrayList<HistoryCommentView>();
		listComments=paymentMonitorService.fileCommentHistory(obj);
		logger.info("***File delete update comment table-----");
		System.out.println("file Delete comment update");
		return listComments;
	}
}
