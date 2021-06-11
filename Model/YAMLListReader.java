package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YAMLListReader { //Lässt als YAML-Parser nur wenig Syntax zu

    private static final String regexListheader = "^([^- ])(.+?)(:)";
    private static final String regexListentry = "^- ([^#]+?)*";

    private File file;
    private List<String> lines;
    private HashMap<String, List<String>> output;

    public void setFile(File file){
        this.file = file;
    }

    /*
    ruft die funktionen auf, die die File auslesen und einen output erzeugen
     */
    public HashMap<String, List<String>> generateHashMap(){
        output = new HashMap<>();
        read();
        analyze();
        return output;
    }

    /*
    Liest Datei zeilenweise aus und speichert in einer List<String>
     */
    private void read(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
            lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null){
                lines.add(line);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /*
    Weil die Value eine List ist, muss aufgepasst werden, wenn man die Listen erweitern will
    Wenn es zu einem Key schon eine List gibt, wird sie appended statt überschrieben
     */
    private void appendOutput(String key, List<String> value){
        if (output.containsKey(key)){
            output.get(key).addAll(value);
        }
        output.put(key, value);
    }

    /*
    Liest die Zeilen der lines-liste. Hat extrem simple Logik, und liest nur Listen der Form
    Key:
    - value1
    - value2
    - value3
    Die Form von Keys und values werden mittels regexes geprüft, zugeschnitten und in die Output Hashmap gelegt.
    Der Output hat den Datentyp HashMap<String,List<String>>
     */
    private void analyze(){
        String key = null;
        List<String> value = new ArrayList<>();
        for (Integer i = 0; i < lines.size(); i++){
            String line = lines.get(i);
            if (line.matches(regexListheader)){
                if (key != null) {
                    appendOutput(key, value);
                    value = new ArrayList<>();
                }
                Pattern pattern = Pattern.compile(regexListheader);
                Matcher matcher = pattern.matcher(line);
                matcher.find();
                key = matcher.group(0).substring(0,matcher.group(0).length()-1);
            }
            else if (line.matches(regexListentry)){
                value.add(line.substring(2,line.length()));
            }
        }
        if (key != null){
            appendOutput(key, value);
        }
    }

}
