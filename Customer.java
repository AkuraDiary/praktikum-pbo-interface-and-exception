public class Customer {
    // “Tamu saat ini - [Nama] CNS [no.tlp] 010-8888-0000”.

    private String name, phone ; 
    
    public Customer(String name, String phone){
        this.name = name ; 
        this.phone = phone ; 
    }

    
    public String toString(){
        return "Tamu saat ini - "+name + " CNS "+phone;
    }
}
