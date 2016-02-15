package com.associations.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.associations.models.UserDetails;
import com.associations.models.Vehicle;
import com.associations.utils.HibernateUtil;

public class SqlAssociationMain {

	public static void main(String[] args) {
		
		List<Vehicle>vehicles=new ArrayList<>();
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		UserDetails spock=new UserDetails();
		spock.setName("Spock");
		UserDetails kirk=new UserDetails();
		kirk.setName("kirk");
		Vehicle vehicle1=new Vehicle();
		vehicle1.setVehicleName("Enterprise");
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleName("kelvin");
		vehicles.add(vehicle1);
		vehicles.add(vehicle2);
		kirk.setVehicles(vehicles);
		vehicle1.setUser(kirk);
		vehicle2.setUser(kirk);
		session.save(vehicle2);
		session.save(vehicle1);
		session.save(spock);
		session.save(kirk);
		session.getTransaction().commit();
		session.close();
		
	}

}
