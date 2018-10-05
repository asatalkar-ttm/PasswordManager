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

    public void printRecords(List<Credentials> credentials) {
        for(Credentials credential : credentials) {
            System.out.println("======================================================");
            System.out.println("Name : " + credential.getName());
            System.out.println("URL : " + credential.getUrl());
            System.out.println("Username : " + credential.getUsername());
        }
    }

    public void find (List<Credentials> credentials) {
        Credentials singleCredential;
        Scanner scanner = new Scanner(System.in);
        String find = null;
        System.out.println("What are you looking for ?");
        System.out.println("1. Name");
        System.out.println("2. URL");
        System.out.println("3. username");
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                scanner.nextLine();
                System.out.println("Enter name to find : ");
                find = scanner.nextLine();
                System.out.println("Looking for : " + find);
                for (int i = 0; i < credentials.size(); i++) {
                    singleCredential = credentials.get(i);
                    if (singleCredential.name.toLowerCase().contains(find.toLowerCase())) {
                        System.out.println("======================================================");
                        System.out.println("Element found at index : " + i);
                        System.out.println("Name : " + singleCredential.getName());
                        System.out.println("URL : " + singleCredential.getUrl());
                        System.out.println("Username : " + singleCredential.getUsername());
                    }
                }
            break;
            case 2:
                scanner.nextLine();
                System.out.println("Enter url to find : ");
                find = scanner.nextLine();
                System.out.println("Looking for : " + find);
                for (int i = 0; i < credentials.size(); i++) {
                    singleCredential = credentials.get(i);
                    if (singleCredential.url.toLowerCase().contains(find.toLowerCase())) {
                        System.out.println("======================================================");
                        System.out.println("Element found at index : " + i);
                        System.out.println("Name : " + singleCredential.getName());
                        System.out.println("URL : " + singleCredential.getUrl());
                        System.out.println("Username : " + singleCredential.getUsername());
                    }
                }
            break;
            case 3:
                scanner.nextLine();
                System.out.println("Enter username to find : ");
                find = scanner.nextLine();
                System.out.println("Looking for : " + find);
                for (int i = 0; i < credentials.size(); i++) {
                    singleCredential = credentials.get(i);
                    if (singleCredential.username.toLowerCase().contains(find.toLowerCase())) {
                        System.out.println("======================================================");
                        System.out.println("Element found at index : " + i);
                        System.out.println("Name : " + singleCredential.getName());
                        System.out.println("URL : " + singleCredential.getUrl());
                        System.out.println("Username : " + singleCredential.getUsername());
                    }
                }
            break;
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
