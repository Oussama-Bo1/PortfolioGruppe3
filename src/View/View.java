package src.View;


import javax.swing.*;
import java.awt.*;
import java.util.List;
import src.Controller.*;

public class View {

    private JFrame frame;
    private JTextPane txtCity;
    private JTextPane txtZipcode;
    private JComboBox cbCountryList;
    private Controller controller;
    private JButton btnLookForZipCode;
    private JButton btnLookForCity;
    private JLabel lblInfo;

    public View(Controller controller){
        this.controller = controller;

        frame = new JFrame();
        frame.setBounds(100, 100, 513, 288);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setTitle("Supernicer Postleitzahlensucher");

        JScrollPane jsp1 = new JScrollPane(getTxtCity());
        jsp1.setBounds(10, 60, 311, 88);
        frame.getContentPane().add(jsp1);

        JScrollPane jsp2 = new JScrollPane(getTxtZipcode());
        jsp2.setBounds(331, 60, 155, 88);
        frame.getContentPane().add(jsp2);

        frame.getContentPane().add(getBtnLookForZipcode());

        frame.getContentPane().add(getBtnLookForCity());

        frame.getContentPane().add(getCBCountryList());

        frame.getContentPane().add(getLblInfo());

        JLabel lblCity = new JLabel("Ort");
        lblCity.setBounds(10, 47, 46, 14);
        frame.getContentPane().add(lblCity);

        JLabel lblZipcode = new JLabel("Postleitzahl");
        lblZipcode.setBounds(331, 47, 82, 14);
        frame.getContentPane().add(lblZipcode);


        JLabel lblCountry = new JLabel("Land");
        lblCountry.setBounds(10, 11, 46, 14);
        frame.getContentPane().add(lblCountry);
        this.frame.setVisible(true);
    }

    public JTextPane getTxtCity() {
        if (txtCity == null){
            txtCity = new JTextPane();
            txtCity.setEditable(true);
            txtCity.setBounds(10, 60, 311, 88);
            txtCity.addFocusListener(controller);
            txtCity.addKeyListener(controller);
        }
        return txtCity;
    }

    public JTextPane getTxtZipcode() {
        if (txtZipcode == null){
            txtZipcode = new JTextPane();
            txtZipcode.setEditable(true);
            txtZipcode.setBounds(331, 60, 155, 88);
            txtZipcode.addFocusListener(controller);
            txtZipcode.addKeyListener(controller);
        }
        return txtZipcode;
    }

    public JComboBox getCBCountryList(){
        if (cbCountryList == null){
            cbCountryList = new JComboBox<String>();
            cbCountryList.setBounds(10, 23, 120, 22);
            cbCountryList.addActionListener(controller);
        }
        return cbCountryList;
    }

    public JButton getBtnLookForZipcode(){
        if (btnLookForZipCode == null){
            btnLookForZipCode = new JButton("PLZ suchen");
            btnLookForZipCode.setBounds(10, 186, 311, 23);
            btnLookForZipCode.addActionListener(controller);
        }
        return btnLookForZipCode;
    }

    public JButton getBtnLookForCity(){
        if (btnLookForCity == null){
            btnLookForCity = new JButton("Ort suchen");
            btnLookForCity.setBounds(331, 186, 155, 23);
            btnLookForCity.addActionListener(controller);
        }
        return btnLookForCity;
    }

    public JLabel getLblInfo(){
        if (lblInfo == null){
            lblInfo = new JLabel("");
            lblInfo.setBackground(Color.WHITE);
            lblInfo.setBounds(10, 221, 473, 15);
        }
        return lblInfo;
    }

    public void setCBContent(List<String> countries){
        cbCountryList.removeAllItems();
        for (String country : countries){
            cbCountryList.addItem(country);
        }
    }
}
