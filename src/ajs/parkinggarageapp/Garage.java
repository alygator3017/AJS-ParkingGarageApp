package ajs.parkinggarageapp;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public class Garage {
    private final String name;
    private final String phone;
    private final String address;
    
    public Garage(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public final String getName(){
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
    
}
