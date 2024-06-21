import managers.*;

public class Main {
    public static void main(String[] args) {
        ProductsManager product = new ProductsManager();

        product.create("Placa de video", 30, 588);
        product.create("Ram", 150, 60);
        product.create("Micro", 28, 200);
        product.create("Gabinete", 59, 99.25);
        product.create("Cooler", 130, 10);
        product.create("Placa madre", 17, 152.5);
        System.out.println(product.readOne(1));
        ClientsManager client = new ClientsManager();
        client.create("Rodrigo", 34680145);
        client.create("Alejandra", 35448811);
        //client.create("German",37893458);
        System.out.println(client.readOne(1));
        CartsManager cart = new CartsManager();
        cart.addToCart(1, product.readOne(1), client.readOne(1));
        cart.addToCart(1, product.readOne(6), client.readOne(1));
        cart.addToCart(1, product.readOne(6), client.readOne(2));
        System.out.println(cart.readByClient(client.readOne(1)));
        System.out.println(cart.readByClient(client.readOne(2)));
    }

}
