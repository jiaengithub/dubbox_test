package com.bf;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyInterceptor {
	 @Pointcut("execution(* com.bf.*.*(..))")  
	 private void anyMethod(){}//定义一个切入点  
	 @AfterThrowing(pointcut="anyMethod()", throwing="ex")  
     public void doAfterThrow(JoinPoint joinPoint, Exception ex) throws Exception{  
        System.out.println("例外通知");  
        //判断异常类型 也可以在异常中传参数 作为最终的抛出
        throw new EntityNotFoundException("dsdsa");
     }  
	 @AfterReturning("anyMethod()")  
	    public void doAfter(){  
	        System.out.println("后置通知");  
	    }  
	      
	    @After("anyMethod()")  
	    public void after(){  
	        System.out.println("最终通知");  
	    }  
	      
}
