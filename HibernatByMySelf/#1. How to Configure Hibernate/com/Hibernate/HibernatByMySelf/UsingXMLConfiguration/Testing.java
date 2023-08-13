package com.Hibernate.HibernatByMySelf.UsingXMLConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Testing {

	public static void main(String[] args) {
		//Create hibernate Configuration instance
		Configuration configuration = new Configuration();
		
		// Load the configuration from the XML file
		configuration.configure("com/Hibernate/HibernatByMySelf/UsingXMLConfiguration/hibernate.cfg.xml");
		
		// Build the SessionFactory using the configuration
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		// Open a new Hibernate session
		Session session = sessionFactory.openSession();
		
		// Begin a transaction
		Transaction transaction = session.beginTransaction();
		
		try {
            // Perform database operations here
            // ...
            
            // Commit the transaction
			System.out.println(transaction);
            transaction.commit();
            System.out.println("Transaction is active : "+transaction.isActive());
            System.out.println("SessionFactory is closed : "+sessionFactory.isClosed());
            System.out.println("Session is Connected : "+session.isConnected());
        } catch (Exception e) {
            // Handle exceptions and rollback the transaction if needed
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the session and the SessionFactory
            session.close();
            System.out.println("Session is Connected : "+session.isConnected());
            sessionFactory.close();
            System.out.println("SessionFactory is closed : "+sessionFactory.isClosed());
            System.out.println("Transaction is active : "+transaction.isActive());
        }

	}

}
