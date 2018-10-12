package utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class SessionProvider {
	static Session session=null;
	public static Session getSession(){
			Configuration configuration=new AnnotationConfiguration();
			SessionFactory sessionFactory=configuration.configure().buildSessionFactory();
			session=sessionFactory.openSession();
		return session;
	}
}
