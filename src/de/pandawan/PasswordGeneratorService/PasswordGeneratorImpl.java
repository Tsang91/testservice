package de.pandawan.PasswordGeneratorService;

import java.util.Random;

/**
 * Created by vngo on 22.03.2016.
 */
public class PasswordGeneratorImpl implements IPasswordGenerator {
    private String charSet;
    private int stringLenght;

    //create dummy constructer
    public PasswordGeneratorImpl(int stringLenght){
        this.stringLenght = stringLenght;
        charSet ="abcd";
    }

    public PasswordGeneratorImpl(int stringLenght, String charSet){
        this.stringLenght = stringLenght;
        this.charSet = charSet;
    }

    public PasswordGeneratorImpl(int stringLenght, ICharSetCreator creator, CharSetType type){
        this.stringLenght = stringLenght;
        this.charSet = creator.getCharSet(type);
    }

    @Override
    public String generatePassword(){
        StringBuilder builder = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < this.stringLenght; ++i)
            builder.append(charSet.charAt(
                random.nextInt(charSet.length()))
            );

        return builder.toString();
    }

}
