package com.dhbw.controls;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonForm2 {
    private JPanel buttonFormMainPanel;
    private JButton button1;
    private JTextField textField1;

    public ButtonForm2()
    {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField1.setText("Button wurde geklickt.");
            }
        });
    }

    public void showButtonForm(){
        JFrame frame = new JFrame("ButtonForm2");
        frame.setContentPane(new ButtonForm2().buttonFormMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
