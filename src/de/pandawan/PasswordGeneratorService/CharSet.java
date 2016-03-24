package de.pandawan.PasswordGeneratorService;

/**
 * Created by vuong on 23.03.16.
 */
public class CharSet {
    public String createLowerCharSet(){
        return "abcdefghijklmnopqrstuvwxyz";
    }
    public String createUpperCharSet(){
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
    public String createNumCharSet() {
        return "01234556789";
    }
}