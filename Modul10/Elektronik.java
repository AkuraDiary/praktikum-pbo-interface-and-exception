package Modul10;

public class Elektronik extends PassenggerGood implements Taxable  {
    private String type;

    public Elektronik(String name, int quantity, double price, String type) {
        super(name, quantity, price);
        this.type = type;
    }
    
    @Override
    public double calculatePrice() {
        return  quantity * getPrice();
    }

    @Override
    public double calculateTax() {
        double harga = calculatePrice();
        if (harga <= 7500000) 
            return 0;
            return (harga * TAX_RATE);
    }

    @Override
    public void displayDetail() {
        double harga = calculatePrice();
        double pajak = calculateTax();
        System.out.println("Nama barang : " + getName() + "dengan tipe" + type + "Berjumlah" + quantity + 
        "Dengan total harga Rp. " + harga + "dengan total pajak" +  pajak);
    }
}