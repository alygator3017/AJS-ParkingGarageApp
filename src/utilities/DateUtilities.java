package utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * Different Utility Methods for Date class conversions and mathematics. Uses
 * new java 8 API. Needs at least 2 ways of converting from string to date.
 * Needs at least 2 ways of converting from date to string. Needs at least one
 * method performing date/time arithmetic.
 *
 * @author ajSchmidt-Zimmel
 * @version 1
 */
public class DateUtilities {

    /**
     * Returns a String of a LocalDate object. Only for LocalDate, not
     * LocalDateTime. This will return a date, not a date and time. This will
     * return and ISO_LOCAL_DATE.
     *
     * @param date date to be converted to string
     * @return date of type ISO_LOCAL_DATE
     * @throws IllegalArgumentException
     */
    public String toString(LocalDate date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException();
        }
        String fDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        return fDate;
    }

    /**
     * Returns a String of a LocalDate object formatted to the specified format.
     * Only for LocalDate, not LocalDateTime. This will return a date, not a
     * date and time. Also uses a DateTimeFormatter parameter to format the date
     * passed in. To format use DateTimeFormatter.ofPattern("[insert pattern]").
     *
     * @param date date to be converted to string
     * @param format Format in which date will be converted. ex:
     * DateTimeFormatter.ofPattern("MM-dd-YYYY") or
     * DateTimeFormatter.ofPattern("M/d/YY"), etc. Please see API for String
     * options
     * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     * @return formated date string
     * @throws IllegalArgumentException
     */
    public String toString(LocalDate date, DateTimeFormatter format) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException();
        } else if (format == null) {
            throw new IllegalArgumentException();
        }
        String fDate = null;
        fDate = date.format(format);
        return fDate;
    }

    /**
     * Returns a String of a LocalDate object formatted to the specified format.
     * Only for LocalDate, not LocalDateTime. This will return a date, not a
     * date and time. Also uses a DateTimeFormatter parameter to format the date
     * passed in. To format use DateTimeFormatter.ofPattern("[insert pattern]").
     *
     * @param date date to be converted to string
     * @param format in which date will be converted. ex: "MM-dd-YYYY" or
     * "M/d/YY", etc. Please see API for String options
     * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     * @return formated date string
     * @throws IllegalArgumentException
     */
    public String toString(LocalDate date, String format) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException();
        } else if (format == null || format.isEmpty()) {
            throw new IllegalArgumentException();
        }
        DateTimeFormatter f = null;
        try {
            f = DateTimeFormatter.ofPattern(format);
        } catch (IllegalArgumentException ex) {
            throw ex;
        }
        String fDate = null;
        fDate = date.format(f);
        return fDate;
    }

    /**
     * Returns a String of a LocalDateTime object. Only for LocalDateTime, not
     * LocalDate. This will return a date and time, not just a date. This will
     * return and ISO_LOCAL_DATE_TIME.
     *
     * @param date Date time to be converted to a string.
     * @return date time String of ISO_LOCAL_DATE_TIME
     * @throws IllegalArgumentException
     */
    public String toString(LocalDateTime date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException();
        }
        String fDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return fDate;
    }

    /**
     * Returns a String of a LocalDateTime object. Only for LocalDateTime, not
     * LocalDate. This will return a date and time, not just a date. Also uses a
     * DateTimeFormatter parameter to format the date passed in. To format use
     * DateTimeFormatter.ofPattern("[insert pattern]").
     *
     * @param date Date to be converted to a string.
     * @param format Format in which date time will be converted. ex:
     * DateTimeFormatter.ofPattern("MM-dd-YYYY hh:mm a") or
     * DateTimeFormatter.ofPattern("M/d/YY k:mm:ss"), etc. Please see API for
     * String options
     * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     * @return formatted date time string.
     * @throws IllegalArgumentException
     */
    public String toString(LocalDateTime date, DateTimeFormatter format) throws IllegalArgumentException {
        if (date == null || format == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        String fDate = date.format(format);
        return fDate;
    }

    /**
     * Returns a String of a LocalDateTime object. Only for LocalDateTime, not
     * LocalDate. This will return a date and time, not just a date. Also uses a
     * DateTimeFormatter parameter to format the date passed in. To format use
     * DateTimeFormatter.ofPattern("[insert pattern]").
     *
     * @param date to be converted to a string.
     * @param format in which date time will be converted. ex: "MM-dd-YYYY hh:mm
     * a" or "M/d/YY k:mm:ss", etc. Please see API for String options
     * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     * @return formatted date time string.
     * @throws IllegalArgumentException
     */
    public String toString(LocalDateTime date, String format) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException();
        } else if (format == null || format.isEmpty()) {
            throw new IllegalArgumentException();
        }
        DateTimeFormatter f = null;
        try {
            f = DateTimeFormatter.ofPattern(format);
        } catch (IllegalArgumentException ex) {
            throw ex;
        }
        String fDate = null;
        fDate = date.format(f);
        return fDate;
    }

    /**
     * Returns the LocalDate of a string. Only for LocalDate, not LocalDateTime.
     * This will only return a date, not a date and time.
     *
     * @param date a string to be changed to a LocalDate.
     * @return LocalDate
     * @throws IllegalArgumentException
     */
    public LocalDate toDate(String date) throws IllegalArgumentException {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException();
        }
        LocalDate parseDate = LocalDate.parse(date);
        return parseDate;
    }

    /**
     * Returns the LocalDate of a string in the specified format. Only for
     * LocalDate, not LocalDateTime. This will only return a date, not a date
     * and time. Also uses a DateTimeFormatter parameter to format the date
     * passed in. To format use DateTimeFormatter.ofPattern("[insert pattern]").
     *
     * @param date a string date to be changed to a LocalDate.
     * @param format The specified format to be used. ex:
     * DateTimeFormatter.ofPattern("MM-dd-YYYY") or
     * DateTimeFormatter.ofPattern("M/d/YY"), etc.
     * @return A LocalDate of a specified format
     * @throws IllegalArgumentException
     */
    public LocalDate toDate(String date, DateTimeFormatter format) throws IllegalArgumentException {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (format == null) {
            throw new IllegalArgumentException();
        }
        LocalDate parseDate = null;
        try {
            parseDate = LocalDate.parse(date, format);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return parseDate;
    }

    /**
     * Returns the LocalDate of a string in the specified format. Only for
     * LocalDate, not LocalDateTime. This will only return a date, not a date
     * and time. Also uses a DateTimeFormatter parameter to format the date
     * passed in. To format use DateTimeFormatter.ofPattern("[insert pattern]").
     *
     * @param date a string date to be changed to a LocalDate.
     * @param format The specified format to be used. ex: "MM-dd-YYYY" or
     * "M/d/YY", etc. Please see API for String options
     * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     * @return A LocalDate of a specified format
     * @throws IllegalArgumentException
     */
    public LocalDate toDate(String date, String format) throws IllegalArgumentException {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (format == null || format.isEmpty()) {
            throw new IllegalArgumentException();
        }
        DateTimeFormatter f = null;
        try {
            f = DateTimeFormatter.ofPattern(format);
        } catch (IllegalArgumentException ex) {
            throw ex;
        }
        LocalDate parseDate = null;
        try {
            parseDate = LocalDate.parse(date, f);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return parseDate;
    }

    /**
     * Returns the LocalDateTime of a string. Only for LocalDateTime, not
     * LocalDate. This will return a date and time, not only a date.
     *
     * @param date A string date to be changed to a LocalDateTime.
     * @return A LocalDateTime.
     * @throws IllegalArgumentException
     */
    public LocalDateTime toDateTime(String date) throws IllegalArgumentException {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException();
        }
        LocalDateTime parseDate = LocalDateTime.parse(date);
        return parseDate;
    }

    /**
     * Returns the LocalDateTime of a string in the specified format. Only for
     * LocalDateTime, not LocalDate. This will return a date and time, not only
     * a date. Also uses a DateTimeFormatter parameter to format the date passed
     * in. To format use DateTimeFormatter.ofPattern("[insert pattern]").
     *
     * @param date a string date to be changed to a LocalDateTime.
     * @param format Specified format to be used for the LocalDateTime ex:
     * DateTimeFormatter.ofPattern("MM-dd-YYYY hh:mm a") or
     * DateTimeFormatter.ofPattern("M/d/YY k:mm:ss"), etc.
     * @return LocalDateTime of a specified format
     * @throws IllegalArgumentException
     */
    public LocalDateTime toDateTime(String date, DateTimeFormatter format) throws IllegalArgumentException {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException("String to local Date parameter cannot be null or empty.");
        } else if (format == null) {
            throw new IllegalArgumentException("Format of type DateTimeFormatter cannot be null");
        }
        LocalDateTime parseDate = null;
        try {
            parseDate = LocalDateTime.parse(date, format);
        } catch (IllegalArgumentException e) {
            System.out.println(e + ", " + e.getMessage());
        }
        return parseDate;
    }


    /**
     * Returns the LocalDateTime of a string in the specified format. Only for
     * LocalDateTime, not LocalDate. This will return a date and time, not only
     * a date. Also uses a DateTimeFormatter parameter to format the date passed
     * in. To format use DateTimeFormatter.ofPattern("[insert pattern]").
     *
     * @param date a string date to be changed to a LocalDateTime.
     * @param format The specified format to be used. ex: "M/d/YY k:mm:ss" or
     * "M/d/YY k:mm:ss", etc. 
     * Please see API for String options
     * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     * @return LocalDateTime of a specified format
     * @throws IllegalArgumentException
     */
    public LocalDate toDateTime(String date, String format) throws IllegalArgumentException {
        if (date == null || date.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (format == null || format.isEmpty()) {
            throw new IllegalArgumentException();
        }
        DateTimeFormatter f = null;
        try {
            f = DateTimeFormatter.ofPattern(format);
        } catch (IllegalArgumentException ex) {
            throw ex;
        }
        LocalDate parseDate = null;
        try {
            parseDate = LocalDate.parse(date, f);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return parseDate;
    }

    /**
     * dateDiff() is the difference between two dates using LocalDate and a
     * TemporalUnit. Only for LocalDate, not LocalDateTime. TemporalUnit is used
     * to specify what kind of unit you want the difference back in (e.g. Days,
     * Months, etc.) Anything less than a day for TemporalUnit will not be
     * accepted and will throw and exception.
     *
     * @param temporalUnit e.g. Days, months, etc. Anything less than a day is
     * not accepted and will throw an exception. Make sure to use a try catch to
     * catch any errors.
     * @param firstDate starting LocalDate to be compared.
     * @param secondDate ending LocalDate to be compared.
     * @return difference in firstDate and secondDate according to specified
     * TemporalUnit.
     * @throws IllegalArgumentException
     */
    public double dateDiff(TemporalUnit temporalUnit, LocalDate firstDate, LocalDate secondDate) throws IllegalArgumentException {
        if (firstDate == null) {
            throw new IllegalArgumentException("First date parameter of type LocalDate is null.");
        } else if (secondDate == null) {
            throw new IllegalArgumentException("Second date parameter of type LocalDate is null");
        } else if (temporalUnit == null || temporalUnit == ChronoUnit.HOURS || temporalUnit == ChronoUnit.MINUTES || temporalUnit == ChronoUnit.SECONDS || temporalUnit == ChronoUnit.MILLIS || temporalUnit == ChronoUnit.MICROS || temporalUnit == ChronoUnit.NANOS) {
            throw new IllegalArgumentException("TemporalUnit is null or has a unit of time less than a day");
        }
        LocalDate startDate = firstDate;
        LocalDate endDate = secondDate;

        Long diff = temporalUnit.between(startDate, endDate);

        return diff;
    }

    /**
     * dateDiff() is the difference between two dates using LocalDate and a
     * TemporalUnit. Only for LocalDateTime, not LocalDate. TemporalUnit is used
     * to specify what kind of unit you want the difference back in (e.g. Days,
     * Months, etc.)
     *
     * @param temporalUnit e.g. Days, months, etc.
     * @param firstDate Starting LocalDateTime to be compared.
     * @param secondDate Ending LocalDateTime to be compared.
     * @return difference in firstDate and secondDate according to specified
     * TemporalUnit.
     * @throws IllegalArgumentException
     */
    public double dateTimeDiff(TemporalUnit temporalUnit, LocalDateTime firstDate, LocalDateTime secondDate) throws IllegalArgumentException {
        if (firstDate == null) {
            throw new IllegalArgumentException("First date parameter of type LocalDate is null.");
        } else if (secondDate == null) {
            throw new IllegalArgumentException("Second date parameter of type LocalDate is null");
        } else if (temporalUnit == null) {
            throw new IllegalArgumentException("TemporalUnit is null or has a unit of time less than a day");
        }
        LocalDateTime startDate = firstDate;
        LocalDateTime endDate = secondDate;

        long diff = temporalUnit.between(startDate, endDate);

        return diff;
    }
    
    public static void main(String[] args) {
        LocalDateTime date1 = LocalDateTime.now();
        LocalDateTime date2 = date1.plusHours(8);
        
        System.out.println(date1);
        System.out.println(date2);
        DateUtilities dateUtilities = new DateUtilities();
        Double diff = dateUtilities.dateTimeDiff(ChronoUnit.HOURS, date1, date2);
        System.out.println(diff);
    }
}
