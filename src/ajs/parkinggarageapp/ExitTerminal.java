package ajs.parkinggarageapp;

import fileserviceapp.FileService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import utilities.DateUtilities;

//MOVE FILE SERVICE METHOD TO SALES REPORT CLASS

/**
 *
 * @author ajSchmidt-Zimmel
 */
public class ExitTerminal implements ParkingTerminalStrategy {

    private final OutputService salesReportOutput;
    private final OutputService receiptOutput;
////    only to be uncommented if using one of the display classes for a terminal display
//    private final OutputService displayOutput;
    private final SalesReportOutputStrategy outputSalesReport;
    private final FileService fileService;
    private final File file;
    private final BufferedReader br;
    private final boolean fileHasData;
    private double fees;
    private double hours;
    private int cars;
    private DateUtilities dateUtilities;
    private final Random randomGenerator = new Random();
    private final FeeCalculator feeCalculator;

    
    
    /**
     * Constructor set up file reader for the file server in order to read from and
     * add to the file for daily totals.
     * uses a custom exception class
     * @param receiptOutput where to output the receipt data.
     * @param salesReport where to output the salesReport data.
     * @param garageName name of the garage
     * @param fee
     * @param fs File service to be used
     * @param file to be read and written to
     * @throws FileNotFoundException 
     * @throws IOException
     * @throws NullOrEmptyArgumentException custom exception class
     */
    public ExitTerminal(OutputService receiptOutput, OutputService salesReport, String garageName, FeeCalculator fee, FileService fs, File file) throws FileNotFoundException, IOException, NullOrEmptyArgumentException {

        this.receiptOutput = receiptOutput;
        this.salesReportOutput = salesReport;
        this.outputSalesReport = new SalesReport(garageName);
        this.feeCalculator = fee;
        this.file = file;
        br = new BufferedReader(new FileReader(file));
        fileHasData = br.readLine() != null;
        this.fileService = fs;

    }
    /**
     * Processes the exiting cars ticket transaction.
     * Processes the ticket, reads the time and determines hours it was there, adding
     * the information to the file that was specified in the constructor. 
     * @param garageName
     * @param carID
     * @param sDate
     * @param date
     * @throws NullOrEmptyArgumentException
     */
    @Override
    public final void ticketTransaction(String garageName, int carID, String sDate, LocalDateTime date) throws NullOrEmptyArgumentException {
        if (carID < 0 || date == null || sDate.isEmpty()) {
            throw new NullOrEmptyArgumentException();
        }
        
        this.hours = getHours(date);
        this.fees = getFee(date);
        
        
        try {
            addTotalsToFileService(hours, fees);
        } catch (IOException ex) {
            receiptOutput.outputData(ex.toString());
        }
        
        TerminalOutputStrategy outputReceipt = new ReceiptOutput(garageName, carID, hours, fees);
        try {
            outputReceipt(outputReceipt);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e);
        }
        try {
            outputSalesReport(outputSalesReport, hours, fees);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e);
        }
    }
    
    private double getHours(LocalDateTime date){
        //Random generation of numbers just for hour purposes
        LocalDateTime exitTime = LocalDateTime.now();
        
        double hoursParked = ((ChronoUnit.SECONDS.between(date, exitTime) * 8)/60);
        if(hoursParked >= 24){
            hoursParked = 23.0;
        }
        this.hours = hoursParked;
        return hoursParked;
    }
    
    private double getFee(LocalDateTime date){
        
        
        double fee = feeCalculator.getFee(hours);
        return fee;
    }

    //MOVE TO SALES REPORT CLASS
    //fees hours cars
    private void addTotalsToFileService(double h, double f) throws IOException {
        if (fileHasData == false) {

        } else {

            List<Map> fileContent = fileService.readFile(file);
            //fiel content contains one map containing each thing in it.
            System.out.println(fileContent.size());
            System.out.println(fileContent);
            System.out.println(fileContent.get(0).keySet());
            Set<String> set = fileContent.get(0).keySet();
            List<String> data = new ArrayList<>();
            for (String s : set) {
                data.add(fileContent.get(0).get(s).toString());
            }
            fees = Double.parseDouble(data.get(0)) + f;
            hours = Double.parseDouble(data.get(1)) + h;
            cars = Integer.parseInt(data.get(2)) + 1;

            Map<String, String> map = new LinkedHashMap<>();
            map.put("totalFees", "" + fees + "");
            map.put("totalHours", "" + hours + "");
            map.put("totalCars", "" + cars + "");
            
            List<Map> newData = new ArrayList();
            newData.add(map);
            fileService.writeToFile(newData, file, false);
        }
    }

    /**
     * Method used in order to display the fee on a display screen. since this
     * is not a requirement in the program at this time it is commented out. May
     * be un-commented and ExitTerminalDisplayTicketInfoAndFee moved to main
     * ajs-parkinggarageapp folder. This class must be instantiated inside the
     * ticket transaction method and then call he output method from that class.
     *
     * @param display
     */
//    private void displayFeeDue(TerminalOutputStrategy display) throws NullOrEmptyArgumentException{
//        if(display == null){
//          throw new NullOrEmptyArgumentException();
//        }
//        display.output(displayOutput);
//    }
    private void outputReceipt(TerminalOutputStrategy outputReceipt) throws NullOrEmptyArgumentException {
        if (outputReceipt == null) {
            throw new NullOrEmptyArgumentException();
        }
        try {
            outputReceipt.output(receiptOutput);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e);
        }
    }

    /**
     * Method used in order to display the receipt on a display screen. since
     * this is not a requirement in the program at this time it is commented
     * out. May be un-commented and ExitTerminalDisplayReceipt moved to main
     * ajs-parkinggarageapp folder. This class must be instantiated inside the
     * ticket transaction method and then call he output method from that class.
     *
     * @param display
     */
//    private void displayReceipt(TerminalOutputStrategy display) {
//        if(display == null){
//          throw new NullOrEmptyArgumentException();
//        }
//        display.output(displayOutput);
//    }
    private void outputSalesReport(SalesReportOutputStrategy sr, double hours, double fee) throws NullOrEmptyArgumentException {
        if (sr == null || hours <= 0 || hours > 24 || fee < 1.50) {
            throw new NullOrEmptyArgumentException();
        }
        try {
            sr.addToSalesReport(hours, fee);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e);
        }
        try {
            sr.output(salesReportOutput);
        } catch (NullOrEmptyArgumentException e) {
            System.out.println(e);
        }
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.salesReportOutput);
        hash = 37 * hash + Objects.hashCode(this.receiptOutput);
        hash = 37 * hash + Objects.hashCode(this.outputSalesReport);
        return hash;
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExitTerminal other = (ExitTerminal) obj;
        if (!Objects.equals(this.salesReportOutput, other.salesReportOutput)) {
            return false;
        }
        if (!Objects.equals(this.receiptOutput, other.receiptOutput)) {
            return false;
        }
        if (!Objects.equals(this.outputSalesReport, other.outputSalesReport)) {
            return false;
        }
        return true;
    }
    
}
