package fundamentals.site_loader.entity;

import fundamentals.site_loader.util.Util;

import java.util.Date;

public class Rate {

    private Currencies currency;
    private Date date;
    private int scale;
    private double rateSell;
    private double rateBuy;

    public Rate(Currencies currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public double getRateSell() {
        return rateSell;
    }

    public double getRateBuy() {
        return rateBuy;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date) {
        this.date = Util.getDateValue(date);
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public void setScale(String scale) {
        this.scale = Util.getIntValue(scale);
    }

    public void setRateSell(String rateSell) {
        this.rateSell = Util.getDoubleValue(rateSell);
    }

    public void setRateBuy(double rateBuy) {
        this.rateBuy = rateBuy;
    }

    public void setRateBuy(String rateBuy) {
        this.rateBuy = Util.getDoubleValue(rateBuy);
    }

    @Override
    public String toString() {
        return "Rate information{" +
                "\n    id = " + currency.getId() +
                ",\n    date = " + date +
                ",\n    abbreviation = '" + currency.getAbbreviation() + '\'' +
                ",\n    scale = " + scale +
                ",\n    name = '" + currency.getRusName() + '\'' +
                ",\n    rateBuy = " + rateBuy +
                ",\n    rateSell = " + rateSell +
                "\n}";
    }

}
