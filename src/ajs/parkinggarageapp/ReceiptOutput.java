package ajs.parkinggarageapp;

import java.text.NumberFormat;

/**
 * Class puts together the data to be output. 
 * 
 * @author ajSchmidt-Zimmel
 * @version 1.2
 */
public class ReceiptOutput implements TerminalOutputStrategy {
    private static final String DASHED = "======================================";    
    private final double fee;
    private final double hours;
    private final int carID;
    private final String garageName;

    /**
     * Constructor for Receipt output.
     * garageName and car ID cannot be null. CarID cannot be less than or equal to 0, 
     * hours cannot be less than or equal to 0 or greater than 24. Fee must be greater than 1.50.
     * @param garageName Name of the garage.
     * @param carID id of the car.
     * @param hours Hours the car was parked.
     * @param fee Fee the car has been charged.
     * @throws NullOrEmptyArgumentException Custom exception class.
     * @throws ajs.parkinggarageapp.NumberOutOfRangeException
     */
    public ReceiptOutput(String garageName, int carID, double hours, double fee) throws NullOrEmptyArgumentException, NumberOutOfRangeException {
        
        if(garageName == null || garageName.isEmpty()){
            throw new NullOrEmptyArgumentException("garage name is null or empty in ReceiptOutput constructor.");
        }else if ( carID <= 0){
            throw new NumberOutOfRangeException("carID is less than or equal to 0 in ReceiptOutput constructor.");
        }else if(hours <= 0){
            throw new NumberOutOfRangeException("hours is less than or equal to 0 in ReceiptOutput constructor");
        }else if (fee < 1.50){
            throw new NumberOutOfRangeException("fee is less than 1.50 in ReceiptOutput constructor.");
        }
        this.garageName = garageName;
        this.carID = carID;
        this.hours = hours;
        this.fee = fee;
    }
    
    private String getReceiptData(){
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        NumberFormat h = NumberFormat.getNumberInstance();
        final String newLine = "\n";
        StringBuilder receiptData = new StringBuilder();
        receiptData.append(DASHED).append(newLine);
        receiptData.append("Receipt").append(newLine);
        receiptData.append(garageName).append(newLine);
        receiptData.append("Car ID: ").append(carID).append(newLine);
        receiptData.append("Total Hours Billed: ").append(h.format(hours)).append(newLine);
        receiptData.append("Total Fee: ").append(curr.format(fee)).append(newLine);
        receiptData.append(DASHED).append(newLine);
        String data = receiptData.toString();
        return data;
    }

    /**
     * Outputs data to properly assigned output location.
     * 
     * @param output output service strategy being used.
     * @throws NullOrEmptyArgumentException Custom exception class.
     */
    @Override
    public final void output(OutputService output) throws NullOrEmptyArgumentException {
        if(output == null){
            throw new NullOrEmptyArgumentException("output is null in output method in ReceiptOutput");
        }
        try{
        output.outputData(getReceiptData());
        }catch(NullOrEmptyArgumentException e){
            //never ending try catch
            System.out.println(e + " could not output ddata in output in ReceiptOutput.");
        }
    }

    
}
