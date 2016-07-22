package com.bf;

import javax.ws.rs.PathParam;

public interface HelloRest {

	public String say();
	public User userRegist(User user);
	public User userGet(@PathParam("id") int id) throws Exception;
}
