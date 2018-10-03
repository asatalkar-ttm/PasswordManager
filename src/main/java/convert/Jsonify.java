package convert;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import passwordmanager.Credentials;

import java.util.List;

public class Jsonify {

    private GsonBuilder gsonBuilder;

    public Jsonify() throws IllegalArgumentException {
        this.gsonBuilder = new GsonBuilder().setPrettyPrinting();
    }

    public String convertToJson(List<Credentials> credentials) {
        Gson gson = this.gsonBuilder.setPrettyPrinting().create();
        String jsonString = gson.toJson(credentials);
        return jsonString;
    }

    public void printJson(String jsonString) {
        //Print JSON
        System.out.println(jsonString);
    }
}
