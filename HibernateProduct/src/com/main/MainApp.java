package com.main;

import com.dao.InventoryDAO;
import com.dao.ProductDAO;
import com.model.Inventory;
import com.model.Product;
import com.model.ProductModel;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Starting Hibernate Inventory Demo (check hibernate.cfg.xml for DB settings)");
        // 1. Persisting Inventory items
        Inventory i1 = new Inventory("mouse", 50, "electronics", "M-100");
        Inventory i2 = new Inventory("monitor", 120, "electronics", "MD-200");
        Inventory i3 = new Inventory("oven", 30, "kitchen", "K-10");
        Long id1 = InventoryDAO.save(i1);
        Long id2 = InventoryDAO.save(i2);
        Long id3 = InventoryDAO.save(i3);
        System.out.println("Saved inventories: " + id1 + "," + id2 + "," + id3);

        // 2. Retrieve all
        List<Inventory> all = InventoryDAO.listAll();
        all.forEach(System.out::println);

        // 3. Delete where productId = 30 
        InventoryDAO.deleteByProductId(30L);
        System.out.println("Deleted productId = 30 if existed.");

        // 4. Update where productAmount < 100 => set to 150
        int updated = InventoryDAO.updateAmountLessThan(100, 150);
        System.out.println("Updated rows where amount < 100: " + updated);

        // HQL queries examples
        System.out.println("Names starting with 'm':");
        InventoryDAO.findByNameStartsWith('m').forEach(System.out::println);

        System.out.println("Amount between 200 and 500:");
        InventoryDAO.findAmountBetween(200,500).forEach(System.out::println);

        Object[] mm = InventoryDAO.findMinMaxProductAmount();
        System.out.println("Min amount=" + mm[0] + ", Max amount=" + mm[1]);

        // Update same amount -> 750
        int u2 = InventoryDAO.updateSameAmountTo(150, 750);
        System.out.println("Updated same-amount rows to 750: " + u2);

        // Many-to-Many example
        Product p = new Product("Phone_Galaxy");
        ProductModel pm1 = new ProductModel("S-24");
        ProductModel pm2 = new ProductModel("S-25");
        p.addModel(pm1);
        p.addModel(pm2);
        ProductDAO.saveProductWithModels(p);
        System.out.println("Saved product with models: " + p);

        System.out.println("Done.");
        System.exit(0);
    }
}
