package fundamentals.site_loader.service.io;

import fundamentals.site_loader.service.BankRates;

import java.io.*;
import java.util.Scanner;

public class FileManager {

    private File file;

    public FileManager(String fileName) {

        this.file = new File("./" + fileName);

    }

    public void save(BankRates bankRates) throws IllegalArgumentException {

        if (bankRates.getRate() == null) {
            System.out.println("You cannot write empty exchange information!!!");
            return;
        }

        try {

            int perm = permissions(bankRates.getLoader().getName());
            boolean append = this.file.exists() && perm == 1;

            ObjectOutputStream fileOutputStream = new ObjectOutputStream(new FileOutputStream(this.file, append));
            if (!append) {
                fileOutputStream.writeObject(bankRates.getLoader().getName());
            }

            fileOutputStream.writeObject(bankRates.getRate().getCurrency().getCode());
            fileOutputStream.writeObject(bankRates.getRate().getDate());
            fileOutputStream.writeDouble(bankRates.getRate().getRateBuy());
            fileOutputStream.writeDouble(bankRates.getRate().getRateSell());
            fileOutputStream.close();

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private int permissions(String name) throws IOException, ClassNotFoundException, IllegalArgumentException {

        if (!this.file.exists()) {
            return 1;
        }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.file));
        String val = (String) ois.readObject();
        for (int i = 0; !val.equals(name) && i < 5; i++) {
            System.out.println("Указанное имя файла хранит данные другого банка. Введите имя файла:");
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.next();
            this.file = new File("./" + fileName);
            ois = new ObjectInputStream(new FileInputStream(this.file));
            val = (String) ois.readObject();
        }
        if (!val.equals(name)) {
            throw new IllegalArgumentException("You cannot write data in file with rates of other bank!");
        }

        return 1;
    }

}
