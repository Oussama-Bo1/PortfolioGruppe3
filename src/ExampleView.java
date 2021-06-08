package src;

import javax.swing.*;
import java.util.List;

public class ExampleView {                      //Was kommt hier rein:
    private JPanel exampleViewPanel;            //Calls um die UI aufzusetzen, UI-Elemente zu füllen etc
    private JTextField textField1;
    private JComboBox comboBox1;
    private JLabel label1;


    private ControllerExample controller;

    public void setDropboxItems(List<String>items){
        comboBox1.removeAllItems();
        for (String item : items){
            comboBox1.addItem(item);
        }
    }

    public void setLabelText(String string){
        label1.setText(string);
    }

    public ExampleView(ControllerExample controller){
        this.controller = controller;

        JFrame fenster = new JFrame("Exampleview Fenster");
        fenster.setContentPane(this.exampleViewPanel);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.pack();
        fenster.setVisible(true);

        comboBox1.addActionListener(controller);
        textField1.addKeyListener(controller);
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public String getTFInput(){
        return textField1.getText();
    }
}
