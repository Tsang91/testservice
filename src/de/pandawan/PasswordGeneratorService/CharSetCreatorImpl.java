package de.pandawan.PasswordGeneratorService;

/**
 * Created by vuong on 23.03.16.
 */
public class CharSetCreatorImpl implements ICharSetCreator {
    @Override
    public String getCharSet(CharSetType type) {
        String output;
        CharSet charSet = new CharSet();
        switch (type)
        {
            case AlphabeticLower:
                output = charSet.createLowerCharSet();
                break;
            case AlphabeticUpper:
                output = charSet.createUpperCharSet();
                break;
            case Alphabetic:
                output = charSet.createLowerCharSet() + charSet.createUpperCharSet();
                break;
            case Numeric:
                output = charSet.createNumCharSet();
                break;
            case AlphanumericLower:
                output = charSet.createLowerCharSet() + charSet.createNumCharSet();
                break;
            case AlphanumericUpper:
                output = charSet.createUpperCharSet() + charSet.createNumCharSet();
                break;
            case Alphanumeric:
                output = charSet.createLowerCharSet() + charSet.createUpperCharSet()+
                        charSet.createNumCharSet();
                break;
            default:
                output = "";
                break;
        }
        return output;
    }
}
