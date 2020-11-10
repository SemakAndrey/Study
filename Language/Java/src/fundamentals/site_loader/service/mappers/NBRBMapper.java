package fundamentals.site_loader.service.mappers;

import fundamentals.site_loader.entity.Currencies;
import fundamentals.site_loader.entity.Rate;
import fundamentals.site_loader.service.mappers.core.IMapper;
import fundamentals.site_loader.util.Util;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NBRBMapper implements IMapper {

    @Override
    public void rateMapping(String data, Rate rate) {

        rate.setDate(Util.getValueByRegex(data, "\"Date\":\\s*", "[\"\\d-T:]+",1));
        rate.setScale(Util.getValueByRegex(data, "\"Cur_Scale\":\\s*", "\\d+",1));
        rate.setRateSell(Util.getValueByRegex(data, "\"Cur_OfficialRate\":\\s*", "[\\d.]+",1));
        rate.setRateBuy(rate.getRateSell());
    }

    @Override
    public void rateMappingDate(String data, Rate rate) {

        Matcher matcher = Pattern.compile("\\{{1}[\\w\\s.,:\"T\\-А-я]+\\}{1}").matcher(data);
        int codeCurrency;
        String group;
        while (matcher.find()) {
            group = matcher.group();
            codeCurrency = Util.getIntValue(Util.getValueByRegex(group, "\"Cur_ID\":\\s*", "\\d+",1));
            if (!String.valueOf(codeCurrency).equals(rate.getCurrency().getId())) {
                continue;
            }

            rate.setDate(Util.getValueByRegex(group, "\"Date\":\\s*", "[\\\"\\-\\w\\-.:]+",1));
            rate.setScale(Util.getValueByRegex(group, "\"Cur_Scale\":\\s*", "\\d+",1));
            rate.setRateSell(Util.getValueByRegex(group, "\"Cur_OfficialRate\":\\s*", "[\\d.]+",1));
            rate.setRateBuy(rate.getRateSell());
            break;
        }
    }

    @Override
    public void rateMappingRange(String data, Set<Rate> rates, Currencies currency) {

        Matcher matcher = Pattern.compile("\\{{1}[\\w\\s.,:\"T\\-А-я]+\\}{1}").matcher(data);
        String group;
        while (matcher.find()) {
            group = matcher.group();
            Rate rate = new Rate(currency);
            rate.setDate(Util.getValueByRegex(group, "\"Date\":\\s*", "[\\\"\\-\\w\\-.:]+",1));
            rate.setScale(currency.getDefaultScale());
            rate.setRateSell(Util.getValueByRegex(group, "\"Cur_OfficialRate\":\\s*", "[\\d.]+",1));
            rate.setRateBuy(rate.getRateSell());

            rates.add(rate);
        }
    }

}
