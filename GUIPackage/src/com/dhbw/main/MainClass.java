package com.dhbw.main;

import com.dhbw.container.FileChooserForm;
import com.dhbw.container.MyDialog;
import com.dhbw.controls.*;
import com.dhbw.information.ProgressBarForm;
import com.dhbw.information.TextAreaForm;
import com.dhbw.information.TextPaneForm;

public class MainClass {
    public static void main(String[] args) {
        //CONTROLS
        //showButtonForm();
        //showComboBoxForm();
        showListForm();
        //showCheckBoxForm();
        //showRadioButtonForm();
        //showSliderForm();

        //INFORMATION CONTROLS DISPLAYS
        //showProgressBarForm();
        //showScrollBarForm();

        //showTextAreaForm();
        //showTextPaneForm();
        //showButtonForm2();

        //CONTAINER
        //showFileChooserForm();
        //showDialog();
    }

    //CONTROLS
    private static void showButtonForm()
    {
        ButtonForm buttonForm = new ButtonForm();
        buttonForm.showButtonForm();
    }

    private static void showComboBoxForm()
    {
        ComboBoxForm comboBoxForm = new ComboBoxForm();
        comboBoxForm.showComboBoxForm();
    }

    private static void showListForm()
    {
        ListForm listForm = new ListForm();
        listForm.showListForm();
    }

    private static void showCheckBoxForm()
    {
        CheckBoxForm checkBoxForm = new CheckBoxForm();
        checkBoxForm.showCheckBoxForm();
    }

    private static void showRadioButtonForm()
    {
        RadioButtonForm radioButtonForm = new RadioButtonForm();
        radioButtonForm.showRadioButtonForm();
    }

    private static void showSliderForm()
    {
        SliderForm sliderForm = new SliderForm();
        sliderForm.showSliderForm();
    }

    //DISPLAYS
    private static void showTextAreaForm()
    {
        TextAreaForm textAreaForm = new TextAreaForm();
        textAreaForm.showTextAreaForm();
    }

    private static void showProgressBarForm()
    {
        ProgressBarForm progressBarForm = new ProgressBarForm();
        progressBarForm.showProgressBarForm();
    }

    private static void showScrollBarForm()
    {
        ScrollBarForm scrollBarForm = new ScrollBarForm();
        scrollBarForm.showScrollBarForm();
    }

    private static void showTextPaneForm()
    {
        TextPaneForm textPaneForm = new TextPaneForm();
        textPaneForm.showTextPaneForm();
    }

    private static void showButtonForm2()
    {
        ButtonForm2 buttonForm2 = new ButtonForm2();
        buttonForm2.showButtonForm();
    }

    //CONTAINER
    private static void showFileChooserForm()
    {
        FileChooserForm fileChooserForm = new FileChooserForm();
        fileChooserForm.showFileChooserForm();
    }

    private static void showDialog()
    {
        MyDialog.showDialog();
    }
}
