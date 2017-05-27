package com.example.aop.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping("/test")
	public void test(){
		testService.test();
	}
	
	@RequestMapping("/testAop")
	public void testAop(){
		testService.testAop();
	}
	
	@RequestMapping("/testMethodAop")
	public void testMethodAop(){
		testService.testMethod(1, "aopTest");
	}
}
