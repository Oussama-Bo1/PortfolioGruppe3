package com.dhbw.container;

import com.dhbw.controls.ButtonForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileChooserForm {
    private JTextField textField1;
    private JPanel fileChooserFormMainPanel;
    private JButton button1;

    public FileChooserForm()
    {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                textField1.setText(chooser.getSelectedFile().getPath());
            }
        });
    }

    public void showFileChooserForm(){
        JFrame frame = new JFrame("FileChooserForm");
        frame.setContentPane(new FileChooserForm().fileChooserFormMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
