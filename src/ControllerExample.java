package src;

import src.Model.DatabaseManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;

public class ControllerExample implements ActionListener, KeyListener {

    private DatabaseManager dbm;
    private ExampleView viewMain;

    private String currentlySelectedCountry;
    private HashMap<String, List<String>> ortPlzMap;

    public ControllerExample(){
        dbm = new DatabaseManager();
        viewMain = new ExampleView(this);
        initUi();
    }

    private void initUi(){
        viewMain.setDropboxItems(dbm.getAvailableCountries());
    }

    private void doTheThing(){                              //Fragen: Case, wie reagiert das Programm auf verschiedene groß/kleinschreibungen
        String searchPhrase = viewMain.getTFInput();        //Wäre blöd n Ort wegen technicalities nicht zu finden (zb nur Landau = Fehlanzeige. Landau in der Pfalz = Success)
        String returnPlz = "";
        try{
            returnPlz = ortPlzMap.get(searchPhrase).get(0);
        } catch (Exception e){
            returnPlz = "Keine du Opfer";
        }
        viewMain.setLabelText(returnPlz);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(viewMain.getComboBox1())){
            currentlySelectedCountry = viewMain.getComboBox1().getSelectedItem().toString();
            ortPlzMap = dbm.getPostcodes(currentlySelectedCountry);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10){ //Enter
            doTheThing();
        }
    }
}
