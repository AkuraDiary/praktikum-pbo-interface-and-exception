package Modul10;

public abstract class PassenggerGood {
    private String name;
    protected int quantity;
    private double price;

    public PassenggerGood(String name, int quantity, double price) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // geter seter name dan price get
    protected String getName() {
        return name;
    }

    protected double getPrice() {
        return price;
    }

    public abstract double calculatePrice();

    public abstract void displayDetail();
}