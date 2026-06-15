
package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.model.Product;

public class ProductDAO {

    public static void saveProductWithModels(Product product) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Save the product
        session.save(product);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Product and its models saved successfully!");
    }
}