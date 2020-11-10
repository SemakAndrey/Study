package fundamentals.site_loader.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Util {

    public static String getValueByRegex(String value, String regexStart, String regexEnd, int variant) {

        if (variant == 1) {

            Matcher matcher = Pattern.compile(regexStart + regexEnd).matcher(value);
            if (matcher.find()) {
                return matcher.group().replaceAll(regexStart, "").replaceAll("[<|>/]", "").trim();
            }
        } else {
            Matcher matcher = Pattern.compile(regexStart).matcher(value);
            if (matcher.find()) {
                return matcher.group().replaceAll(regexEnd, "").replaceAll("[<|>\\/]", "").trim();
            }
        }
        return "";
    }

    public static int getIntValue(String origin) {

        try {
            return Integer.parseInt(origin.replaceAll("\"", ""));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static Date getDateValue(String origin) {

        if (!origin.isBlank()) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                return simpleDateFormat.parse(origin.replaceAll("\"", ""));
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Date();
    }

    public static double getDoubleValue(String origin) {

        try {
            return Double.parseDouble(origin.replaceAll("\"", ""));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return 0.0;
    }

}
