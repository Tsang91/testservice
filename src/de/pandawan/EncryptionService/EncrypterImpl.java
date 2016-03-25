package de.pandawan.EncryptionService;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * Created by vuong on 24.03.16.
 */
public class EncrypterImpl implements IEncrypter {
    private byte[] encryptionKey;

    public EncrypterImpl(CustomKey key){
        this.encryptionKey = key.getKeyArray();
    }

    @Override
    public byte[] encrypt(String toEncrypt) throws Exception{
        Key aesKey = new SecretKeySpec(encryptionKey, "AES");
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encrypted = cipher.doFinal(toEncrypt.getBytes());

        return encrypted;
    }
}
