package Controller;

import Model.DatabaseManager;
import View.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class Controller implements ActionListener, FocusListener, KeyListener{

    private Boolean postleitzahlErgaenzen; //Welches Feld zuletzt den Mauszeiger hatte
    private HashMap<String, List<String>> plzs; // Key: Ortsname Value: PLZs

    private View window; //GUI
    private DatabaseManager dbm; //Datenanbindung

    public Controller() {
        window = new View(this);
        dbm = new DatabaseManager();
        window.setCBContent(dbm.getAvailableCountries());
    }

    /*
    Keys werden in all uppercase gespeichert. capitalize() macht aus einem String ein String der korrekt capitalized
    ist, bevor er auf demGUI ausgegeben wird
     */
    public String capitalize(String in){
        char[] input = in.toLowerCase().toCharArray();
        String result = "";
        Character previous = input[0];
        Boolean first = true;
        result += Character.toString(input[0]).toUpperCase();

        for (Character curr : input){
            if (first) {
                previous = curr; first = false; continue;
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

    /*
    Postleitzahlen anhand des Orts bekommen
     */
    public List<String> getPostCodes(String ort) {
        List<String> result = new ArrayList<>();
        try{
            result = plzs.get(ort.toUpperCase());
        }
        catch (Exception e) {

        }
        return result;
    }

    /*
    Ort anhand der Postleitzahl bekommen
     */
    public String getOrt(String plz) {
        for (Map.Entry<String, List<String>> item : plzs.entrySet()){
            if (item.getValue().contains(plz))
                return capitalize(item.getKey());
        }
        return "";
    }

    /*
    anderes Feld auf dem GUI ergänzen
     */
    private void complete(){
        clearErrors();
        if (postleitzahlErgaenzen){         // aus Ort Postleitzahl ergänzen
            String text = "";
            List<String> plzs = getPostCodes(window.getTxtCity().getText().trim());
            if (plzs == null){
                errorNoPlace();
                window.getTxtZipcode().setText("");
            }
            else {
                for (String plz : plzs){
                    text += plz + "\n";
                }
                window.getTxtZipcode().setText(text);
            }
        }
        else{                               //Aus Postleitzahl Ort ergänzen
            String ort = getOrt(evaluatePlzString(window.getTxtZipcode().getText().trim()));
            if (ort == ""){
                errorNoPlz();
            }
            window.getTxtCity().setText(ort);
        }
    }

    /*
    Splittet die eingabe an Zeilensprüngen auf, dass von einer mehrzeiligen PLZ-Eingabe wieder auf den Ort geschlossen werden kann
     */
    private String evaluatePlzString(String string){
        String[] array = string.split("\n");
        if (array != null){
            return array[0];
        }
        return string;
    }

    /*
    Ausgewähltes land wechseln.
    Lädt ort-postleitzahlen-map des gewählten lands in den Controller und leert das GUI
     */
    private void switchCountry(String country){
        plzs = dbm.getPostcodes(country);
        window.getTxtCity().setText("");
        window.getTxtZipcode().setText("");
        if (plzs == null){
            databaseError();
            window.setCBContent(dbm.getAvailableCountries());
        }
        else {
            clearErrors();
        }
    }

    private void databaseError(){
        window.getLblInfo().setText("Datei kann nicht ausgelesen werden");
    }

    private void errorNoPlz(){
        window.getLblInfo().setText("Postleitzahl nicht gefunden");
    }

    private void errorNoPlace(){
        window.getLblInfo().setText("Ort nicht gefunden");
    }

    private void clearErrors(){
        window.getLblInfo().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(window.getCBCountryList())){
            String country = window.getCBCountryList().getSelectedItem().toString();
            switchCountry(country);
        }
        else if(e.getSource().equals(window.getBtnLookForCity())){
            postleitzahlErgaenzen = false;
            complete();
        }
        else if (e.getSource().equals(window.getBtnLookForZipcode())){
            postleitzahlErgaenzen = true;
            complete();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(window.getTxtCity())) {
            postleitzahlErgaenzen = true;
        }
        else if (e.getSource().equals(window.getTxtZipcode())){
            postleitzahlErgaenzen = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            complete();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
