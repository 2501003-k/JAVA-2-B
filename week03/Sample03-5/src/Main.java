public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple(1000, 30);
        Seller seller = new Seller(apple, 50000);
        Customer customer = new Customer(30000);
        Store store = new Store(seller, customer);

        store.open();
        store.trade(5);
        store.trade(15);
    }
}