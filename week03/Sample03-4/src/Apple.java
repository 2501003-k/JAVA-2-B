public class Apple {
    private int price;
    private int inventory;

    public Apple(int price, int inventory) {
        this.price = price;
        this.inventory = inventory;
    }

    public int getPrice() {
        return price;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return String.format("상품 : %s, 가격 : %,d원, 개수 : %,d 개",
                "Apple", price, inventory);
    }
}