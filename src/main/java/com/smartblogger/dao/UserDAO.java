package com.smartblogger.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.smartblogger.model.User;
import com.smartblogger.service.HibernateUtil;

public class UserDAO {
	public User getUser(Integer id) {
		Session ses = HibernateUtil.currentSession();
		try {
			Criteria crit =  ses.createCriteria(User.class);
			crit.add(Restrictions.idEq(id));
			User u = (User)crit.uniqueResult();
			return u;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	public List<User> getUsers() {
		Session ses = HibernateUtil.currentSession();
		try {
			return ses.createCriteria(User.class).list();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	public void createUser(User u){
		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			ses.save(u);
			tx.commit();
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	public void updateUser(User u){

		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			ses.update(u);
			tx.commit();
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	
	public boolean deleteUser(int id) {

		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			User u = (User) ses.load(User.class, id);
			ses.delete(u);
			tx.commit();
			return true;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
}
