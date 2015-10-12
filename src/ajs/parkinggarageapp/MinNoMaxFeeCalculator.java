package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class MinNoMaxFeeCalculator implements FeeCalculatorStrategy{

    private double fee;
    private double hours;
    
    public MinNoMaxFeeCalculator(double hours) {
        setHours(hours);
        
    }
    
    private double minFee(){
        double minFee = 1.50;
        return fee += minFee;
    }
    
    private double addFee(double hours){
        for(int i = 2; i < hours; i++){
            fee += 0.75;            
        }
        return fee;
    }
    
    @Override
    public final void setHours(double hours) {
        if(hours > 24 || hours <= 0.0){
            throw new IllegalArgumentException();
        }
        this.hours = hours;
    }
    
    @Override
    public final double getHours() {
        return hours;
    }

    @Override
    public final double totalFee() {
        if(getHours() < 2){
            minFee();
        }else{
            minFee();
            addFee(getHours());
        }
        return fee;
    }

    
    
}
