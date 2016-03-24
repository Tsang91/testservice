package de.pandawan.EncryptionService;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vuong on 24.03.16.
 */
public class IEncrypterTest {

    @Test
    public void testReturnValueIsNotNull() throws Exception {
        //arrange
        String key = "Test!";
        IEncrypter encrypter = new EncrypterImpl(key);

        //act
        byte[] encrypted = encrypter.encrypt();

        //assert
        Assert.assertTrue("Encrypted output shouldn't be null", encrypted != null);
    }

    @Test
    public void testReturnValueIsNotEmpty() throws Exception{
        //arrange
        String key = "Test!";
        IEncrypter encrypter = new EncrypterImpl(key);

        //act
        byte[] encrypted = encrypter.encrypt();

        //assert
        Assert.assertTrue("Encrypted output shouldn't be empty", encrypted.length >= 0);
    }


}