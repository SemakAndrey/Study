package jet_brains_academy.encrypt_decrypt.service.decryptors;

import jet_brains_academy.encrypt_decrypt.service.decryptors.core.IDecryptor;

public class DecryptFabrica {

    public static IDecryptor getDecryptor(String algorithm) {
        switch (algorithm.toLowerCase()) {
            case "unicode":
                return new UnicodeDecryptor();
            case "shift":
                return new ShiftDecrypt();
            default:
                return null;
        }
    }

}
