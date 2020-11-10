package fundamentals.strings.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterUtil {

    private final Map<Integer, String> DICTIONARY_NUMBERS = new HashMap<>();
    private final Map<Integer, String[]> DICTIONARY_SEGMENTS = new HashMap<>();
    private final Map<Integer, String> DICTIONARY_FRACTIONAL_NAME = new HashMap<>();
    private final String separateName = "целых ";
    private final long HOUR_IN_MILLISECOND = 3600000;
    private final long MINUTE_IN_MILLISECOND = 60000;
    private final long SECOND_IN_MILLISECOND = 1000;

    public ConverterUtil() {

        DICTIONARY_NUMBERS.put(0, "");
        DICTIONARY_NUMBERS.put(1, "один");
        DICTIONARY_NUMBERS.put(2, "два");
        DICTIONARY_NUMBERS.put(3, "три");
        DICTIONARY_NUMBERS.put(4, "четыре");
        DICTIONARY_NUMBERS.put(5, "пять");
        DICTIONARY_NUMBERS.put(6, "шесть");
        DICTIONARY_NUMBERS.put(7, "семь");
        DICTIONARY_NUMBERS.put(8, "восемь");
        DICTIONARY_NUMBERS.put(9, "девять");
        DICTIONARY_NUMBERS.put(10, "десять");
        DICTIONARY_NUMBERS.put(11, "одинадцать");
        DICTIONARY_NUMBERS.put(12, "двенадцать");
        DICTIONARY_NUMBERS.put(13, "тринадцать");
        DICTIONARY_NUMBERS.put(14, "четырнадцать");
        DICTIONARY_NUMBERS.put(15, "пятнадцать");
        DICTIONARY_NUMBERS.put(16, "шестнадцать");
        DICTIONARY_NUMBERS.put(17, "семьнадцать");
        DICTIONARY_NUMBERS.put(18, "восемьнадцать");
        DICTIONARY_NUMBERS.put(19, "девятнадцать");
        DICTIONARY_NUMBERS.put(20, "двадцать");
        DICTIONARY_NUMBERS.put(30, "тридцать");
        DICTIONARY_NUMBERS.put(40, "сорок");
        DICTIONARY_NUMBERS.put(50, "пятьдесят");
        DICTIONARY_NUMBERS.put(60, "шестьдесят");
        DICTIONARY_NUMBERS.put(70, "семьдесят");
        DICTIONARY_NUMBERS.put(80, "восемтдесят");
        DICTIONARY_NUMBERS.put(90, "девяносто");
        DICTIONARY_NUMBERS.put(100, "сто");
        DICTIONARY_NUMBERS.put(200, "двести");
        DICTIONARY_NUMBERS.put(300, "триста");
        DICTIONARY_NUMBERS.put(400, "четыреста");
        DICTIONARY_NUMBERS.put(500, "пятьсот");
        DICTIONARY_NUMBERS.put(600, "шестьсот");
        DICTIONARY_NUMBERS.put(700, "семьсот");
        DICTIONARY_NUMBERS.put(800, "восемьсот");
        DICTIONARY_NUMBERS.put(900, "девятьсот");

        DICTIONARY_SEGMENTS.put(0, new String[]{"", "", ""});
        DICTIONARY_SEGMENTS.put(1, new String[]{"тысяча", "тысячи", "тысячь"});
        DICTIONARY_SEGMENTS.put(2, new String[]{"миллион", "миллиона", "миллионов"});
        DICTIONARY_SEGMENTS.put(3, new String[]{"миллиард", "миллиарда", "миллиардов"});

        DICTIONARY_FRACTIONAL_NAME.put(1, "десятых");
        DICTIONARY_FRACTIONAL_NAME.put(2, "сотых");
        DICTIONARY_FRACTIONAL_NAME.put(3, "тысячных");
        DICTIONARY_FRACTIONAL_NAME.put(4, "десятитысячных");
        DICTIONARY_FRACTIONAL_NAME.put(5, "стотысячных");
        DICTIONARY_FRACTIONAL_NAME.put(6, "милионных");
        DICTIONARY_FRACTIONAL_NAME.put(-1, "");

    }

    public String getNumberAsText(String number) {

        StringBuilder sb = new StringBuilder();
        sb.append(getSign(number));
        number = handleValue(number, 1);

        sb.append(getIntPart(number));
        number = handleValue(number, 2);

        sb.append(getSeparator(number));
        number = handleValue(number, 3);

        sb.append(getFractalPart(number));

        return sb.toString();

    }

    private String handleValue(String value, int i) {

        switch (i) {
            case 1:
                return value.replaceAll("[_-]", "");
            case 2:
                return value.replaceAll("\\d+(?=\\.)|^\\d+", "");
            case 3:
                return value.replaceAll("[.,]", "");
            case 4:
                return value.replaceAll("\\d*", "");
            default:
                return "";
        }
    }

    private String getSign(String value) {

        return value.trim().charAt(0) == '-' ? "минус " : "";

    }

    private String getIntPart(String value) {

        Matcher matcher = Pattern.compile("\\d+(?=\\.)|^\\d+").matcher(value);
        if (matcher.find()) {
            return getText(matcher.group());
        }
        return DICTIONARY_NUMBERS.get(0);
    }

    private String getSeparator(String value) {
        if (!value.trim().isBlank()) {
            char ch = value.trim().charAt(0);
            return ch == '.' || ch == ',' ? this.separateName : "";
        }
        return "";
    }

    private String getFractalPart(String value) {
        if (value.trim().isBlank()) {
            return "";
        }
        return getIntPart(value) + DICTIONARY_FRACTIONAL_NAME.get(value.trim().length());
    }

    private String getText(String value) {

        ArrayList<String> ls = new ArrayList<>();

        int number;
        try {
            number = Integer.valueOf(value);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return "";
        }
        int subnumber;
        for (int i = 0; ; i++) {

            subnumber = number % 1000;
            number = number / 1000;

            ls.add(recursiveConverter("", subnumber, 100, i));

            if (number == 0) {
                break;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = ls.size() - 1; i >= 0; i--) {
            sb.append(ls.get(i)).append(" ");
        }

        return sb.toString();

    }

    private String recursiveConverter(String resul, int number, int divider, int segment) {

        if (divider == 1 || DICTIONARY_NUMBERS.get(number) != null) {
            switch (number) {
                case 1:
                    if (segment == 1) {
                        return resul + "одна " + DICTIONARY_SEGMENTS.get(segment)[0];
                    }
                    return resul + DICTIONARY_NUMBERS.get(number) + " " + DICTIONARY_SEGMENTS.get(segment)[0];
                case 2:
                    if (segment == 1) {
                        return resul + "две " + DICTIONARY_SEGMENTS.get(segment)[1];
                    }
                case 3:
                case 4:
                    return resul + DICTIONARY_NUMBERS.get(number) + " " + DICTIONARY_SEGMENTS.get(segment)[1];
                default:
                    return resul + DICTIONARY_NUMBERS.get(number) + " " + DICTIONARY_SEGMENTS.get(segment)[2];
            }
        }

        return recursiveConverter(resul + DICTIONARY_NUMBERS.get(number / divider * divider) + " ", number % divider, divider / 10, segment);

    }

    public String toWeek(int day) {

        String strWeeks = String.valueOf(day / 7);
        String ending;
        switch (strWeeks.charAt(strWeeks.length() - 1)) {
            case '1':
                ending = "я";
                break;
            case '2':
            case '3':
            case '4':
                ending = "и";
                break;
            default:
                ending = "ь";
                break;
        }

        return strWeeks + " недел" + ending;

    }

    //4.* Написать метод String toHoursMinuteSecondMillisecond(long millisecond, boolean shortFormat).
    public String toHoursMinuteSecondMillisecond(long millisecond, boolean shortFormat) {

        long hours = millisecond / HOUR_IN_MILLISECOND;
        long remain = millisecond - hours * HOUR_IN_MILLISECOND;
        long minutes = remain / MINUTE_IN_MILLISECOND;
        remain -= minutes * MINUTE_IN_MILLISECOND;
        long seconds = remain / SECOND_IN_MILLISECOND;
        remain -= seconds * SECOND_IN_MILLISECOND;

        if (shortFormat) {
            return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, remain);
        }

        return String.format("%s %s %s %s",
                convertToStringForTime(hours, 0),
                convertToStringForTime(minutes, 1),
                convertToStringForTime(seconds, 2),
                convertToStringForTime(remain, 3));
    }

    private String convertToStringForTime(long value, int index) {

        String[] timeName = {"час", "минут", "секунд", "миллисекунд"};
        String ending;
        switch (String.valueOf(value).charAt(String.valueOf(value).length() - 1)) {
            case '1':
                ending = index == 0 ? "" : "а";
                break;
            case '2':
            case '3':
            case '4':
                ending = index == 0 ? "а" : "ы";
                break;
            default:
                ending = index == 0 ? "ов" : "";
                break;
        }

        return "" + value + " " + timeName[index] + ending;
    }
}
