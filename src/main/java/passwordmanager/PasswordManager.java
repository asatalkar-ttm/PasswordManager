package passwordmanager;

import convert.Csv;
import convert.Jsonify;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordManager {

    private static final String FILEPATH = System.getProperty("user.dir") + File.separator + "Chrome Passwords.csv";

    public static void menu() {
        List<Credentials> credentials = new ArrayList<Credentials>();
        Credentials credential = new Credentials();
        Csv csv = new Csv();
        Jsonify jsonify = new Jsonify();
        Scanner scanner = new Scanner(System.in);
        String json = "";

        System.out.println("1. Import CSV");
        System.out.println("2. Display Credentials");
        System.out.println("3. Add Credentials");
        System.out.println("4. Convert to JSON");
        System.out.println("5. Print JSON");
        System.out.println("6. Find Credential");

        int input = scanner.nextInt();

        switch (input) {
            case 1: try {
                credentials = csv.ReadFromCSV(credentials, FILEPATH);
            } catch (Exception e) {
                e.printStackTrace();
            }
                break;
            case 2: credential.printRecords(credentials);
                break;
            case 3: credentials = credential.addCredential(credentials);
                break;
            case 4: json = jsonify.convertToJson(credentials);
                break;
            case 5: jsonify.printJson(json);
                break;
            case 6: credential.find(credentials);
                break;
        }
        scanner.close();
    }

    public static void main(String[] args) {
        List<Credentials> credentials = new ArrayList<Credentials>();
        Credentials credential = new Credentials();
        Csv csv = new Csv();
        Jsonify jsonify = new Jsonify();
        String json;

        // Convert CSV to Credentials Object
        try {
            credentials = csv.ReadFromCSV(credentials, FILEPATH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // print records
        credential.printRecords(credentials);

        // convert credentails to JSON format
        json = jsonify.convertToJson(credentials);

        // print JSON records
        jsonify.printJson(json);

        // find credentials
        credential.find(credentials);

//        // add credentials
//        credentials = credential.addCredential(credentials);
    }
}