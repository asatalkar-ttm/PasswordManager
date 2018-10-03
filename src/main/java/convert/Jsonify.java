package convert;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import passwordmanager.Credentials;

public class Jsonify {

    private GsonBuilder gsonBuilder;

    public Jsonify() throws IllegalArgumentException {
        this.gsonBuilder = new GsonBuilder().setPrettyPrinting();
    }

    public String ConvertToJson(Credentials credentials) {
        Gson gson = this.gsonBuilder.setPrettyPrinting().create();
        //Print JSON
        System.out.println(gson.toJson(credentials));
        return gson.toJson(credentials);
    }
}
