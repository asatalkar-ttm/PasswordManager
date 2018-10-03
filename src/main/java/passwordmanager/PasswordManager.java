package passwordmanager;

import convert.Csv;
import convert.Jsonify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PasswordManager {

    private static final String FILEPATH = System.getProperty("user.dir") + File.separator + "Chrome Passwords.csv";

    public static int getNumberOfLines() {
        BufferedReader reader = null;
        int lines = 0;
        try {
            reader = new BufferedReader(new FileReader(FILEPATH));
            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return lines;
    }

    public void printRecords(Credentials credentials) {
        System.out.println("======================================================");
        System.out.println("Name : " + credentials.name);
        System.out.println("URL : " + credentials.url);
        System.out.println("Username : " + credentials.username);
//        System.out.println("Password : " + credentials.password);
    }

    public static void main(String[] args) {

        Credentials[] credentials = new Credentials[getNumberOfLines()];
        Csv csv = new Csv();
        Jsonify jsonify = new Jsonify();
        try {
            credentials = csv.ReadFromCSV(credentials, FILEPATH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < credentials.length; i++) {
            jsonify.ConvertToJson(credentials[i]);
        }
        System.out.println("Total number of records : " + getNumberOfLines());
    }
}