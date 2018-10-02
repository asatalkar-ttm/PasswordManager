package convert;

public class Credentials {

    public String name;
    public String url;
    public String username;
    public String password;

    public Credentials(){}

    public Credentials (String name, String url, String username, String password) {
        this.name = name;
        this.url = url;
        this.username = username;
        this.password = password;
    }
}
