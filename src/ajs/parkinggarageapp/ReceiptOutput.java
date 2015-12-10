package ajs.parkinggarageapp;

import java.text.NumberFormat;

/**
 *
 * @author ajSchmidt-Zimmel
 */
public class ReceiptOutput implements TerminalOutputStrategy {
    private static final String DASHED = "======================================";    
    private final double fee;
    private final double hours;
    private final int carID;
    private final String garageName;

    public ReceiptOutput(String garageName, int carID, double hours, double fee) throws NullOrEmptyArgumentException {
        if(garageName == null || garageName.isEmpty() || carID <= 0 || hours <= 0 || hours > 24 || fee < 1.50){
            throw new NullOrEmptyArgumentException();
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

    @Override
    public void output(OutputService output) throws NullOrEmptyArgumentException {
        if(output == null){
            throw new NullOrEmptyArgumentException();
        }
        try{
        output.outputData(getReceiptData());
        }catch(NullOrEmptyArgumentException e){
            System.out.println(e);
        }
    }

    
}
