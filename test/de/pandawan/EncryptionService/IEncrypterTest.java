package de.pandawan.EncryptionService;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vuong on 24.03.16.
 */
public class IEncrypterTest {

    @Test
    public void testReturnValueIsNotNull() throws NullPointerException {
        //arrange
        CustomKey key = new CustomKeyGenerator().generateKey(16);
        IEncrypter encrypter = new EncrypterImpl(key);

        //act
        byte[] encrypted = encrypter.encrypt();

        //assert
        Assert.assertTrue("Encrypted output shouldn't be null", encrypted != null);
    }

    @Test
    public void testReturnValueIsNotEmpty() throws Exception{
        //arrange
        CustomKey key = new CustomKeyGenerator().generateKey(16);
        IEncrypter encrypter = new EncrypterImpl(key);

        //act
        byte[] encrypted = encrypter.encrypt();

        //assert
        Assert.assertTrue("Encrypted output shouldn't be empty", encrypted.length >= 0);
    }

    @Test
    public void testCreateKeyIsNotEmpty() throws NullPointerException{
        //arrange
        CustomKeyGenerator keyGenerator = new CustomKeyGenerator();

        //act
        CustomKey key = keyGenerator.generateKey(16);

        //assert
        Assert.assertTrue("Key shouldn't be empty", key != null);
    }

    @Test
    public void testCreateKey16Byte() throws Exception{
        //arrange
        CustomKeyGenerator keyGenerator = new CustomKeyGenerator();

        //act
        CustomKey key = keyGenerator.generateKey(16);

        //assert
        Assert.assertTrue("Key should be 128bit/16byte key", key.getKeyArray().length == 16);
    }
}