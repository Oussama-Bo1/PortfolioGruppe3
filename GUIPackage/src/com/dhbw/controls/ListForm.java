package com.dhbw.controls;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListForm {
    private JTextField textField1;
    private JPanel listFormMainPanel;
    private JList list1;

    public ListForm() {
        String[] a = {"Linux", "Windows", "MacOs", "Solaris"};
        list1.setListData(a);

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                int[] selected = list1.getSelectedIndices();

                String text = "";
                for (int i = 0; i < selected.length; i++)
                {
                    text = text + " " + a[selected[i]];
                }

                textField1.setText(text);
                textField1.set
            }
        });
    }

    public void showListForm(){
        JFrame frame = new JFrame("ListForm");
        frame.setContentPane(new ListForm().listFormMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
