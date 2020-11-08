package fundamentals.site_loader.service.loaders;

import fundamentals.site_loader.entity.Currencies;
import fundamentals.site_loader.entity.Rate;
import fundamentals.site_loader.service.loaders.core.Loader;
import fundamentals.site_loader.service.mappers.BelAgroPromMapper;
import fundamentals.site_loader.util.DateManagerUtil;

import java.util.Date;
import java.util.Set;

public class BelAgroPromLoader extends Loader {

    public BelAgroPromLoader() {
        super("Belagroprombank", "https://belapb.by/CashExRatesDaily.php", new BelAgroPromMapper());
    }

    @Override
    public Rate load(Currencies currencies) {
       return load(currencies, "", 1);
    }

    @Override
    public Rate load(Currencies currencies, Date date) {
        return load(currencies, "?ondate=" + new DateManagerUtil(date).getDateFormat(this.getName()), 2);
    }

    @Override
    public Set<Rate> load(Currencies currencies, Date from, Date to) {
        return null;
    }
}
