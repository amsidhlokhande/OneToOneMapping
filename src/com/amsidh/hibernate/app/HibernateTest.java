package com.amsidh.hibernate.app;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.amsidh.hibernate.domains.Address;
import com.amsidh.hibernate.domains.UserDetails;

public class HibernateTest {

	
	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUserName("Second User");
		
		Address homeAddress=new Address();
		homeAddress.setCity("Pune");
		homeAddress.setPincode(1235);
		homeAddress.setState("MH");
		homeAddress.setStreet("Kate Puram");
		
		Address officeAddress=new Address();
		officeAddress.setCity("Pune");
		officeAddress.setPincode(1235);
		officeAddress.setState("MH");
		officeAddress.setStreet("Kate Puram");
		
		Address permanentAddress=new Address();
		permanentAddress.setCity("Pune");
		permanentAddress.setPincode(1235);
		permanentAddress.setState("MH");
		permanentAddress.setStreet("Kate Puram");
		
		Set<Address> listOfAddresses=new HashSet<Address>();
		listOfAddresses.add(homeAddress);
		listOfAddresses.add(officeAddress);
		listOfAddresses.add(permanentAddress);
		user.setListOfAddresses(listOfAddresses);
		
		user.setDateOfBirth(new Date());
		user.setDescription("Description goes here for the user");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		//=====================================
		/*
		session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails userDetails=(UserDetails)session.get(UserDetails.class, 1);
		System.out.println(userDetails.getAddress());
		System.out.println(userDetails.getDescription());
		System.out.println(userDetails.getUserName());
		System.out.println(userDetails.getDateOfBirth());
		System.out.println(userDetails.getUserId());
		System.out.println(userDetails.getNotPersist1());
		System.out.println(userDetails.getNotPersist2());
		
		*/
		
	}

}
