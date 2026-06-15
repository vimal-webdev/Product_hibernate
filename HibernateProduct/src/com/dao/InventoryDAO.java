package com.dao;

import com.model.Inventory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class InventoryDAO {
    private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    public static Long save(Inventory inv) {
        Session s = factory.openSession();
        Transaction t = s.beginTransaction();
        Long id = (Long) s.save(inv);
        t.commit();
        s.close();
        return id;
    }

    public static Inventory get(Long id) {
        Session s = factory.openSession();
        Inventory inv = s.get(Inventory.class, id);
        s.close();
        return inv;
    }

    public static List<Inventory> listAll() {
        Session s = factory.openSession();
        List<Inventory> list = s.createQuery("from Inventory", Inventory.class).list();
        s.close();
        return list;
    }

    public static void deleteByProductId(long productId) {
        Session s = factory.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("delete from Inventory where productId = :pid");
        q.setParameter("pid", productId);
        q.executeUpdate();
        t.commit();
        s.close();
    }

    public static int updateAmountLessThan(int threshold, int newAmount) {
        Session s = factory.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("update Inventory set productAmount = :newAmt where productAmount < :thr");
        q.setParameter("newAmt", newAmount);
        q.setParameter("thr", threshold);
        int updated = q.executeUpdate();
        t.commit();
        s.close();
        return updated;
    }

    // HQL examples requested
    public static List<Inventory> findByNameStartsWith(char ch) {
        Session s = factory.openSession();
        List<Inventory> list = s.createQuery("from Inventory where productName like :p", Inventory.class)
                .setParameter("p", ch + "%").list();
        s.close();
        return list;
    }

    public static List<Inventory> findAmountBetween(int a, int b) {
        Session s = factory.openSession();
        List<Inventory> list = s.createQuery("from Inventory where productAmount between :a and :b", Inventory.class)
                .setParameter("a", a).setParameter("b", b).list();
        s.close();
        return list;
    }

    public static Object[] findMinMaxProductAmount() {
        Session s = factory.openSession();
        Object[] arr = (Object[]) s.createQuery("select min(productAmount), max(productAmount) from Inventory").uniqueResult();
        s.close();
        return arr;
    }

    public static int updateSameAmountTo(int oldAmount, int newAmount) {
        Session s = factory.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("update Inventory set productAmount = :newA where productAmount = :oldA");
        q.setParameter("newA", newAmount).setParameter("oldA", oldAmount);
        int u = q.executeUpdate();
        t.commit();
        s.close();
        return u;
    }
}
