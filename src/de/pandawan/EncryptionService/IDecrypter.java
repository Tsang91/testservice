package de.pandawan.EncryptionService;

/**
 * Created by vuong on 25.03.16.
 */
public interface IDecrypter {
    public String decrypt(byte[] toDecrypted) throws Exception;
}
