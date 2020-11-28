package jet_brains_academy.encrypt_decrypt;

import jet_brains_academy.encrypt_decrypt.entity.Data;
import jet_brains_academy.encrypt_decrypt.service.Worker;

public class Main {

    public static void main(String[] args) {

        Data data = new Data(args);
        new Worker(data).work();

    }
}

