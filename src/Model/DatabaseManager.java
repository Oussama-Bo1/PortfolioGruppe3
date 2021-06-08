package src.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseManager {

    private static final String path = "yaml\\"; //Könnte man auch in ner config festlegen oder so
    private static final String regexYamlfile = "^(.+?)(\\.yaml)$";

    private YAMLListReader yamlListReader;

    public DatabaseManager(){
        yamlListReader = new YAMLListReader();
    }

    public List<String> getAvailableCountries(){
        List<String> result = new ArrayList<>();

        File dir = new File(path);
        for (String filename : dir.list()) {
            if (filename.toLowerCase().matches(regexYamlfile))
                result.add(filename.substring(0,filename.length()-5));
        }
        return result;
    }

    public HashMap<String, List<String>> getPostcodes(String country){
        if (getAvailableCountries().contains(country)){
            yamlListReader.setFile(new File(path + country + ".yaml"));
            return yamlListReader.read();
        }
        return null;
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

}
