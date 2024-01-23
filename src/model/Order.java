package model;

public class Order {

    private String customerName;
    private Fruit fruit;
    private int quantity;

    public Order(String customerName, Fruit fruit, int quantity) {
        this.customerName = customerName;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}