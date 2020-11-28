package jet_brains_academy.encrypt_decrypt.service.encryptors;

import jet_brains_academy.encrypt_decrypt.service.encryptors.core.IEncryptor;

public class ShiftEncryptor implements IEncryptor{

    @Override
    public String encrypt(String data, int key) {

        StringBuilder sb = new StringBuilder();
        int next;
        for (char ch : data.toCharArray()) {
            if (Character.isLetter(ch)) {
                next = ch;
                if (Character.isLowerCase(ch)) {
                    next = (ch + key) > 122 ? 97 + (ch + key - 123) : (ch + key);
                } else if (Character.isUpperCase(ch)) {
                    next = (ch + key) > 90 ? 65 + (ch + key - 91) : (ch + key);
                }
                sb.append((char) next);
                continue;
            }
            sb.append(ch);
        }

        return sb.toString();
    }

}
