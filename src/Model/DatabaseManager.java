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

    /*
    Sucht im in path hinterlegten Ordnerpfad nach yamldateien, und gibt eine
    Liste der Länder aus.
     */
    public List<String> getAvailableCountries(){
        List<String> result = new ArrayList<>();

        File dir = new File(path);
        for (String filename : dir.list()) {
            if (filename.toLowerCase().matches(regexYamlfile))
                result.add(filename.substring(0,filename.length()-5));
        }
        return result;
    }

    /*
    Wenn es eine zugehörige Yamldatei gibt, wird eine HashMap daraus ausgelesen
     */
    public HashMap<String, List<String>> getPostcodes(String country){
        if (getAvailableCountries().contains(country)){
            yamlListReader.setFile(new File(path + country + ".yaml"));
            return yamlListReader.generateHashMap();
        }
        return null;
    }
}
