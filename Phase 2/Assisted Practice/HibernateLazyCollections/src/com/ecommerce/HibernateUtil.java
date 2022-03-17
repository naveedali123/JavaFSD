package com.ecommerce;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	static SessionFactory sessionFactory;

	public static SessionFactory buildSessionFactory() {

		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(EProduct.class);
			cfg.addAnnotatedClass(Color.class);
			cfg.addAnnotatedClass(Finance.class);
			cfg.addAnnotatedClass(OS.class);
			cfg.addAnnotatedClass(ScreenSizes.class);

			sessionFactory = cfg.buildSessionFactory();
		}
		return sessionFactory;
	}
}