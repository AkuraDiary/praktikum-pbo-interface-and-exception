package Modul10;

public class Main {
    public static void main(String[] args) {
        //panggil object nya semua
        Elektronik smartphone = new Elektronik("smartphone", 2, 20000, "Iphone 14");
        Makanan snack = new Makanan("Mie ayam", 5, 10000, 350.0);
        Rokok samsu = new Rokok("Dji sam soe", 5, 14000, 16);

        //buat print 
        smartphone.displayDetail();
        snack.displayDetail();
        samsu.displayDetail();
    }
}
