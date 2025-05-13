import java.util.Scanner;
// import biz.PensionBiz;
// import biz.AlreadyReservedException;
// import biz.AlreadyCheckoutException;

public class PensionTest {
    public void printHeader(){
        System.out.println("======<< Management System Pansion Chun >>======");
        System.out.println("1. Periksa seluruh ruangan");
        System.out.println("2. check in");
        System.out.println("3. check out");
        System.out.println("0. Selesai");
        System.out.println("=============================");
    }
    public static void main(String[] args) {
        PensionTest app = new PensionTest();
        Scanner inp = new Scanner(System.in);
        PensionBiz pb = new PensionBiz();

        pb.initializeRoomData();

        String pilihan ;
        do {
            app.printHeader();
            System.out.print("Input Menu >> ");
            pilihan = inp.nextLine().trim();

            switch (pilihan) {
                case "1":
                        pb.roomList();
                    break;
                case "2":
                        System.out.print("Masukkan nomor kamar anda>> ");
                        String roomIn = inp.nextLine().trim();
                        System.out.print("Silahkan input nama anda>> ");
                        String name = inp.nextLine().trim();
                        System.out.print("Silahkan input no.tlp anda>> ");
                        String phone = inp.nextLine().trim();

                        try {
                            pb.checkIn(roomIn, name, phone);
                        } catch (AlreadyReservedException e) {
                            // TODO: handle exception
                            System.err.println("[Eror] sudah dipesan");
                        }catch (Exception e) {
                            // TODO: handle exception
                            System.err.println("Error "+e.getMessage());
                        }
                    break;
                case "3":
                    System.out.println("Masukkan nomor kamar anda>> ");
                    String roomOut = inp.nextLine().trim();

                    try {
                        pb.checkOut(roomOut);
                    } catch (AlreadyCheckoutException e) {
                        System.err.println("[error] checkout sudah dilakukan");
                    } catch (Exception e) {
                        System.err.println("Error "+e.getMessage());
                    }
                    break;
                case "0":
                    System.out.println("bye bye");
                    break;
            
                default:
                    System.err.println("[Error] Silahkan input menu kembali");
            }
        } while (!pilihan.equals("0"));

    }
}
