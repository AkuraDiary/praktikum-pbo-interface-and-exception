package Modul10;

public class Makanan extends PassenggerGood{
    private double weight;

    //constructor
    public Makanan(String name, int quantity, double price, double weight) {
        super(name, quantity, price);
        this.weight = weight;
    }

    @Override
    public double calculatePrice() {
        return quantity * getPrice() * weight;
    }

    @Override
    public void displayDetail() {
        double harga = calculatePrice();
        System.out.println("Nama makanan : " + getName() + "berat makanan" + weight + "gram Berjumlah" + quantity +
                " total harga Rp. " + harga );
    }
}
