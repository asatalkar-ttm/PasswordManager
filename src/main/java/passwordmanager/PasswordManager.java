package passwordmanager;

import convert.Csv;
import convert.Jsonify;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PasswordManager {

    private static final String FILEPATH = System.getProperty("user.dir") + File.separator + "Chrome Passwords.csv";

    public static void main(String[] args) {
        List<Credentials> credentials = new ArrayList<Credentials>();
        Csv csv = new Csv();
        Jsonify jsonify = new Jsonify();
        try {
            credentials = csv.ReadFromCSV(credentials, FILEPATH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Credentials credential = new Credentials();
//
//        credentials = credential.addCredential(credentials);

//        String json = jsonify.convertToJson(credentials);

//        jsonify.printJson(json);
//        credential.printRecords(credentials);
        credential.find(credentials);


    }
}