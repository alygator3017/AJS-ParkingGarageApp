package ajs.parkinggarageapp;

import fileserviceapp.FileService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import utilities.DateUtilities;

/**
 * Terminal for exiting cars. this terminal only processes the exiting vehicles
 * ticket transactions.
 *
 * @author ajSchmidt-Zimmel
 */
public class ExitTerminal implements ParkingTerminalStrategy {

    private final OutputService salesReportOutput;
    private final OutputService receiptOutput;
    private final SalesReportStrategy outputSalesReport;
    private final FileService fileService;
    private final File file;
    private final BufferedReader br;
    private final boolean fileHasData;
    private double fees;
    private double hours;
//    private int cars;
    private DateUtilities dateUtilities;
    private final Random randomGenerator = new Random();
    private final FeeCalculator feeCalculator;

    /**
     * Constructor set up file reader for the file server in order to read from
     * and add to the file for daily totals. uses a custom exception class. All
     * parameters cannot be null or empty.
     *
     * @param receiptOutput Where to output the receipt data.
     * @param salesReport Where to output the salesReport data.
     * @param garageName Name of the garage.
     * @param fee The type of fee strategy the garage is using.
     * @param fs File service to be used
     * @param file To be read and written to
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NullOrEmptyArgumentException custom exception class
     */
    public ExitTerminal(OutputService receiptOutput, OutputService salesReport,
            String garageName, FeeCalculator fee, FileService fs, File file)
            throws FileNotFoundException, IOException, NullOrEmptyArgumentException {
        if (receiptOutput == null || salesReport == null) {
            throw new NullOrEmptyArgumentException("one or more OutputServices is null in ExitTerminal constructor");
        } else if (garageName == null) {
            throw new NullOrEmptyArgumentException("garageName is null in ExitTerminal constructor");
        } else if (fee == null) {
            throw new NullOrEmptyArgumentException("FeeCalculator is null in ExitTerminal constructor");
        } else if (fs == null) {
            throw new NullOrEmptyArgumentException("FilseService is null in ExitTerminal constructor");
        } else if (file == null) {
            throw new NullOrEmptyArgumentException("File is null in ExitTerminal constructor");
        }
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
     * Processes the exiting cars ticket transaction. Processes the ticket,
     * reads the time and determines hours it was there, adding the information
     * to the file that was specified in the constructor. Car id must be greater
     * than 0, date and sDate cannot be null or empty.
     *
     * @param garageName
     * @param carID
     * @param sDate
     * @param date
     * @throws NullOrEmptyArgumentException
     */
    @Override
    public final void ticketTransaction(String garageName, int carID, String sDate, LocalDateTime date) throws NullOrEmptyArgumentException {
        if (carID < 0 || date == null || sDate.isEmpty()) {
            throw new NullOrEmptyArgumentException("carID, date or sDate are null or empty in ticketTransaction in ExitTerminal");
        }

        this.hours = getHours(date);
        try {
            this.fees = getFee(date);
        } catch (NumberOutOfRangeException ex) {
            receiptOutput.outputData(ex.toString());
        }
        ParkingTerminalExitDisplayWindow exDisplay = new ParkingTerminalExitDisplayWindow(carID, sDate, fees, hours);

        TerminalOutputStrategy outputReceipt = null;
        try {
            outputReceipt = new ReceiptOutput(garageName, carID, hours, fees);
        } catch (NumberOutOfRangeException ex) {
            System.out.println(ex + " outputReceipt in ticket transaction in ExitTerminal.");
        }
        try {
            outputReceipt(outputReceipt);
        } catch (NullOrEmptyArgumentException e) {
            receiptOutput.outputData(e);
        }

        try {
            outputSalesReport(outputSalesReport, hours, fees);
        } catch (NumberOutOfRangeException ex) {
            receiptOutput.outputData(ex.toString());
        }
        try {
            addTotalsToFileService(hours, fees);
        } catch (IOException ex) {
            receiptOutput.outputData(ex.toString());
        }
    }

    private double getHours(LocalDateTime date) throws NullOrEmptyArgumentException {
        if (date == null) {
            throw new NullOrEmptyArgumentException("date is null in getHours in ExitTerminal.");
        }
        //Random generation of numbers just for hour purposes
        LocalDateTime exitTime = LocalDateTime.now();

        double hoursParked = ((ChronoUnit.SECONDS.between(date, exitTime) * 8) / 60);
        this.hours = hoursParked;
        return hoursParked;
    }

    private double getFee(LocalDateTime date) throws NullOrEmptyArgumentException, NumberOutOfRangeException {
        if (date == null) {
            throw new NullOrEmptyArgumentException("date is null in getFee in ExitTerminal");
        }

        double fee = feeCalculator.getFee(hours);
        return fee;
    }

    private void addTotalsToFileService(double h, double f) throws IOException, NullOrEmptyArgumentException {
        if (h == 0 || f == 0) {
            throw new NullOrEmptyArgumentException("hours or fees is 0 in addTotalsToFileService in ExitTerminal");
        }
        if (fileHasData == false) {
            Map<String, String> map = new LinkedHashMap<>();
            map.put("totalFees", "" + fees + "");
            map.put("totalHours", "" + hours + "");
            map.put("totalCars", "" + 1 + "");

            List<Map> newData = new ArrayList();
            newData.add(map);
            fileService.writeToFile(newData, file, false);
        } else {
            List<Map> fileContent = fileService.readFile(file);
            Set<String> set = fileContent.get(0).keySet();
            List<Double> list = new ArrayList<>();
            for (String s : set) {
                list.add(Double.parseDouble(fileContent.get(0).get(s).toString()));
            }
            Double totalFee = list.get(0) + f;
            Double totalHours = list.get(1) + h;
            Double totalCars = list.get(2) + 1;
            Map<String, String> map = new LinkedHashMap<>();
            map.put("totalFees", "" + totalFee + "");
            map.put("totalHours", "" + totalHours + "");
            map.put("totalCars", "" + totalCars + "");

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
    private void outputReceipt(TerminalOutputStrategy outputReceipt) throws NullOrEmptyArgumentException {
        if (outputReceipt == null) {
            throw new NullOrEmptyArgumentException("outputReceipt is null in outputReceipt in ExitTerminal");
        }
        try {
            outputReceipt.output(receiptOutput);
        } catch (NullOrEmptyArgumentException e) {
            receiptOutput.outputData(e + " output receipt null error when trying to output in Exit terminal.");
        }
    }

    /**
     * Method used in order to display the receipt on a display screen. since
     * this is not a requirement in the program at this time it is commented
     * out. May be un-commented and ExitTerminalDisplayReceipt moved to main
     * ajs-parkinggarageapp folder. This class must be instantiated inside the
     * ticket transaction method and then call he output method from that class.
     * SalesReport or sr, cannot be null, hours cannot be greater than 24 or
     * less than or equal to 0 and fee cannot be less than 1.50.
     *
     * @param display
     *
     */
    private void outputSalesReport(SalesReportStrategy sr, double hours, double fee) throws NullOrEmptyArgumentException, NumberOutOfRangeException {
        if (sr == null) {
            throw new NullOrEmptyArgumentException("SalesReportOutputStrategy is null");
        } else if (hours <= 0) {
            throw new NumberOutOfRangeException("hours is less than or equal to 0 in outputSalesReport in ExitTerminal");
        } else if (fee < 1.50) {
            throw new NumberOutOfRangeException("fee is less that 1.50 in outputSalesReport in ExitTerminal");
        }
        try {
            sr.addToSalesReport(hours, fee);
        } catch (NullOrEmptyArgumentException e) {
            receiptOutput.outputData(e + " null when trying to add to sales report in output sales report method in exit terminal.");
        }
        try {
            sr.output(salesReportOutput);
        } catch (NullOrEmptyArgumentException e) {
            receiptOutput.outputData(e + " null when trying to output sales report in out sales report method in exit terminal.");
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
