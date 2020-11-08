package fundamentals.site_loader.service.loaders;

import fundamentals.site_loader.entity.Rate;
import fundamentals.site_loader.entity.Currencies;
import fundamentals.site_loader.service.loaders.core.Loader;
import fundamentals.site_loader.service.mappers.NBRBMapper;
import fundamentals.site_loader.util.DateManagerUtil;

import java.util.Date;
import java.util.Set;

public class NBRBLoader extends Loader {

    public NBRBLoader() {
        super("NBRB", "https://www.nbrb.by/api/exrates/rates", new NBRBMapper());
    }

    @Override
    public Rate load(Currencies currency) {
        return load(currency, "/" + currency.getId(), 1);
    }

    @Override
    public Rate load(Currencies currency, Date date) {
        return load(currency,"?ondate=" + new DateManagerUtil(date).getDateFormat(this.getName()) + "&periodicity=0", 2);
    }

    @Override
    public Set<Rate> load(Currencies currency, Date from, Date to) {
       return load(currency,"/dynamics/" + currency.getId() +
                                   "?startdate=" + new DateManagerUtil(from).getDateFormat(this.getName()) +
                                   "&enddate=" + new DateManagerUtil(to).getDateFormat(this.getName()));
    }

}
