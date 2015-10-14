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
        totalFee();
    }
    
    private void minFee(){
        double minFee = 1.50;
        fee += minFee;
    }
    
    private void addFee(double hours){
        for(int i = 2; i < hours; i++){
            fee += 0.75;            
        }
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

    private void totalFee(){
        if(getHours() < 2){
            minFee();
        }else{
            minFee();
            addFee(getHours());
        }        
    }
    @Override
    public final double getTotalFee() {
        
        return fee;
    }

    
//    public static void main(String[] args) {
//        FeeCalculatorStrategy minNoMax = new MinNoMaxFeeCalculator(8);
//        System.out.println(minNoMax.getTotalFee());
//    }
}
