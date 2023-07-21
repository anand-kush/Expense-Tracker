package com.db;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.entities.Expense;
import com.entities.UserData;

public class HibernateUtil {
	private static SessionFactory sessionfactory;
	
	public static SessionFactory getSessionFactory(){
		if(sessionfactory==null) {
			Configuration configuration=new Configuration();
			
			
			Properties properties=new Properties();
			
			properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			properties.put(Environment.URL, "jdbc:mysql://localhost:3306/expenses");
			properties.put(Environment.USER, "root");
			properties.put(Environment.PASS, "root");
			properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			properties.put(Environment.HBM2DDL_AUTO, "update");
			properties.put(Environment.SHOW_SQL, true);
			
			
			configuration.setProperties(properties);
			configuration.addAnnotatedClass(UserData.class);
			configuration.addAnnotatedClass(Expense.class);
			
			ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			sessionfactory=configuration.buildSessionFactory(serviceRegistry);
			
		}
		return sessionfactory;
		
	}

}
