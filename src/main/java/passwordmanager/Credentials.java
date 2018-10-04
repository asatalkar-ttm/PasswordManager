package passwordmanager;

import arista.Encryption;

import java.util.List;
import java.util.Scanner;

public class Credentials {

    public String name;
    public String url;
    public String username;
    public String password;

    public Credentials (){}

    public Credentials (String name, String url, String username, String password) {
        this.name = name;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static void printRecords(List<Credentials> credentials) {
        for(Credentials credential : credentials) {
            System.out.println("======================================================");
            System.out.println("Name : " + credential.getName());
            System.out.println("URL : " + credential.getUrl());
            System.out.println("Username : " + credential.getUsername());
        }
    }

    public void find (List<Credentials> credentials) {
        System.out.println("Looking for : sso.trinet.com");
        Credentials singleCredential;
        for (int i = 0; i < credentials.size(); i++) {
            singleCredential = credentials.get(i);
            if (singleCredential.name.equals("sso.trinet.com")) {
                System.out.println("Element found");
                System.out.println("Name : " + singleCredential.getName());
                System.out.println("URL : " + singleCredential.getUrl());
                System.out.println("Username : " + singleCredential.getUsername());
            }
        }
    }

    public List<Credentials> addCredential (List<Credentials> credentials) {
        Encryption encryption = new Encryption();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = scanner.nextLine();
        System.out.println("Enter URL : ");
        String url = scanner.nextLine();
        System.out.println("Enter User Name : ");
        String username = scanner.nextLine();
        System.out.println("Enter Password : ");
        String password = null;
        try {
            password = encryption.encrypt(scanner.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Credentials c = new Credentials(name,url,username,password);
        credentials.add(c);
        return credentials;
    }
}
