package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class MinNoMaxFeeCalculator implements FeeCalculatorStrategy {

    private double fee;
    private double hours;

    public MinNoMaxFeeCalculator(double hours) {
        try {
            setHours(hours);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        //wouldn't allow anything without a try catch
        try{
        totalFee();
        }catch (IllegalArgumentException e ){
            System.out.println(e);
        }
    }

    private void minFee() {
        double minFee = 1.50;
        fee += minFee;
    }

    private void addFee(double hours) throws IllegalArgumentException {
        if (hours <= 0 || hours > 24) {
            throw new IllegalArgumentException();
        }
        for (int i = 2; i < hours; i++) {
            fee += 0.75;
        }
    }

    @Override
    public final void setHours(double hours) throws IllegalArgumentException {
        if (hours > 24 || hours <= 0.0) {
            throw new IllegalArgumentException();
        }
        this.hours = hours;
    }

    @Override
    public final double getHours() {
        return hours;
    }

    private void totalFee() throws IllegalArgumentException {
        if (getHours() < 2) {
            minFee();
        } else {
            minFee();
            try {
                addFee(getHours());
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public final double getTotalFee() {

        return fee;
    }
}
