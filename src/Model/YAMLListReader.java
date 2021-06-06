package src.Model;

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

    public HashMap<String, List<String>> read(){
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
            return null;
        }
        output = new HashMap<>();
        analyze();

        return output;
    }

    private void appendOutput(String key, List<String> value){
        if (output.containsKey(key)){
            output.get(key).addAll(value);
        }
        output.put(key, value);
    }

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
