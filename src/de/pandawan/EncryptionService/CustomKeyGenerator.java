package de.pandawan.EncryptionService;

import java.security.SecureRandom;

/**
 * Created by vuong on 25.03.16.
 */
public class CustomKeyGenerator {
    public CustomKey generateKey(int keySize) {
        byte[] keyArray = new byte[keySize];
        new SecureRandom().nextBytes(keyArray);

        CustomKey key = new CustomKey();
        key.setKeyArray(keyArray);
        return key;
    }
}
//    @Override
//    public String generatePassword(){
//        StringBuilder builder = new StringBuilder();
//        Random random = new Random();
//
//        for(int i = 0; i < this.stringLenght; ++i)
//            builder.append(charSet.charAt(
//                    random.nextInt(charSet.length()))
//            );
//
//        return builder.toString();
//    }