package com.whiskeyworldwide;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.whiskeyworldwide.model.User;

public class DBTest {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try {
			//create a student obj
			System.out.println("Creating new student object...");
			//User tempUser = new User (0, "Paul", "Wall", "paul@luv2code.com","a233", "a233", "user");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student obj
			System.out.println("Saving the student...");
			//session.save(tempUser);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally{
			factory.close();
		}
	}

}