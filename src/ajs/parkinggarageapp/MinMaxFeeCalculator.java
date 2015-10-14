package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class MinMaxFeeCalculator implements FeeCalculatorStrategy {
    private double fee;
    private double hours;
    
    public MinMaxFeeCalculator(double hours) {
        setHours(hours);
        totalFee();
    }
    
    private void minFee(){
        double minFee = 2.00;
        fee += minFee;
    }
    private void addFee(){
        double maxFee = 10.00;
        for(int i = 3; i < getHours(); i++){
            if(fee < maxFee){
                fee += 0.50;
                //fee will never go over
                if(fee > maxFee){
                    fee = maxFee;
                }
            }else{
                fee = maxFee;
            }
            
        }
    }
    
    private void totalFee(){  
        if(getHours() < 3){
            minFee();
        }else{
            minFee();
            addFee();
        }
    }
    
    @Override
    public final double getTotalFee(){
        
        return fee;
    }
    @Override
    public final void setHours(double hours){
        if(hours > 24 || hours <= 0.0){
            throw new IllegalArgumentException();
        }
        this.hours = hours;
    }

    @Override
    public double getHours() {
        return hours;
    }
    
//     public static void main(String[] args) {
//        FeeCalculatorStrategy minMax = new MinMaxFeeCalculator(8);
//        System.out.println(minMax.getTotalFee());
//    }
    
}
