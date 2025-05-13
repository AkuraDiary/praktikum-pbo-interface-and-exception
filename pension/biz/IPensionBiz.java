public interface IPensionBiz {
    void initializeRoomData();
    void checkIn(String roomId, String custName, String custPhone) throws Exception;
    void checkOut(String roomdId)throws Exception; 
    void roomList(); 
}
