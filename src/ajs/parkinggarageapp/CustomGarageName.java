package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class CustomGarageName implements GarageNameStrategy {

    private String garageName;

    public CustomGarageName(String garageName) {
        try {
            setName(garageName);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public final String getName() {
        return garageName;
    }

    @Override
    public final void setName(String garageName) throws IllegalArgumentException {
        if (garageName == null || garageName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.garageName = garageName;
    }
}
