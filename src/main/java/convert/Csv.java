package convert;

import arista.Decryption;
import arista.Encryption;
import com.opencsv.CSVReader;
import passwordmanager.Credentials;

import java.io.FileReader;

public class Csv {

    public Credentials[] ReadFromCSV(Credentials[] credentials, String filePath) throws Exception {
        Encryption encryption = new Encryption();
        CSVReader reader = new CSVReader(new FileReader(filePath));
        String [] nextLine;
        String[] CSVArray = new String[4];
        int i = 0;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            CSVArray[0] = nextLine[0];
            CSVArray[1] = nextLine[1];
            CSVArray[2] = nextLine[2];
            CSVArray[3] = encryption.encrypt(nextLine[3]);

            Credentials c = new Credentials(CSVArray[0],CSVArray[1],CSVArray[2],CSVArray[3]);
            credentials[i] = c;
            i++;
        }
        return credentials;
    }

    private static void PrintCSV (String[] CSVArray) {
        Decryption decryption = new Decryption();
        System.out.println("================================================");
        System.out.println("Name : " + CSVArray[0]);
        System.out.println("URL : " + CSVArray[1]);
        System.out.println("Username : " + CSVArray[2]);
        System.out.println("Encrypted Password : " + CSVArray[3]);
        String encrypted = CSVArray[3];
//        try {
//            String decrypted = decryption.decrypt(encrypted);
//            System.out.println("Decrypted : " + decrypted);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
