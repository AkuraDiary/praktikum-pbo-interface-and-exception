public class RoomType {

    private int price, roomSize ; 

    public RoomType(int price, int roomSize){
        this.price = price ; 
        this.roomSize = roomSize ; 
    }

    public String toString(){
        return "("+roomSize+"m2/"+price+"won)";
    }

    
    // h: “(14m2/80000won)”
}
