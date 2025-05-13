import java.util.*;
// import Exception.*;
public class PensionBiz implements IPensionBiz {
    ArrayList<HashMap<String, Object>> rooms ; 
    
    public PensionBiz(){
        rooms = new ArrayList();
    }

    public void initializeRoomData(){
        rooms.clear();
        rooms.add(createRoomMap("101", new Standard()));
        rooms.add(createRoomMap("102", new Standard())); 
        rooms.add(createRoomMap("103", new Standard())); 

        rooms.add(createRoomMap("104", new Suite())); 
        rooms.add(createRoomMap("105", new Suite()));
    }

    private HashMap<String, Object> createRoomMap(String id, RoomType room){
        HashMap<String, Object> map = new HashMap<>();
        map.put("Room", id); 
        map.put("Type", room);
        return map;
    }


    private HashMap<String, Object> findRoomMap(String roomId){
        for (HashMap<String,Object> hashMap : rooms) {
            if (hashMap.get("Room").equals(roomId)) {
                return hashMap;
            }
        }
        return null;
    }

    public void checkIn(String roomId, String custName, String custPhone) throws Exception{
        int id ; 
        try {
            id = Integer.parseInt(roomId) ;
        } catch (NumberFormatException e) {
            // TODO: handle exception
            throw new Exception("Silahkan masukkan angka untuk nomor kamar.");
        }
        HashMap<String, Object> target = findRoomMap(roomId); 
        if (target==null) {
            throw new Exception("Silahkan Masukkan nomor kamar yang benar"); 
        }
        if (target.containsKey("Guest")) {
            throw new AlreadyReservedException();
        }
        Customer cust = new Customer(custName, custPhone); 
        target.put("Guest", cust );
        System.out.println("Berhasil dipesan");
        
    }

    public void checkOut(String roomId) throws Exception{
        int id ;
        try {
            id = Integer.parseInt(roomId);
        } catch (Exception e) {
            // TODO: handle exception
            throw new Exception("Silahkan masukkan angka untuk nomor kamar.");
        }
        HashMap<String, Object> target = findRoomMap(roomId); 
        if (target==null) {
            throw new Exception("Silahkan Masukkan nomor kamar yang benar"); 
        }
         if (!target.containsKey("Guest")) {
            throw new AlreadyCheckoutException();
        }
        Customer cust  = (Customer) target.remove("Guest");
        System.out.println("Check Out Berhasil");
    }

    public void roomList(){
        for (HashMap<String,Object> hashMap : rooms) {
            String id = (String) hashMap.get("Room");
            RoomType type = (RoomType) hashMap.get("Type");
            
            StringBuilder sb = new StringBuilder(); 
            sb.append("Kamar ").append(id).append(" : ");
            sb.append(type.toString()); 
            if (hashMap.containsKey("Guest")) {
                sb.append(" ").append(hashMap.get("Guest").toString());
            }
            System.out.println(sb.toString());
        }
    }
}
