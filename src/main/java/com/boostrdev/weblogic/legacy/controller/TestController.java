package com.boostrdev.weblogic.legacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boostrdev.weblogic.legacy.dao.PaymentMonitorDao;
import com.boostrdev.weblogic.legacy.model.PaymentStatistics;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	PaymentMonitorDao paymentMonitorDao;
	@RequestMapping(method = RequestMethod.GET)
	   public @ResponseBody User printHello(ModelMap model) {
		 User user = new User();

	      user.setName("oom");
	      user.setId(1);
	      return user;
	   }
	
	/*
	 * @Override
	public List<PaymentStatistics> getPaymentStatusCount() {
		return paymentMonitorDao.getPaymentStatusCount();
	}
	 */
	
	@RequestMapping(value="/paymentDetailCount" ,method = RequestMethod.GET)
	public @ResponseBody List<PaymentStatistics> retrievePaymentCount() {
		System.out.println("Run successfully");
		return paymentMonitorDao.getPaymentStatusCount();
	}
}
