package com.ecommerce.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class hibernateUtil {

	private static SessionFactory factory;
	
	public static SessionFactory buildSessionFactory() {
		StandardServiceRegistry service=new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(service).getMetadataBuilder().build();
		//build session factory object
		factory= meta.getSessionFactoryBuilder().build();
		return factory;
	}
}
