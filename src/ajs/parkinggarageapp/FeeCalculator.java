package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class FeeCalculator {
    private FeeCalculatorStrategy fee;
    
    public FeeCalculator(FeeCalculatorStrategy fee){
        this.fee = fee;
    }
    
    public double getHours(){
        return fee.getHours();
    }
    
    public double getFee(){
        return fee.getTotalFee();
    }
}
