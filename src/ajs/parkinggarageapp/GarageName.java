package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class GarageName {
    private final GarageNameStrategy name;
    
    public GarageName(String name) {
        this.name = new CustomGarageName(name);
    }
    public final String getName(){
        return name.getName();
    }
}
