package convert;

import arista.Encryption;
import com.opencsv.CSVReader;
import passwordmanager.Credentials;

import java.io.FileReader;
import java.util.List;

public class Csv {

    public List<Credentials> ReadFromCSV(List<Credentials> credentials, String filePath) throws Exception {
        Encryption encryption = new Encryption();
        CSVReader reader = new CSVReader(new FileReader(filePath));
        String [] nextLine;
        String name="", url="", username="", password="";
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            name = nextLine[0];
            url = nextLine[1];
            username = nextLine[2];
            password = encryption.encrypt(nextLine[3]);

            Credentials c = new Credentials(name,url,username,password);
            credentials.add(c);
        }
        return credentials;
    }
}
