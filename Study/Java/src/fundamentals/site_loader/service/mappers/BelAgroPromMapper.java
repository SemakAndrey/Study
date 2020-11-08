package fundamentals.site_loader.service.mappers;

import fundamentals.site_loader.entity.Currencies;
import fundamentals.site_loader.entity.Rate;
import fundamentals.site_loader.service.mappers.core.IMapper;
import fundamentals.site_loader.util.Util;

import java.util.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BelAgroPromMapper implements IMapper {

    @Override
    public void rateMapping(String data, Rate rate) {

        String regex = "<NumCode>\\d+<.NumCode>\\s*<Scale>\\d+<.Scale>\\s*<RateBuy>[.\\d]+<.RateBuy>\\s*<RateSell>[.\\d]+<.RateSell>";
        Matcher matcher = Pattern.compile(regex).matcher(data);
        String code;
        String group;
        while (matcher.find()) {
            group = matcher.group();
            code = Util.getValueByRegex(group,"<NumCode>" + rate.getCurrency().getCode() + "<\\/", "NumCode",2);
            if (code.isBlank()) {
                continue;
            }

            rate.setDate(new Date());
            rate.setScale(Util.getValueByRegex(group,"<Scale>\\d+<\\/", "Scale",2));
            rate.setRateSell(Util.getValueByRegex(group,"<RateSell>[\\d.]+<\\/", "RateSell",2));
            rate.setRateBuy(Util.getValueByRegex(group,"<RateBuy>[\\d.]+<\\/", "RateBuy",2));
            break;
        }
    }

    @Override
    public void rateMappingDate(String data, Rate rate) {

        rate.setDate(Util.getValueByRegex(data, "DailyExRates Date=\"", "[\\d\\/]+",1));
        String regex = "Currency Id=[\\w.\"\\/*\\sА-Яа-я\\\\><]*RateSell";
        Matcher matcher = Pattern.compile(regex).matcher(data);
        String code;
        String group;
        while (matcher.find()) {
            group = matcher.group();
            code = Util.getValueByRegex(group,"<NumCode>" + rate.getCurrency().getCode() + "<\\/", "NumCode",2);
            if (code.isBlank()) {
                continue;
            }

            rate.setScale(Util.getValueByRegex(group,"<Scale>\\d+<.", "Scale",2));
            rate.setRateSell(Util.getValueByRegex(group,"<RateSell>[\\d.]+<.", "RateSell",2));
            rate.setRateBuy(Util.getValueByRegex(group,"<RateBuy>[\\d.]+<.", "RateBuy",2));
            break;
        }

    }

    @Override
    public void rateMappingRange(String data, Set<Rate> rate, Currencies currency) {
        System.out.println("Вы не можете выполнить данный запрос в текущем банке");
    }

}
