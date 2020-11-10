package fundamentals.site_loader.service.loaders.core;

import fundamentals.site_loader.entity.Currencies;
import fundamentals.site_loader.entity.Rate;
import fundamentals.site_loader.service.mappers.core.IMapper;
import fundamentals.site_loader.util.ConnectionHandler;

import java.util.*;

public abstract class Loader {

    private final String name;
    protected String url;
    protected final IMapper iMapper;

    public Loader(String name, String url, IMapper iMapper) {
        this.name = name;
        this.url = url;
        this.iMapper = iMapper;
    }

    /**
     * The method get information about currencies rates
     * @param currency value from enum
     * @param option - param in requesting url
     * @param typeMapping - selector Mapping method(1 - rateMapping, 2 - rateMappingDate)
     * @return Rate of currency
     */
    protected Rate load(Currencies currency, String option, int typeMapping) {

        Rate rate = new Rate(currency);
        String data = ConnectionHandler.getDataFromSource(this.url + option);
        if (!data.isBlank()) {
            if (typeMapping == 2) {
                this.iMapper.rateMappingDate(data, rate);
            } else {
                this.iMapper.rateMapping(data, rate);
            }
        }
        return rate;
    }

    protected Set<Rate> load(Currencies currency, String option) {

        Set<Rate> rates = new TreeSet<>((o1, o2) -> o1.getDate().compareTo(o2.getDate()));

        String data = ConnectionHandler.getDataFromSource(this.url + option);
        if (!data.isBlank()) {
            this.iMapper.rateMappingRange(data, rates, currency);
        }
        return rates;
    }

    public abstract Rate load(Currencies currency);

    public abstract Rate load(Currencies currency, Date date);

    public abstract Set<Rate> load(Currencies currency, Date from, Date to);

    public String getName() {
        return this.name;
    }


}
