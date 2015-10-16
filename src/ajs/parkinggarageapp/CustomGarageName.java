
package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class CustomGarageName implements GarageNameStrategy
{
    private String garageName;

    public CustomGarageName(String garageName) {
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
//        GarageNameStrategy name = new CustomGarageName("herbie's parking");
//        System.out.println(name.getName());
//    }
}
