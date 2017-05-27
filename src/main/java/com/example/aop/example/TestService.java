package com.example.aop.example;

   
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	private static final Logger logger = LoggerFactory.getLogger(TestService.class);
	
	public String test(){
		String msg = "no aop";
		logger.info(msg);
		return msg;
	}
	
	public String testAop(){
		String msg = "aop!!!!!!!!!!!!!!";
		logger.info(msg);
		return msg;
	}
	
	public String testMethod(int num, String str){ 
		logger.info(num + str);
		return num + str;
	}
		
}
