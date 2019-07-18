package com.rossdomofon.supporter.factory;

import org.hibernate.SessionFactory;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    public HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            /*try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(parser.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySetting(configuration.getProperty("1"));
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }*/
        }
        return null;
    }
}
