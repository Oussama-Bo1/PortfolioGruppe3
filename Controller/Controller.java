package Controller;

import Model.DatabaseManager;
import View.*;

import java.util.HashMap;
import java.util.List;

public class Controller {

    private String Ort;
    private String PLZ;
    private String Country;
    private HashMap<String, List<String>> plzs;

    public Controller() {
        View window = new View();
        DatabaseManager dbm = new DatabaseManager();
        List<String> Countries = dbm.getAvailableCountries();
        this.plzs = dbm.getPostcodes(this.Country);
    }

    public String capitalize(String in){
        char[] input = in.toLowerCase().toCharArray();
        String result = "";
        Character previous = input[0];
        result += Character.toString(input[0]).toUpperCase();

        for (Character curr : input){
            if (curr == input[0]) {
                previous = curr; continue;
            }
            switch (previous){
                case (' '):
                case ('-'):
                    result += Character.toString(curr).toUpperCase();
                    break;
                default: result += curr;
            }
            previous = curr;
        }
        return result;
    }

        public List<String> getPostCodes() {
            List<String> PLZ = plzs.get(Ort);
            System.out.println(PLZ);
            return PLZ;
    }
}
