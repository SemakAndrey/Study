package fundamentals.site_loader.service;

import fundamentals.site_loader.entity.Currencies;
import fundamentals.site_loader.entity.Rate;
import fundamentals.site_loader.service.loaders.core.Loader;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BankRates {

    private Loader loader;
    private Rate rate;
    private Set<Rate> ratesInRange;

    public BankRates(Loader loader) {
        this.loader = loader;
        this.ratesInRange = new HashSet<>();
    }

    public void loadBankRate(Currencies currency) {
        this.rate = loader.load(currency);
    }

    public void loadBankRate(Currencies currency, Date date) {
        this.rate = loader.load(currency,date);
    }

    public void loadBankRate(Currencies currency, Date dateFrom, Date dateTo) {
        this.ratesInRange = loader.load(currency, dateFrom, dateTo);
    }

    public Loader getLoader() {
        return loader;
    }

    public Rate getRate() {
        return rate;
    }

    public void printRate() {
        printRate(this.rate);
    }

    private void printRate(Rate value) {
        System.out.print("Buy rate: " + value.getRateBuy() + "; ");
        System.out.println("Sell rate: " + value.getRateSell());
    }

    public void printBankName() {
        System.out.println("Bank " + loader.getName() + ": ");
    }

    public void printRates() {

        if (ratesInRange == null) {
            return;
        }

        for (Rate rateInRange : ratesInRange) {
            System.out.print(rateInRange.getDate() + " - ");
            printRate(rateInRange);
        }
    }

}
