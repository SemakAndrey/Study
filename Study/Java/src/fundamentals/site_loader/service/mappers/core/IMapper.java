package fundamentals.site_loader.service.mappers.core;

import fundamentals.site_loader.entity.Currencies;
import fundamentals.site_loader.entity.Rate;

import java.util.Set;

public interface IMapper {

    void rateMapping(String data, Rate rate);
    void rateMappingDate(String data, Rate rate);
    void rateMappingRange(String data, Set<Rate> rate, Currencies currency);

}
