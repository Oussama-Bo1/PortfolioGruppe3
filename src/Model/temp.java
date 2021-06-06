package src.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class temp {

    public static void main(String[] args){
        DatabaseManager dbm = new DatabaseManager();
        List<String> countries = dbm.getAvailableCountries();
        for (String country : countries){
            HashMap<String,List<String>> plzs = dbm.getPostcodes(country);
            for (Map.Entry<String, List<String>> entry : plzs.entrySet()){
                System.out.println(entry.getKey());
                for (String value: entry.getValue())
                    System.out.println(" "+value);
            }
        }
    }
}
