package fundamentals.site_loader.service.loaders;

import fundamentals.site_loader.entity.Currencies;
import fundamentals.site_loader.entity.Rate;
import fundamentals.site_loader.service.loaders.core.Loader;
import fundamentals.site_loader.service.mappers.BelarusMapper;

import java.util.Date;
import java.util.Set;

public class BelarusLoader extends Loader {

    public BelarusLoader() {
        super("Belarusbank", "https://belarusbank.by/api/kursExchange", new BelarusMapper());
    }

    @Override
    public Rate load(Currencies currencies) {
       return load(currencies, "", 1);
    }

    @Override
    public Rate load(Currencies currencies, Date date) {
        System.out.println("Вы не можете выполнить данный запрос в текущем банке");
        return new Rate(Currencies.BYN);
    }

    @Override
    public Set<Rate> load(Currencies currencies, Date from, Date to) {
        System.out.println("Вы не можете выполнить данный запрос в текущем банке");
        return null;
    }

}
