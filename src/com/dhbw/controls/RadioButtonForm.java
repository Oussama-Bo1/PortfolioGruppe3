package com.dhbw.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonForm {
    private JPanel radioButtonMainPanel;
    private JPanel radioButtonPanel;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JTextField textField1;
    private JPanel textFieldPanel;

    public RadioButtonForm()
    {
        radioButton1 = new JRadioButton("Linux", true);
        radioButton2 = new JRadioButton("Windows");
        radioButton3 = new JRadioButton("MacOs");
        radioButton4 = new JRadioButton("Solaris");

        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButton1);
        radioButtonGroup.add(radioButton2);
        radioButtonGroup.add(radioButton3);
        radioButtonGroup.add(radioButton4);

        radioButtonPanel = new JPanel();

        radioButtonPanel.add(radioButton1);
        radioButtonPanel.add(radioButton2);
        radioButtonPanel.add(radioButton3);
        radioButtonPanel.add(radioButton4);

        radioButtonMainPanel.setLayout(new FlowLayout());
        radioButtonMainPanel.add(radioButtonPanel);

        radioButtonMainPanel.add(textFieldPanel);

        ActionListener radioButtonActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    AbstractButton aButton = (AbstractButton)actionEvent.getSource();
                    textField1.setText(aButton.getText());
                }
            };

        radioButton1.addActionListener(radioButtonActionListener);
        radioButton2.addActionListener(radioButtonActionListener);
        radioButton3.addActionListener(radioButtonActionListener);
        radioButton4.addActionListener(radioButtonActionListener);

    }

    public void showRadioButtonForm()
    {
        JFrame frame = new JFrame("RadioButtonForm");
        frame.setContentPane(new RadioButtonForm().radioButtonMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
