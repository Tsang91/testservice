package de.pandawan;

import de.pandawan.EncryptionService.CustomKeyGenerator;
import de.pandawan.PasswordGeneratorService.*;


public class Main {

    public static void main(String[] args) {
	// write your code here
        ICharSetCreator creator = new CharSetCreatorImpl();
        IPasswordGenerator generator = new PasswordGeneratorImpl(20, creator, CharSetType.Alphanumeric);
        String pwString = generator.generatePassword();
        System.out.println(pwString);
        System.out.println(new CustomKeyGenerator().generateKey(16).getKeyArray());
    }
}
