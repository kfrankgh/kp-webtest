package org.ghc.utils.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.ghc.utils.extensions.KPAUIEveryTest.ENV;
import static org.testng.Assert.fail;

public class KPAUIStringHelper {

    /**
     * @param month
     * @return
     */
    public static String convertMonthToDigit(String month){
        try{
            Date monthDate = new SimpleDateFormat("MMMM").parse(month);
            return new SimpleDateFormat("MM").format(monthDate);
        } catch(ParseException e){
            fail("Could not Parse Month To Digit");
            return null;
        }
    }

    public static String getRegexMatch(String input, String regex){
        Pattern p= Pattern.compile(regex);
        Matcher m = p.matcher(input);

        if (m.find()) {
            return m.group(0);
        }
        return null;
    }

    public static List<String> getRegexMatches(String input, String regex){
        List<String> matches = new ArrayList<>();
        Pattern p= Pattern.compile(regex);
        Matcher m = p.matcher(input);

        while (m.find()) {
            matches.add(m.group());
        }
        return matches;
    }

    /**
     * @param dob
     * @param pattern
     * @return
     */
    public static String formatAccountDob(String dob, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dob, dtf);
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * @param date
     * @param datePattern
     * @return day of month in format dd
     */
    public static String getDayFromDate(String date, String datePattern){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(datePattern);
        LocalDate localDate = LocalDate.parse(date, dtf);
        String day = String.valueOf(localDate.getDayOfMonth());
        return ( day.length() == 1 ) ? ( "0" + day ) : day;
    }

    /**
     * @param datePattern
     * @return
     */
    public static String getOneYearPriorDate(String datePattern){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(datePattern);
        LocalDate localDate = LocalDate.now().minusYears(1);
        return dtf.format(localDate);
    }

    /**
     * @param site
     * @return
     */
    public static String getSiteWithPrefix(String site) {
        if (ENV.equals("QA"))
            return String.format(site, "-qa");
        else if (ENV.equals("DEV"))
            return String.format(site, "-dev");
        else
            return String.format(site, "");
    }
}
