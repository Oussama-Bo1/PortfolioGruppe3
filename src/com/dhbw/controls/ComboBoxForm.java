package com.dhbw.controls;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxForm {
    private JTextField textField1;
    private JPanel comboBoxFormMainPanel;
    private JComboBox comboBox1;

    public ComboBoxForm(){
        comboBox1.addItem("Linux");
        comboBox1.addItem("Windows");
        comboBox1.addItem("MacOs");
        comboBox1.addItem("Solaris");
        comboBox1.setEditable(true);
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField1.setText(comboBox1.getSelectedItem().toString());
            }
        });
    }

    public void showComboBoxForm(){
        JFrame frame = new JFrame("ComboBoxForm");
        frame.setContentPane(new ComboBoxForm().comboBoxFormMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
