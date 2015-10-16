package ajs.parkinggarageapp;

/**
 *
 * @author Alyson
 */
public class FeeCalculator {
    private FeeCalculatorStrategy fee;
    private final String pickCalc;
    private double hours;
    
    public FeeCalculator(String calc, double hours){
        this.pickCalc = calc.toLowerCase();
        if(pickCalc.equals("min no max")){
            this.fee = new MinNoMaxFeeCalculator(hours);
        }else if(pickCalc.equals("min max")){
            this.fee = new MinMaxFeeCalculator(hours);
        }else{
            //put in validation for throw here.....
            Output output = new Output(new JOptionPaneOutput());
            output.getOutput().outputData("Invalid fee calculator Entries for FeeCalculator constructor");
        }
        
    }
    
    public double getHours(){
        return fee.getHours();
    }
    
    public double getFee(){
        return fee.getTotalFee();
    }
}
