package de.pandawan.EncryptionService;

/**
 * Created by vuong on 24.03.16.
 */
public class EncrypterImpl implements IEncrypter {
    private byte[] encryptionKey;

    public EncrypterImpl(String key){
        this.encryptionKey = key.getBytes();
    }

    @Override
    public byte[] encrypt() {
        return new byte[2];
    }
}
