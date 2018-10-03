package passwordmanager;

import convert.Csv;
import convert.Jsonify;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PasswordManager {

    private static final String FILEPATH = System.getProperty("user.dir") + File.separator + "Chrome Passwords.csv";

    public static void printRecords(List<Credentials> credentials) {
        for(Credentials credential : credentials) {
            System.out.println("======================================================");
            System.out.println("Name : " + credential.getName());
            System.out.println("URL : " + credential.getUrl());
            System.out.println("Username : " + credential.getUsername());
            System.out.println("Password : " + credential.getPassword());
        }
    }

    public static void main(String[] args) {
        List<Credentials> credentials = new ArrayList<Credentials>();
        Csv csv = new Csv();
        Jsonify jsonify = new Jsonify();
        try {
            credentials = csv.ReadFromCSV(credentials, FILEPATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        jsonify.ConvertToJson(credentials);

        printRecords(credentials);
    }
}