package managers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import entities.*;


public class ProductsManager {
    public void create(String name, Integer stock, double price) {
        EntityManager manager = null;
        EntityTransaction transaction;
        try {
            manager = Manager.get();
            transaction = manager.getTransaction();
            transaction.begin();
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setStock(stock);
            manager.persist(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);
        }
    }
    public Product readOne(Integer id) {
        EntityManager manager = null;
        Product product = null;
        try {
            manager = Manager.get();
            product = manager.find(Product.class, id);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);
            return product;
        }
    }

}