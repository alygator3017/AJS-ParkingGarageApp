
package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class GarageName implements GarageNameStrategy
{
    private String garageName;

    public GarageName(String garageName) {
        setName(garageName);
    }
    

    @Override
    public final String getName() {
        return garageName;
    }

    @Override
    public final void setName(String garageName) {        
        this.garageName = garageName;
    }
    
//    public static void main(String[] args) {
//        GarageNameStrategy name = new GarageName("herbie's parking");
//        System.out.println(name.getName());
//    }
}
