package com.dhbw.information;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBarForm {
    private JProgressBar progressBar1;
    private JPanel progressBarFormMainPanel;
    private JButton button1;
    private int i = 0;


    public ProgressBarForm()
    {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                i += 10;
                progressBar1.setValue(i);
            }
        });
    }

    public void showProgressBarForm() {
        JFrame frame = new JFrame("ProgressBarForm");
        frame.setContentPane(new ProgressBarForm().progressBarFormMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
