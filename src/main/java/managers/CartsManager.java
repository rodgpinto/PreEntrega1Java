package managers;

import jakarta.persistence.*;
import entities.*;

import java.util.List;

public class CartsManager {
    public void addToCart(Integer amount, Product product, Client client) {
        EntityManager manager = null;
        EntityTransaction transaction;
        try {
            manager = Manager.get();
            transaction = manager.getTransaction();
            transaction.begin();
            Cart cart = new Cart();
            cart.setAmount(amount);
            cart.setPrice(product.getPrice());
            cart.setProduct_id(product);
            cart.setClient_id(client);
            manager.persist(cart);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);
        }
    }
    public List<Cart> readByClient(Client client) {
        EntityManager manager = null;
        List<Cart> carts = null;
        try {
            manager = Manager.get();
            carts = manager
                    .createQuery("SELECT id FROM Cart id WHERE id.client_id = :client", Cart.class)
                    .setParameter("client", client)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);
            return carts;
        }
    }
}