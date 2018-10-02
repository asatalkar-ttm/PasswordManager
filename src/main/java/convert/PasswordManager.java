package convert;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;

public class PasswordManager {

    private static final String filePath = System.getProperty("user.dir");
    private GsonBuilder gsonBuilder;

    public PasswordManager() throws IllegalArgumentException {
        this.gsonBuilder = new GsonBuilder().setPrettyPrinting();
    }

    public void ReadFromCSV(String filepath) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(filepath));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            ConvertToJson(nextLine);
        }
    }

    private static void PrintCSV (String[] CSVArray) {
        System.out.println("================================================");
        System.out.println("Name : " + CSVArray[0]);
        System.out.println("URL : " + CSVArray[1]);
        System.out.println("Username : " + CSVArray[2]);
//            System.out.println("Password : " + CSVArray[3]);
    }

    public String ConvertToJson(String[] CSVArray) {

        // nextLine[] is an array of values from the line
        String name = CSVArray[0];
        String url = CSVArray[1];
        String username = CSVArray[2];
        String password = CSVArray[3];

        //Print CSV
//        PrintCSV(CSVArray);

        Credentials credentials = new Credentials(name,url,username,password);

        Gson gson = this.gsonBuilder.setPrettyPrinting().create();

        //Print JSON
        System.out.println(gson.toJson(credentials));

        return gson.toJson(credentials);
    }

    public static void main(String[] args) {

        String PathToCSV = filePath + File.separator + "Chrome Passwords.csv";
        PasswordManager passwordManager = new PasswordManager();
        try {
            passwordManager.ReadFromCSV(PathToCSV);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
