package de.pandawan.EncryptionService;

/**
 * Created by vuong on 24.03.16.
 */
public interface IEncrypter {
    public byte[] encrypt(String toEncrypt) throws Exception;
}
