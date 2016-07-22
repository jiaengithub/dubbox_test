package com.bf;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class T {

	@Test
	public void t1() throws ClientProtocolException, IOException{
		User user = new User();
		user.setAge(1);
		user.setName("你好");
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost method = new HttpPost("http://localhost:8888/services/http/user_reg");  
		StringEntity entity = new StringEntity(JSON.toJSONString(user),"utf-8");//解决中文乱码问题    
        entity.setContentEncoding("UTF-8");    
        entity.setContentType("application/json");    
        method.setEntity(entity);    
        HttpResponse result = httpClient.execute(method);
        // 请求结束，返回结果  
        String resData = EntityUtils.toString(result.getEntity());  
        System.out.println(resData);
	}
}
