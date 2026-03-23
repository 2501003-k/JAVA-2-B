public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple(1000, 30);
        Seller seller = new Seller(apple, 50000);
        Customer customer = new Customer(30000);

        System.out.println(seller);
        System.out.println(customer);

        customer.buy(seller, apple, 5);

    }
}