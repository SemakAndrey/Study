package fundamentals.site_loader.service.loaders;

import fundamentals.site_loader.entity.Currencies;
import fundamentals.site_loader.entity.Rate;
import fundamentals.site_loader.service.loaders.core.Loader;
import fundamentals.site_loader.service.mappers.AlfaMapper;
import fundamentals.site_loader.util.DateManagerUtil;

import java.util.Date;
import java.util.Set;

public class AlfaLoader extends Loader {

    public AlfaLoader() {
        super("Alfa-bank", "https://developerhub.alfabank.by:8273/partner/1.0.0/public", new AlfaMapper());
    }

    @Override
    public Rate load(Currencies currency) {
       return load(currency, "/rates", 1);
    }

    @Override
    public Rate load(Currencies currency, Date date) {
        String option = "/nationalRates?currencyCode=" + currency.getCode() + "&date=" + new DateManagerUtil(date).getDateFormat(this.getName());
        return load(currency, option, 2);
    }

    @Override
    public Set<Rate> load(Currencies currency, Date from, Date to) {
        System.out.println("Вы не можете выполнить данный запрос в текущем банке");
        return null;
    }

}
