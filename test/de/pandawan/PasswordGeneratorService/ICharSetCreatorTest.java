package de.pandawan.PasswordGeneratorService;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vuong on 23.03.16.
 */
public class ICharSetCreatorTest {

    @Test
    public void testReturnValueIsNotNullAlphabeticCharSet() throws Exception{
        //arrange
        ICharSetCreator creator = new CharSetCreatorImpl();

        //act
        String charSet = creator.getCharSet(CharSetType.Alphabetic);

        //assert
        Assert.assertTrue("CharSet shouldn't be null", charSet != null);
    }

    @Test
    public void testReturnValueTypeAlphabeticCharSet() throws Exception {
        //arrange
        ICharSetCreator creator = new CharSetCreatorImpl();

        //act
        String charSet = creator.getCharSet(CharSetType.Alphabetic);

        //assert
        Assert.assertTrue("CharSet should have type String", charSet instanceof String);
    }

    @Test
    public void testReturnValueIsNotEmptyAlphabeticCharSet() throws Exception{
        //arrange
        ICharSetCreator creator = new CharSetCreatorImpl();

        //act
        String charSet = creator.getCharSet(CharSetType.Alphabetic);

        //assert
        Assert.assertTrue("CharSet shouldn't be empty", !charSet.isEmpty());
    }

    @Test
    public void testReturnValueIsAlphabeticCharSetLowerCase() throws Exception{
        //arrange
        ICharSetCreator creator = new CharSetCreatorImpl();

        //act
        String charSet = creator.getCharSet(CharSetType.AlphabeticLower);

        //assert
        Assert.assertTrue("CharSet should inherit a-z", charSet.matches("^[a-z]+$"));
    }

    @Test
    public void testReturnValueIsAlphabeticCharSetUpperCase() throws Exception{
        //arrange
        ICharSetCreator creator = new CharSetCreatorImpl();

        //act
        String charSet = creator.getCharSet(CharSetType.AlphabeticUpper);

        //assert
        Assert.assertTrue("CharSet should inherit A-Z", charSet.matches("^[A-Z]+$"));
    }

    @Test
    public void testReturnValueIsNumericCharSet() throws Exception{
        //arrange
        ICharSetCreator creator = new CharSetCreatorImpl();

        //act
        String charSet = creator.getCharSet(CharSetType.Numeric);

        //assert
        Assert.assertTrue("CharSet should inherit 0-9", charSet.matches("^[0-9]+$"));
    }

    @Test
    public void testReturnValueIsAlphabeticCharSet() throws Exception{
        //arrange
        ICharSetCreator creator = new CharSetCreatorImpl();

        //act
        String charSet = creator.getCharSet(CharSetType.Alphabetic);

        //assert
        Assert.assertTrue("CharSet should inherit A-z", charSet.matches("^[A-z]+$"));
    }

    @Test
    public void testReturnValueIsAlphanumericLowerCharSet() throws Exception {
        //arrange
        ICharSetCreator creator = new CharSetCreatorImpl();

        //act
        String charSet = creator.getCharSet(CharSetType.AlphanumericLower);

        //assert
        Assert.assertTrue("CharSet should inherit a-z and 0-9", charSet.matches("^[a-z0-9]+$"));
    }

    @Test
    public void testReturnValueIsAlphanumericUpperCharSet() throws Exception{
        //arrange
        ICharSetCreator creator = new CharSetCreatorImpl();

        //act
        String charSet = creator.getCharSet(CharSetType.AlphanumericUpper);

        //assert
        Assert.assertTrue("CharSet should inherit A-Z and 0-9 " + charSet, charSet.matches("^[A-Z0-9]+$"));
    }

    @Test
    public void testReturnValueIsAlphanumericCharSet() throws Exception{
        //arrange
        ICharSetCreator creator = new CharSetCreatorImpl();

        //act
        String charSet = creator.getCharSet(CharSetType.Alphanumeric);

        //assert
        Assert.assertTrue("CharSet should inherit all alphanumerics", charSet.matches("^[A-z0-9]+$"));
    }

    @Test
    public void testReturnValueIsInvalid() throws Exception{
        //arrange
        ICharSetCreator creator = new CharSetCreatorImpl();

        //act
        String charSet = creator.getCharSet(CharSetType.Invalid);

        //assert
        Assert.assertTrue("CharSet should be empty", charSet.isEmpty());
    }
}