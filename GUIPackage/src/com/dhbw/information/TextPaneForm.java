package com.dhbw.information;

import javax.swing.*;

public class TextPaneForm {
    private JTextPane textPane1;
    private JEditorPane editorPane1;
    private JPanel textPaneFormMainPanel;

    public void showTextPaneForm() {
        JFrame frame = new JFrame("TextPaneForm");
        frame.setContentPane(new TextPaneForm().textPaneFormMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
