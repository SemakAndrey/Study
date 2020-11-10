package fundamentals.site_loader.service.mappers;

import fundamentals.site_loader.entity.Currencies;
import fundamentals.site_loader.entity.Rate;
import fundamentals.site_loader.service.mappers.core.IMapper;
import fundamentals.site_loader.util.Util;

import java.util.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BelarusMapper implements IMapper {

    @Override
    public void rateMapping(String data, Rate rate) {

        Matcher matcher = Pattern.compile("\\{{1}[\\w\\s.,_|/:\"T\\-А-я]+\\}{1}").matcher(data);
        if (matcher.find()) {
            String group = matcher.group();
            rate.setDate(new Date());
            rate.setScale(rate.getCurrency().getDefaultScale());
            rate.setRateSell(Util.getValueByRegex(group, "\"" + rate.getCurrency().name()+ "_out\":\\s*", "\"[\\d.]+\"",1));
            rate.setRateBuy(Util.getValueByRegex(group, "\"" + rate.getCurrency().name()+ "_in\":\\s*", "\"[\\d.]+\"",1));
        }
    }

    @Override
    public void rateMappingDate(String data, Rate rate) {
        System.out.println("Вы не можете выполнить данный запрос в текущем банке");
    }

    @Override
    public void rateMappingRange(String data, Set<Rate> rate, Currencies currency) {
        System.out.println("Вы не можете выполнить данный запрос в текущем банке");
    }

}
