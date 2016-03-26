package de.pandawan.EncryptionService;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vuong on 25.03.16.
 */
public class IDecrypterTest {

    @Test
    public void testDecrypt() throws Exception {
        //arrange
        String stringKey = "Testkey!TestKey!";
        String result = "Test!";
        byte[] encrypted = new byte[]{ -122, -36, 126, -91, -125, -121, -23, 64, 52, -92, -22, 121, -7, 79, 22, 111};

        CustomKey key = new CustomKey();
        key.setKeyArray(stringKey.getBytes());
        IDecrypter decrypter = new DecrypterImpl(key);

        //act
        String output = decrypter.decrypt(encrypted);

        //assert
        Assert.assertTrue(String.format("String should be %1$s", result), output.matches(result));
    }
}