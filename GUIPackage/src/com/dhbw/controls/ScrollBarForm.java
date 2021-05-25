package com.dhbw.controls;

import javax.swing.*;

public class ScrollBarForm {
    private JPanel scrollBarFormMainPanel;
    private JPanel labelPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;

    public ScrollBarForm()
    {
           label1.setText("Ubuntu");
           label2.setText("RedHat");
           label3.setText("Debian");
           label4.setText("Solaris");
           label5.setText("Windows XP");
           label6.setText("Windows 10");
           label7.setText("MacOS");
           label8.setText("Android");
    }

    public void showScrollBarForm() {
        JFrame frame = new JFrame("ScrollBarForm");
        frame.setContentPane(new ScrollBarForm().scrollBarFormMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
