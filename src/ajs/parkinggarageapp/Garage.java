package ajs.parkinggarageapp;

/**
 * Garage class is designated for storing information of the parking garage.
 * no strings can be null. 
 * @author ajSchmidt-Zimmel
 */
public class Garage {
    private final String name;
    private final String phone;
    private final String address;
    
    /**
     * Constructor for the Garage class. 
     * Takes in the name, address and phone number of the garage and assigns them to 
     * variables to be retrieved from get methods. None of the parameters may be null or empty.
     * @param name The Name of the garage.
     * @param address The address of the garage.
     * @param phone The phone number of the garage.
     * @throws NullOrEmptyArgumentException custom exception class.
     */
    public Garage(String name, String address, String phone) throws NullOrEmptyArgumentException {
        if(name == null || name.isEmpty() || address == null || address.isEmpty() ||
                phone == null || phone.isEmpty()){
            throw new NullOrEmptyArgumentException("name, address or phone is null or empty for the Garage constructor");
        }
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Retrieves the garage name.
     * @return Returns the name of the garage.
     */
    public final String getName(){
        return name;
    }

    /**
     * Retrieves the phone number of the garage.
     * @return Returns the phone number of the garage.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Retrieves the address of the garage.
     * @return Returns the address of the garage.
     */
    public String getAddress() {
        return address;
    }
    
}
