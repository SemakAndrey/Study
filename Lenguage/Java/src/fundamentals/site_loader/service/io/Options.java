package fundamentals.site_loader.service.io;

import fundamentals.site_loader.entity.Currencies;
import fundamentals.site_loader.service.loaders.*;
import fundamentals.site_loader.service.loaders.core.Loader;
import fundamentals.site_loader.util.DateManagerUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Options {

    private int bank = 0;
    private Loader[] loaders;
    private String fileName;
    private Date start;
    private Date end;
    private Currencies currency;

    public void setOptions(String[] args){

        requestFromUserData(true, true);
        setLoaders();
        setDateRange(args);

    }

    public void requestFromUserData(boolean needBank, boolean needFile) {
        Scanner scanner = new Scanner(System.in);
        //read bank
        if (needBank) {
            System.out.print("Выберите банк(0 - all; 1 - НБРБ; 2 - Alfabank; 3 - Belarusbank; 4 - Belagroprombank): ");
            this.bank = scanner.nextInt();
        }

        //read currency
        do {
            this.currency = null;
            System.out.print("Выберите валюту(1 - USD; 2 - EUR; 3 - RUB): ");
            int selectVal = scanner.nextInt();
            switch (selectVal) {
                case 1:
                    this.currency = Currencies.USD;
                    break;
                case 2:
                    this.currency = Currencies.EUR;
                    break;
                case 3:
                    this.currency = Currencies.RUB;
                    break;
                default:
                    System.out.println("Выберите корректное значение валюты!!!");
                    break;
            }
        } while (this.currency == null);

        //read file
        if (needFile && this.bank != 0) {
            System.out.print("Введите имя файла: ");
            this.fileName = "./" + scanner.next();
        }
    }

    private void setLoaders() {

        this.loaders = new Loader[this.bank == 0 ? 4 : 1];

        switch (this.bank) {
            case 0:
                this.loaders[0] = new NBRBLoader();
                this.loaders[1] = new AlfaLoader();
                this.loaders[2] = new BelarusLoader();
                this.loaders[3] = new BelAgroPromLoader();
                break;
            case 2:
                this.loaders[0] = new AlfaLoader();
                break;
            case 3:
                this.loaders[0] = new BelarusLoader();
                break;
            case 4:
                this.loaders[0] = new BelAgroPromLoader();
                break;
            case 1:
            default:
                this.loaders[0] = new NBRBLoader();
                break;
        }
    }

    private void setDateRange(String[] args) {

        if (args.length == 0 || args[0].isBlank()) {
            this.start = new Date();
            return;
        }
        boolean includeBorder = false;
        String param = args[0];
        Pattern pattern = Pattern.compile("включительно");
        Matcher matcher = pattern.matcher(param);
        if (matcher.find()) {
            includeBorder = true;
        }
        if (args.length > 1) {
            matcher = pattern.matcher(args[1]);
            if (matcher.find()) {
                includeBorder = true;
            }
        }

        //22.08.2020
        String[] values = param.split("[,-]");
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.start = simpleFormat.parse(values[0]);
            if (!includeBorder) {
                this.start = DateManagerUtil.addDays(this.start, 1);
            }
        } catch (ParseException e) {
            this.start = new Date();
        }

        try {
            this.end = simpleFormat.parse(values[1]);
            if (!includeBorder) {
                this.end = DateManagerUtil.addDays(this.end, -1);
            }
        } catch (IndexOutOfBoundsException | ParseException e) {
            this.end = null;
        }

    }

    public Loader[] getLoaders() {
        return loaders;
    }

    public String getFileName() {
        return this.fileName;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public Currencies getCurrency() {
        return currency;
    }
}
