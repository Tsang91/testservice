package de.pandawan.EncryptionService;

/**
 * Created by vuong on 24.03.16.
 */
public class EncrypterImpl implements IEncrypter {
    private byte[] encryptionKey;

    public EncrypterImpl(CustomKey key){
        this.encryptionKey = key.getKeyArray();
    }

    @Override
    public byte[] encrypt() {
        return new byte[2];
    }
}
