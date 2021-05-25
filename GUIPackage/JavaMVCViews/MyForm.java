package GUIPackage.JavaMVCViews;

import GUIPackage.JavaMVCControllers.MyController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyForm extends javax.swing.JFrame {
    private MyController controller;

    private JButton loadData;
    private JButton writeData;
    private JTextArea myTextArea;
    private JLabel myLabel;
    private JScrollPane myScrollPane;

    public MyForm(MyController controller) throws HeadlessException {
        this.controller = controller;
        init();
    }

    private void init()  {
        loadData = new JButton();
        writeData = new JButton();
        myTextArea = new JTextArea();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setName("myFrame");
        myLabel.setText("Send: ...");

        loadData.setText("Receive Data");
        loadData.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                loadDataMouseClicked(evt);
            }
        });

        myTextArea.setColumns(20);
        myTextArea.setRows(5);
        myScrollPane.setViewportView(myTextArea);

        writeData.setText("Send Data");
        writeData.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                writeDataMouseClicked(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        GroupLayout.SequentialGroup sequentialGroup =
            layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(myLabel, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                            .addComponent(myScrollPane))
                                    .addContainerGap())
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(loadData)
                                    .addGap(158, 158, 158)));

        GroupLayout.ParallelGroup horizontalGroup =
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(sequentialGroup)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(writeData)
                            .addGap(0, 0, Short.MAX_VALUE)).addContainerGap());

        GroupLayout.ParallelGroup verticalGroup =
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(myLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(loadData)
                            .addGap(39, 39, 39)
                            .addComponent(myScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(writeData)
                            .addContainerGap(82, Short.MAX_VALUE));

        layout.setHorizontalGroup(horizontalGroup);
        layout.setVerticalGroup(verticalGroup);

        getContentPane().setLayout(layout);

        pack();
    }


    private void loadDataMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            controller.receiveMessage();
        } catch (Exception er) {

        }
    }

    private void writeDataMouseClicked(java.awt.event.MouseEvent evt) {
        String message = myTextArea.getText();
        controller.sendMessage(message);
    }

    public void setMyLabel(String text) {
        myLabel.setText(text);
        myLabel.setVisible(true);
    }

}
