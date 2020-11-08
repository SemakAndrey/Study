package fundamentals.site_loader;

import fundamentals.site_loader.service.io.*;
import fundamentals.site_loader.service.BankRates;
import fundamentals.site_loader.service.loaders.core.Loader;

public class Main {
    /*
     * SiteLoader (indexOf, Exception, RegExp, паттерн шаблонный метод):
     *   !!!Внимание!!! при подключение к сайту, особенно НАЦБАНКА, может быть ошибка,
     *   это не ваша вина это может быть проблема с сайтом, скоростью его ответа или с недоступностью интернета.
     *   Вам необходимо скачать https://www.dropbox.com/s/3b8posn819795i8/siteloader.zip?dl=0
     *   данный архив содержит примеры кода которые вам необходимо использовать в своей работе.
     *   В классе SiteLoader реализовано подключение по переданному адресу, в случае проблем с соединением (эксепшеном)
     *   происходит попытка повторного подключения. Для реализации пунктов без * данные классы можно использовать как есть,
     *    в случае выполнения задач с * вы можете изменять, переписывать и писать собственные классы вместо моих.
     * 2. В классе NBRBLoader требуется дописать метод handle.
     *   При помощи данного метода в строке content вы дожны найти курс валюты
     *   имя которой передали в параметре currencyName. Почти обычный поиск строки currencyName
     *   по строке content (нельзя использовать регулярные выражения).
     * 3*. Написать новый класс наследника SiteLoader по примеру NBRBLoader для одного или нескольких банков
     *   (можно использовать регулярные выражения). Можете выбрать из (урлы для примера):
     * 	3.1. Альфа-банк (https://developerhub.alfabank.by:8273/partner/1.0.0/public/rates)
     * 	3.2. Беларусбанк (https://belarusbank.by/api/kursExchange)
     * 	3.3. БПС (https://www.bps-sberbank.by/page/currency-exchange-cards) \\https://www.bps-sberbank.by/rates/rates.json
     * 	3.4. Белагро (https://belapb.by/ExCardsDaily.php?ondate=11/22/2013)
     * 4*. Реализовать получение курса не только за сегодня но и за указанный день
     *   через аргумент к запускаемой программе. День может указываться в двух форматах:
     * 	4.1 Конкретная дата:
     * 		4.1.1 Пример: 22.08.2020
     * 	4.2 Диадазон дат:
     * 		4.2.1 Пример: 22.08.2020-01.09.2020 (включительно)
     * 		4.2.2 Пример: 22.08.2020,20.07.2018
     * 5. Реализовать сохранение полученного или полученных курсов в файл.
     *   При запуске программы дать возможно пользователю указывать путь к файлу для сохранения курса,
     *   иначе курс должен сохраняться рядом рядом с запускаемой программой.
     * 6*. Если по выбранному нами пути уже существуют сохранённые курсы необходимо дописать данные в существующий файл.
     *   Учтите что курсы валют должны быть сохранены в упорядоченными по дате.
     * 7**. Придумайте механизм защиты чтобы в файл нельзя было сохранить данные полученные от разных банков,
     *   в случае если пользователь указал адрес файла с курсами от другого банка необходимо дать возможность
     *   выбрать другой путь (5 раз). В случае превышения количества раз выдать ошибку
     *   и завершить работу программы с указанием спецефического кода выхода
     */

    public static void main(String[] args) {

        Options options = new Options();
        options.setOptions(args);

        for (Loader loader : options.getLoaders()) {

            BankRates bankRate = new BankRates(loader);
            System.out.println("-------------------------------------------------");
            bankRate.printBankName();

            System.out.println("1. " + options.getCurrency().name() + " rate at current moment:");
            bankRate.loadBankRate(options.getCurrency());
            bankRate.printRate();
            System.out.println("-----------------");

            System.out.println("2. " + options.getCurrency().name() + " rate on " + options.getStart().toString() + ":");
            bankRate.loadBankRate(options.getCurrency(), options.getStart());
            bankRate.printRate();
            System.out.println("-----------------");

            if (options.getEnd() != null) {
                System.out.println("3. " + options.getCurrency().name() + " range from " + options.getStart().toString() + " to " + options.getEnd().toString());
                bankRate.loadBankRate(options.getCurrency(), options.getStart(), options.getEnd());
                bankRate.printRates();
                System.out.println("-----------------");
            }

            if (options.getFileName() != null && !options.getFileName().isBlank()) {
                try {
                    FileManager fileManager = new FileManager(options.getFileName());
                    fileManager.save(bankRate);
                } catch (IllegalArgumentException e) {
                    System.exit(-3);
                }
            }
        }
    }
}
