package com.zq.www.common;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

 
//使用Hibernate管理Session
public class HibernateSessionFactory {

  
    private static String configFile = "/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private  static AnnotationConfiguration  configuration = new  AnnotationConfiguration ();    
    private static SessionFactory sessionFactory;
    

	static {
    	try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err
					.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
    }
 
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			 
			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			
			threadLocal.set(session);
		}

        return session;
    }
 
 
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }
	 
   
}