package jet_brains_academy.encrypt_decrypt.service.decryptors;

import jet_brains_academy.encrypt_decrypt.service.decryptors.core.IDecryptor;

public class ShiftDecrypt implements IDecryptor {

    @Override
    public String decrypt(String data, int key) {
        StringBuilder sb = new StringBuilder();
        int next;
        for (char ch : data.toCharArray()) {
            if (Character.isLetter(ch)) {
                next = ch - key;
                if (Character.isLowerCase(ch)) {
                    next = next < 97 ? (26 + next) : next;
                } else if (Character.isUpperCase(ch)) {
                    next = next < 65 ? (26 + next): next;
                }
                sb.append((char) next);
                continue;
            }
            sb.append(ch);
        }

        return sb.toString();
    }
}
