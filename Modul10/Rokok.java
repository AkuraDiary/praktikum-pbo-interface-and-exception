package Modul10;

public class Rokok extends PassenggerGood implements Taxable{
    private int picesPerPack;

    //constructor
    public Rokok(String nama, int quantity, double price, int picesPerPack) {
        super(nama, quantity, price);
        this.picesPerPack = picesPerPack;
    }

    @Override
    public double calculatePrice(){
        if (picesPerPack <= 12) {
            return quantity * getPrice();
        }else if(picesPerPack <= 24){
            return quantity * getPrice() * 1.5;
        }else{
            return quantity * getPrice() * ((double) picesPerPack / 10);
        }
    }

    @Override
    public double calculateTax() {
        return calculatePrice() * TAX_RATE;
    }

    @Override
    public void displayDetail() {
        double harga = calculatePrice();
        double pajak = calculateTax();
        System.out.println("Nama Rokok : " + getName() + "Berjumlah" + quantity + "Bungkus "+ picesPerPack +
                "per batang, dengan harga Rp. " + harga + "dan pajaknya" + pajak);
    }
}
