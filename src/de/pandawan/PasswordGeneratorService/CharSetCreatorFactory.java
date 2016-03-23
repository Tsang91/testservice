package de.pandawan.PasswordGeneratorService;

/**
 * Created by vuong on 23.03.16.
 */
public class CharSetCreatorFactory implements ICharSetCreator {
    @Override
    public String getCharSet(CharSetType type) {
        String charSet;
        AlphabeticCharSet alphabeticCharSet = new AlphabeticCharSet();
        NumericCharSet numericCharSet = new NumericCharSet();
        switch (type)
        {
            case AlphabeticLower:
                charSet = alphabeticCharSet.createLowerCharSet();
                break;
            case AlphabeticUpper:
                charSet = alphabeticCharSet.createUpperCharSet();
                break;
            case Alphabetic:
                charSet = alphabeticCharSet.createLowerCharSet() + alphabeticCharSet.createUpperCharSet();
                break;
            case Numeric:
                charSet = numericCharSet.createCharSet();
                break;
            case AlphanumericLower:
                charSet = alphabeticCharSet.createLowerCharSet() + numericCharSet.createCharSet();
                break;
            case AlphanumericUpper:
                charSet = alphabeticCharSet.createUpperCharSet() + numericCharSet.createCharSet();
                break;
            case Alphanumeric:
                charSet = alphabeticCharSet.createLowerCharSet() + alphabeticCharSet.createUpperCharSet()+
                        numericCharSet.createCharSet();
                break;
            default:
                charSet = "";
                break;
        }
        return charSet;
    }
}
