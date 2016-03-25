package de.pandawan.PasswordGeneratorService;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vngo on 23.03.2016.
 */
public class IPasswordGeneratorTest {
    @Test
    public void testReturnValueIsNotNull() throws Exception{
        //arrange
        IPasswordGenerator passwordGenerator = new PasswordGeneratorImpl(0);

        //act
        String passwordString = passwordGenerator.generatePassword();

        //assert
        Assert.assertTrue("Should not be null!", passwordString != null);
    }

    @Test
    public void testReturnValueIsNotEmpty() throws Exception{
        //arrange
        IPasswordGenerator passwordGenerator = new PasswordGeneratorImpl(5);

        //act
        String passwordString = passwordGenerator.generatePassword();

        //assert
        Assert.assertTrue("Should not be empty String!", !passwordString.isEmpty());
    }

    @Test
    public void testReturnValueStringLength() throws Exception{
        //arrange
        int stringLength = 15;
        IPasswordGenerator passwordGenerator = new PasswordGeneratorImpl(stringLength);

        //act
        String passwordString = passwordGenerator.generatePassword();

        //assert
        Assert.assertEquals(
            String.format("String should have %1$d characters!", stringLength),
            stringLength,
            passwordString.length()
        );
    }

    @Test
    public void testAlphabeticCharSet() throws Exception{
        //arrange
        String charSet = "abcd";
        IPasswordGenerator passwordGenerator = new PasswordGeneratorImpl(10, charSet);

        //act
        String passwordString = passwordGenerator.generatePassword();

        //assert
        Assert.assertTrue(String.format("Should have chars %1$s", new StringBuilder(charSet).insert(1, ", ")),
            passwordString.matches(String.format("[%1$s]+", charSet)));
    }

    @Test
    public void testAlphabeticCase() throws Exception{
        //arrange
        String charSet = "aABcd";
        IPasswordGenerator passwordGenerator = new PasswordGeneratorImpl(10, charSet);

        //act
        String passwordString = passwordGenerator.generatePassword();

        //assert
        Assert.assertTrue(String.format("Should have chars %1$s", new StringBuilder(charSet).insert(1, ", ")),
            passwordString.matches(String.format("[%1$s]+", charSet)));
    }

    @Test
    public void testAlphanumericCharSet() throws Exception{
        //arrange
        String charSet = "ab34";
        IPasswordGenerator passwordGenerator = new PasswordGeneratorImpl(10, charSet);

        //act
        String passwordString = passwordGenerator.generatePassword();

        //assert
        Assert.assertTrue(String.format("Should have chars %1$s", new StringBuilder(charSet).insert(1, ", ")),
            passwordString.matches(String.format("[%1$s]+", charSet)));
    }

    @Test
    public void testGeneratePasswordWithCharSetCreator() throws Exception{
        //arrange
        int stringLength = 15;
        ICharSetCreator creator = new CharSetCreatorImpl();
        IPasswordGenerator passwordGenerator = new PasswordGeneratorImpl(
            stringLength, creator, CharSetType.Alphanumeric);

        //act
        String passwordString = passwordGenerator.generatePassword();

        //assert
        Assert.assertTrue("Shouldn't be empty", !passwordString.isEmpty());
        Assert.assertTrue(String.format("Should have a length of %1$s", stringLength),
                passwordString.length() == stringLength);
        Assert.assertTrue(String.format("Should have alphanumeric chars"),
                passwordString.matches("^[A-z0-9]+$"));
    }
}