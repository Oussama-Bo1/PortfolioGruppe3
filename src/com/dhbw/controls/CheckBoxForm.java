package com.dhbw.controls;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxForm {
    private JPanel checkBoxFormMainPanel;
    private JTextField textField1;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;

    public CheckBoxForm(){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = "";
                if(checkBox1.isSelected()){
                    text += checkBox1.getText() + " ";
                }
                if(checkBox2.isSelected()){
                    text += checkBox2.getText() + " ";
                }
                if(checkBox3.isSelected()){
                    text += checkBox3.getText() + " ";
                }
                if(checkBox4.isSelected()){
                    text += checkBox4.getText() + " ";
                }
                textField1.setText(text);
            }
        };

        checkBox1.setText("Linux");
        checkBox1.addActionListener(actionListener);
        checkBox2.setText("Windows");
        checkBox2.addActionListener(actionListener);
        checkBox3.setText("MacOS");
        checkBox3.addActionListener(actionListener);
        checkBox4.setText("Solaris");
        checkBox4.addActionListener(actionListener);
    }

    public void showCheckBoxForm(){
        JFrame frame = new JFrame("CheckBoxForm");
        frame.setContentPane(new CheckBoxForm().checkBoxFormMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
