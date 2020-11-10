package fundamentals.site_loader.service.mappers;

import fundamentals.site_loader.entity.Currencies;
import fundamentals.site_loader.entity.Rate;
import fundamentals.site_loader.service.mappers.core.IMapper;
import fundamentals.site_loader.util.Util;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlfaMapper implements IMapper {

    @Override
    public void rateMapping(String data, Rate rate) {

        Matcher matcher = Pattern.compile("\\{{1}[\\w\\s.,:\"T\\-А-я]+\\}{1}").matcher(data);
        int codeCurrency;
        int codeBYN;
        String group;
        while (matcher.find()) {
            group = matcher.group();
            codeCurrency = Util.getIntValue(Util.getValueByRegex(group, "\"sellCode\":\\s*", "\\d+",1));
            codeBYN = Util.getIntValue(Util.getValueByRegex(group, "\"buyCode\":\\s*", "\\d+",1));
            if (codeCurrency != rate.getCurrency().getCode() || codeBYN != Currencies.BYN.getCode()) {
                continue;
            }

            rate.setDate(Util.getValueByRegex(group, "\"date\":\\s*", "[\\\"\\-\\w\\-.:]+",1));
            rate.setScale(Util.getValueByRegex(group, "\"quantity\":\\s*", "\\d+",1));
            rate.setRateSell(Util.getValueByRegex(group, "\"buyRate\":\\s*", "[\\d.]+",1));
            rate.setRateBuy(Util.getValueByRegex(group, "\"sellRate\":\\s*", "[\\d.]+",1));
            break;
        }
    }

    @Override
    public void rateMappingDate(String data, Rate rate) {

        rate.setDate(Util.getValueByRegex(data, "\"date\":\\s*", "[\\\"\\-\\w\\-.:]+",1));
        rate.setScale(Util.getValueByRegex(data, "\"quantity\":\\s*", "\\d+",1));
        rate.setRateSell(Util.getValueByRegex(data, "\"rate\":\\s*", "[\\d.]+",1));
        rate.setRateBuy(rate.getRateSell());

    }

    @Override
    public void rateMappingRange(String data, Set<Rate> rate, Currencies currency) {
        System.out.println("Вы не можете выполнить данный запрос в текущем банке");
    }

}
