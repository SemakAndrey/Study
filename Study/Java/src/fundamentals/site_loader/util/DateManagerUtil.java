package fundamentals.site_loader.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateManagerUtil {

    private Calendar calendar;

    public DateManagerUtil(Date date) {

        this.calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Minsk"));
        this.calendar.setTime(date);

    }

    public String getDateFormat(String format) {

        switch (format) {
            case "NBRB":
                return "" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
            case "Alfa-bank":
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = (calendar.get(Calendar.MONTH) + 1);
                return "" + calendar.get(Calendar.YEAR) + "-" + makeCorrectName(month) + "-" + makeCorrectName(day) + "T00:00:00.000Z";
            case "Belagroprombank":
                return "" + calendar.get(Calendar.MONTH) + "/" + (calendar.get(Calendar.DAY_OF_MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
            default:
                return "";
        }
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    private static String makeCorrectName(int period) {
        String result = String.valueOf(period);
        if (period < 10) {
            return "0" + result;
        }
        return result;
    }

}
