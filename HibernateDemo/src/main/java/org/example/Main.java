package org.example;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
        System.out.println("Hello world!");
        Alian alian = new Alian();
        alian.setAid(101);
        alian.setAname("Raju");
        alian.setColor("Blue");

        Configuration con = new Configuration().configure().addAnnotatedClass(Alian.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = (Transaction) session.beginTransaction();
        session.save(alian);
        tx.commit();

    }
}