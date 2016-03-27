package de.pandawan.MySqlDatabaseService;

/**
 * Created by vuong on 27.03.16.
 */
public class LoginToken {
    private String url;
    private String user;
    private String password;

    public LoginToken(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
