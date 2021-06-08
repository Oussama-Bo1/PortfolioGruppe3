package Postleitzahl;


import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;

public class Main {

    private JFrame frame;
    private JTextPane txtCity;
    private JTextPane txtZipcode;
    private City[] cities, germany, austria, usa;

    public static void main(String[] args) {
        Main window = new Main();
        window.frame.setVisible(true);
    }

    public Main() {
        initialize();
        germany = new City[6];
        germany[0] = new City("Mannheim-Jungbusch", 68159);
        germany[1] = new City("Mannheim-Innenstadt", 68159);
        germany[2] = new City("Mannheim-Neckarau", 68199);
        germany[3] = new City("Oldenburg-Dietrichsfeld", 26127);
        germany[4] = new City("Oldenburg-Innenstadt", 26122);
        germany[5] = new City("Walldorf", 69190);
        austria = new City[3];
        austria[0] = new City("Wien-Donaustadt", 1220);
        austria[1] = new City("Wien-Penzing", 1140);
        austria[2] = new City("Grosshofen", 2282);
        usa = new City[1];
        usa[0] = new City("Washington D.C.", 20502);
        cities = germany;
    }


    JComboBox<String> cbCountryList;
    JLabel lblInfo;

    private void initialize() {
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
        btnLookForZipCode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> plzs = new ArrayList<Integer>();
                txtZipcode.setText("");
                lblInfo.setText("");
                City[] cities = getPLZforCity(txtCity.getText());
                if(cities.length >= 1) {
                    for(int i = 0; i < cities.length; i++) {
                        if(!plzs.contains(cities[i].getPLZ())) {
                            String txt = txtZipcode.getText();
                            txtZipcode.setText(txt+"\n"+cities[i].getPLZ());
                            plzs.add(cities[i].getPLZ());
                        }
                    }
                } else {
                    lblInfo.setText("Keine PLZ f�r die Stadt gefunden!");
                    txtCity.setText("");
                    txtZipcode.setText("");
                }
            }
        });
        btnLookForZipCode.setBounds(10, 186, 311, 23);
        frame.getContentPane().add(btnLookForZipCode);

        JButton btnLookForCity = new JButton("Name suchen");
        btnLookForCity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtCity.setText("");
                lblInfo.setText("Stadt suchen");
                try {
                    City[] cities = getCitiesForPLZ(Integer.parseInt(txtZipcode.getText()));
                    if(cities.length > 1) {
                        for(int i = 0; i < cities.length; i++) {
                            txtCity.setText(txtCity.getText()+cities[i].getName()+"\n");
                        }
                    } else if(cities.length == 1) {
                        txtCity.setText(cities[0].getName()+"\n");
                    } else {
                        lblInfo.setText("Keine Stadt f�r die Postleitzahl gefunden!");
                    }
                } catch (NumberFormatException exc) {
                    lblInfo.setText("Die Eingabe der PLZ muss eine Nummer sein!");
                }
            }
        });
        btnLookForCity.setBounds(331, 186, 155, 23);
        frame.getContentPane().add(btnLookForCity);

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

        String[] countries = {"Deutschland", "Oesterreich", "USA"};
        cbCountryList = new JComboBox<String>(countries);
        cbCountryList.setBounds(10, 23, 120, 22);
        cbCountryList.setSelectedItem("Deutschland");
        cbCountryList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String country = (String) cbCountryList.getSelectedItem();
                switch (country) {
                    case "Deutschland":
                        cities = germany;
                        break;
                    case "Oesterreich":
                        cities = austria;
                        break;
                    case "USA":
                        cities = usa;
                        break;
                }
            }
        });
        frame.getContentPane().add(cbCountryList);

        JLabel lblCountry = new JLabel("Land");
        lblCountry.setBounds(10, 11, 46, 14);
        frame.getContentPane().add(lblCountry);

    }

    public City[] getCitiesForPLZ(int plz) {
        ArrayList<City> r = new ArrayList<>();
        for(City c : cities) {
            if(c.getPLZ() == plz) {
                r.add(c);
            }
        }
        City[] result = new City[r.size()];
        for(int i = 0; i<result.length; i++) {
            result[i] = r.get(i);
        }
        return result;
    }

    public City[] getPLZforCity(String name) {
        ArrayList<City> r = new ArrayList<>();
        for(City c : cities) {
            if(c.getName().toLowerCase().contains(name.toLowerCase())) {
                r.add(c);
            }
        }
        City[] result = new City[r.size()];
        for(int i = 0; i<result.length; i++) {
            result[i] = r.get(i);
        }
        return result;
    }
}

