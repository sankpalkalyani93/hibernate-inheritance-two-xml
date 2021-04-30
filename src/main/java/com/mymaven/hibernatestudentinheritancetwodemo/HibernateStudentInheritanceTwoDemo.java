package com.mymaven.hibernatestudentinheritancetwodemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateStudentInheritanceTwoDemo {
   public static void main(String [] args){
       StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
       Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
       
       SessionFactory s = meta.getSessionFactoryBuilder().build();
       Session session = s.openSession();
       Transaction t = session.beginTransaction();
       
       Student s1 = new Student();
       s1.setName("Bhushan J");
       s1.setCourse("Gymnasium");
       s1.setDept("Training");
       s1.setPercent(67);
       
       UG_Student ug = new UG_Student();
       ug.setName("Sham S");
       ug.setDept("MBA");
       ug.setDuration(4);
       
       PG_Student pg = new PG_Student();
       pg.setName("Prasad c");
       pg.setCourse("Business MGT");
       pg.setNoOfYears(3);
   
       session.persist(s1);
       session.persist(ug);
       session.persist(pg);
       
       t.commit();
       session.close();
       System.out.println("Data saved successfully");
   } 
}
