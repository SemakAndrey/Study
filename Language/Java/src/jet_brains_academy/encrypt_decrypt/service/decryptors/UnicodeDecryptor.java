package jet_brains_academy.encrypt_decrypt.service.decryptors;

import jet_brains_academy.encrypt_decrypt.service.decryptors.core.IDecryptor;

public class UnicodeDecryptor implements IDecryptor {

    @Override
    public String decrypt(String data, int key) {

        StringBuilder sb = new StringBuilder();

        for (char c : data.toCharArray()) {
            int next = (c - key);
            sb.append((char) next);
        }

        return sb.toString();

    }

}
