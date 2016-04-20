package com.smartblogger.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.smartblogger.model.Blog;
import com.smartblogger.model.User;

public class TestBlog {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAssociation() {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		User user1 = new User();
		user1.setEmailId("utkakuma@cisco.com");
		user1.setName("utkarsh");
		user1.setPassword("kumar");
		
		Blog blog1 = new Blog();
		blog1.setTitle("Java");
		blog1.setTag("object");
		blog1.setContent("Java is a object oriented language.");
		
		Blog blog2 = new Blog();
		blog2.setTitle("Java");
		blog2.setTag("object");
		blog2.setContent("Java is a object oriented language.");
		
		user1.addBlog(blog1);
		user1.addBlog(blog2);

		Transaction transaction=session.beginTransaction();
				
		session.save(user1);
		
		
		transaction.commit();
		session.close();
	}

}
