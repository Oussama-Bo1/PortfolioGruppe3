package View;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class View {

    private JFrame frame;
    private JTextPane txtCity;
    private JTextPane txtZipcode;
    private List<String> countries;

    public View() {
        frame = new JFrame();
        frame.setBounds(100, 100, 513, 288);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        txtCity = new JTextPane();
        txtCity.setEditable(true);
        txtCity.setBounds(10, 60, 311, 88);
        frame.getContentPane().add(txtCity);
        txtZipcode = new JTextPane();
        txtZipcode.setEditable(true);
        txtZipcode.setBounds(331, 60, 155, 88);
        frame.getContentPane().add(txtZipcode);
        JButton btnLookForZipCode = new JButton("PLZ suchen");
        btnLookForZipCode.setBounds(10, 186, 311, 23);
        frame.getContentPane().add(btnLookForZipCode);
        JButton btnLookForCity = new JButton("Name suchen");
        btnLookForCity.setBounds(331, 186, 155, 23);
        frame.getContentPane().add(btnLookForCity);
        JLabel lblInfo;
        lblInfo = new JLabel("");
        lblInfo.setBackground(Color.WHITE);
        lblInfo.setBounds(10, 221, 473, 15);
        frame.getContentPane().add(lblInfo);
        JLabel lblCity = new JLabel("Stadt");
        lblCity.setBounds(10, 47, 46, 14);
        frame.getContentPane().add(lblCity);
        JLabel lblZipcode = new JLabel("Postleitzahl");
        lblZipcode.setBounds(331, 47, 82, 14);
        frame.getContentPane().add(lblZipcode);
        JComboBox<String> cbCountryList;
        cbCountryList = new JComboBox<String>();
        cbCountryList.setBounds(10, 23, 120, 22);
        frame.getContentPane().add(cbCountryList);
        JLabel lblCountry = new JLabel("Land");
        lblCountry.setBounds(10, 11, 46, 14);
        frame.getContentPane().add(lblCountry);
        this.frame.setVisible(true);
    }
}
