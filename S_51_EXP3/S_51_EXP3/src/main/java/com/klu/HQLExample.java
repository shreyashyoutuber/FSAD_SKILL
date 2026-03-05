package com.klu;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class HQLExample {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(new Product("Laptop","Electronics",50000,10));
        session.persist(new Product("Phone","Electronics",20000,15));

        tx.commit();

        Query<Product> q =
        session.createQuery("from Product", Product.class);

        List<Product> list = q.list();

        for(Product p : list)
            System.out.println(p.getName());

        session.close();
        factory.close();
    }
}