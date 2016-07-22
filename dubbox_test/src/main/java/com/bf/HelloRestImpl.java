package com.bf;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

/**
 * 通过继承EntityNotFoundMapper  抛出范型异常 可以实现自定义
 * @author DF
 *
 */
@Path("http")
@Service
public class HelloRestImpl extends EntityNotFoundMapper implements HelloRest {
	@GET
	@Path("say")
	@Consumes({MediaType.APPLICATION_JSON})
	@Override
	public String say() {
		return "hello world!!";
	}
	@POST
	@Path("user_reg")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Override
	public User userRegist(User user) {
		System.out.println("name:" + user.getName() + "  age:" + user.getAge());
		return user;
	}
	@POST
	@Path("{id : \\d+}") 	//@Path("/test/{id : \\d+}/{name}") 也行
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Override//MediaType.MULTIPART_FORM_DATA @FormDataParam form参数
	public User userGet(@PathParam("id") int id) throws Exception {
		User user = new User();
		user.setAge(id);
		if (id == 1){
			throw new Exception("xxxx");
		}
		System.out.println("name:" + user.getName() + "  age:" + user.getAge());
		return user;
	}
	
}
