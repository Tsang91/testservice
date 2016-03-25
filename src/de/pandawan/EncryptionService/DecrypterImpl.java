package de.pandawan.EncryptionService;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * Created by vuong on 25.03.16.
 */
public class DecrypterImpl implements IDecrypter {
    private byte[] encryptionKey;

    public DecrypterImpl(CustomKey key){
        this.encryptionKey = key.getKeyArray();
    }

    @Override
    public String decrypt(byte[] toDecrypted) throws Exception{
        Key aesKey = new SecretKeySpec(encryptionKey, "AES");
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        String decrypted = new String(cipher.doFinal(toDecrypted));
        return decrypted;
    }
}
