package com.dhbw.controls;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonForm {
    private JButton button1;
    private JPanel buttonFormMainPanel;
    private JTextField textField1;

    public ButtonForm()
    {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField1.setText("Button Clicked");
            }
        });
    }

    public void showButtonForm(){
        JFrame frame = new JFrame("ButtonForm");
        frame.setContentPane(new ButtonForm().buttonFormMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
