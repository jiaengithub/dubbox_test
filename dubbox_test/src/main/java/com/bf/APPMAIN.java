package com.bf;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APPMAIN {
	public static void main(String[] args) throws Exception {
		  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
	        context.start();
	        System.out.println("启动。。。");
	        System.in.read(); // 按任意键退出
	}
}
