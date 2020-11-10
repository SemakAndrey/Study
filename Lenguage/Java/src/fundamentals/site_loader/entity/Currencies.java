package fundamentals.site_loader.entity;

public enum Currencies {

    USD("145", 840, "USD", "Доллар США",        1),
    EUR("292", 978, "EUR", "Евро",              1),
    RUB("298", 643, "RUB", "Российский рубль",  100),
    BYN("933", 933, "BYN", "Белорусский рубль", 1);

    private String id;
    private int code;
    private String abbreviation;
    private String rusName;
    private int defaultScale;

    Currencies(String id, int code, String abbreviation, String rusName, int scale) {
        this.id = id;
        this.code = code;
        this.abbreviation = abbreviation;
        this.rusName = rusName;
        this.defaultScale = scale;
    }

    public String getId() {
        return this.id;
    }

    public int getCode() {
        return this.code;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getRusName() {
        return this.rusName;
    }

    public int getDefaultScale() {
        return defaultScale;
    }
}
