package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.UserData;

public class UserDao {
	private SessionFactory factory=null;
	private Session session=null;
	private Transaction tx=null;
	
	
	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public boolean saveuser(UserData user) {
		
		boolean f=false;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			session.save(user);
			tx.commit();
			f=true;
			
			
		} catch (Exception e) {
			if(tx!=null) {
				f=false;
				e.printStackTrace();
			}
		}
		
		return f;
	}
	
	
	public UserData login(String email, String password ) {
		UserData u=null;
		
		session=factory.openSession();
		
		Query q=session.createQuery("from UserData where email=:em and password=:ps");
		
		q.setParameter("em", email);
		q.setParameter("ps", password);
		u=(UserData)q.uniqueResult();
		
		return u;
		
	}
	

}
