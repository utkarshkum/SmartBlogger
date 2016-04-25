package com.smartblogger.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


public class User {
	
	private Integer userId;
	private String name;
	private String emailId;
	private String password;
	
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="blogId")
	private Set<Blog> blogs;
	
	public Set<Blog> getBlogs() {
		return blogs;
	}
	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addBlog(Blog blog){
		if(blogs==null){
			blogs= new HashSet<Blog>();
		}
		blog.setUser(this);

		blogs.add(blog);
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", emailId="
				+ emailId + ", password=" + password + ", blogs=" + blogs + "]";
	}
	
}
