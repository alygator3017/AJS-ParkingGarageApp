package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public interface GarageNameStrategy {
    public abstract String getName();
    public abstract void setName(String garageName) throws IllegalArgumentException;
}
