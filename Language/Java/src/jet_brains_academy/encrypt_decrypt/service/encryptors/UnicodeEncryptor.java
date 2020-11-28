package jet_brains_academy.encrypt_decrypt.service.encryptors;

import jet_brains_academy.encrypt_decrypt.service.encryptors.core.IEncryptor;

public class UnicodeEncryptor implements IEncryptor {

    @Override
    public String encrypt(String data, int key) {

        StringBuilder sb = new StringBuilder();

        for (char c : data.toCharArray()) {
            int next = (c + key);
            sb.append((char) next);
        }

        return sb.toString();

    }

}
