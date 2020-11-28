package jet_brains_academy.encrypt_decrypt.service.encryptors;

import jet_brains_academy.encrypt_decrypt.service.encryptors.core.IEncryptor;

public class EncrypFabrica {

    public static IEncryptor getEncryptor(String algorithm) {

        switch (algorithm.toLowerCase()) {
            case "unicode":
                return new UnicodeEncryptor();
            case "shift":
                return new ShiftEncryptor();
            default:
                return null;
        }

    }

}
