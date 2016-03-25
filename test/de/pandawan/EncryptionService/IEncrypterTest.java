package de.pandawan.EncryptionService;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by vuong on 24.03.16.
 */
public class IEncrypterTest {

    @Test
    public void testReturnValueIsNotNull() throws Exception {
        //arrange
        CustomKey key = new CustomKeyGenerator().generateKey(16);
        IEncrypter encrypter = new EncrypterImpl(key);

        //act
        byte[] encrypted = encrypter.encrypt("Test");

        //assert
        Assert.assertTrue("Encrypted output shouldn't be null", encrypted != null);
    }

    @Test
    public void testReturnValueIsNotEmpty() throws Exception{
        //arrange
        CustomKey key = new CustomKeyGenerator().generateKey(16);
        IEncrypter encrypter = new EncrypterImpl(key);

        //act
        byte[] encrypted = encrypter.encrypt("Test");

        //assert
        Assert.assertTrue("Encrypted output shouldn't be empty", encrypted.length >= 0);
    }

    @Test
    public void testEncryptString() throws Exception{
        //arrange
        String stringKey = "Testkey!TestKey!";
        String text = "Test!";
        byte[] result = new byte[]{ -122, -36, 126, -91, -125, -121, -23, 64, 52, -92, -22, 121, -7, 79, 22, 111};
        CustomKey key = new CustomKey();
        key.setKeyArray(stringKey.getBytes());
        IEncrypter encrypter = new EncrypterImpl(key);

        //act
        byte[] encrypted = encrypter.encrypt(text);

        //assert
        Assert.assertTrue("encrypted should match result", Arrays.equals(encrypted, result));
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