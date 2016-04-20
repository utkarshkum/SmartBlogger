package com.smartblogger.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.smartblogger.dao.UserDAO;
import com.smartblogger.model.User;

@Path("/user")
public class UserService {

	UserDAO userData = new UserDAO();
	
	private static UserService singeton = new UserService();
		
	private UserService() {
		
	}
	
	public static UserService getInstance() {
		return singeton;
	}
	
	public UserDAO getUserData() {
		return userData;
	}

	public void setUserData(UserDAO userData) {
		this.userData = userData;
	}

	@GET
	@Path("/{param}")
	@Produces({MediaType.APPLICATION_JSON})
	public User getUser(@PathParam("param") Integer id) {
		UserDAO userData = new UserDAO();
		return userData.getUser(id);
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> getUsers() {
		UserDAO userData = new UserDAO();
		return userData.getUsers();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(User u){
		UserDAO userData = new UserDAO();
		userData.createUser(u);
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(User u){
		UserDAO userData = new UserDAO();
		userData.updateUser(u);
	}
	
	@DELETE
	@Path("/{param}")
	@Produces({MediaType.APPLICATION_JSON})
	public boolean deleteUser(@PathParam("param") Integer id) {
		UserDAO userData = new UserDAO();
		return userData.deleteUser(id);
	}
	
}


