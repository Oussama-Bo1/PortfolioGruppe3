package com.dhbw.information;

import javax.swing.*;

public class TextAreaForm {
    private JTextArea textArea1;
    private JPanel textAreaFormMainPanel;

    public void showTextAreaForm() {
        JFrame frame = new JFrame("TextAreaForm");
        frame.setContentPane(new TextAreaForm().textAreaFormMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
