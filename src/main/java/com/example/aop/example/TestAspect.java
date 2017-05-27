package com.example.aop.example;
 
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	private static final Logger logger = LoggerFactory.getLogger(TestService.class);
	
	@Before("execution(* com.example.aop.example.*.*Aop(..))")
	public void onBeforeHendler(JoinPoint joinPoint){
		logger.info("=======================onBefore");
	}
	
	@After("execution(* com.example.aop.example.*.*Aop(..))")
	public void onAfterHendler(JoinPoint joinPoint){
		logger.info("=======================onAfter");
	}
	
	@AfterReturning(pointcut = "execution(* com.example.aop.example.*.*Aop(..))",
					returning = "str")
	public void onAfterReturningHendler(JoinPoint joinPoint, Object str){
		logger.info("@AfterReturning : "+ str);
		logger.info("=======================onAfterReturning");
	}
	
	@Pointcut("execution(* com.example.aop.example.*.*Aop(..))")
	public void onPointcutHendler(JoinPoint joinPoint){
		logger.info("=======================onPointcut");
	}
	
	
	@AfterReturning(pointcut = "execution(* com.example.aop.example.*.*Method(..))")
	public void onAfterReturningMethodNameHendler(JoinPoint joinPoint){
		String result = "";

		result += "\n*****\n";
		result += joinPoint.getTarget().getClass().getName()+"."
				+joinPoint.getSignature().getName() +"(";

		int index = joinPoint.getArgs().length;
		for( Object o : joinPoint.getArgs() ){

			result += o;
			if( --index != 0 ){
				result += ", ";
			}

		}
		result += ")\n";

		result += "Completed:"+ joinPoint+"\n";
		result += "*****\n";

		logger.info(result);
	}
}
