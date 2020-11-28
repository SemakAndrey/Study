package jet_brains_academy.encrypt_decrypt.service;

import jet_brains_academy.encrypt_decrypt.entity.Data;
import jet_brains_academy.encrypt_decrypt.service.decryptors.DecryptFabrica;
import jet_brains_academy.encrypt_decrypt.service.encryptors.EncrypFabrica;
import jet_brains_academy.encrypt_decrypt.utils.IOHandlerUtil;

public class Worker {

    private Data data;

    public Worker(Data data) {
        this.data = data;
    }

    public void work() {

        if ("enc".equals(this.data.getMode())) {
            doEncoding();
            write();
        } else if ("dec".equals(this.data.getMode())) {
            doDecoding();
            write();
        }


    }

    private void doEncoding() {

        String result = EncrypFabrica.getEncryptor(this.data.getAlg()).encrypt(this.data.getData(), this.data.getKey());
        this.data.setDataModify(result);

    }

    private void doDecoding() {

        String result = DecryptFabrica.getDecryptor(this.data.getAlg()).decrypt(this.data.getData(), this.data.getKey());
        this.data.setDataModify(result);

    }

    private void write() {

        if (this.data.getOut().isBlank()) {
            IOHandlerUtil.writeDataToConsole(this.data.getDataModify());
        } else {
            IOHandlerUtil.writeDataToFile(this.data.getOut(), this.data.getDataModify());
        }
    }

}
