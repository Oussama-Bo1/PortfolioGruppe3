package com.dhbw.controls;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderForm {
    private JTextField textField1;
    private JPanel sliderFormMainPanel;
    private JSlider slider1;

    public SliderForm()
    {
        slider1.setMaximum(1000);
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                textField1.setText(String.valueOf(slider1.getValue()));
            }
        });
    }

    public void showSliderForm() {
        JFrame frame = new JFrame("SliderForm");
        frame.setContentPane(new SliderForm().sliderFormMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
