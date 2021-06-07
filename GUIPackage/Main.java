package Postleitzahl;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class Main {

    private JFrame frame;
    private JTextPane txt_city;
    private JTextPane txt_plz;
    private City[] cities;

    public static void main(String[] args) {
        Main window = new Main();
        window.frame.setVisible(true);
    }

    public Main() {
        initialize();
        cities = new City[6];
        cities[0] = new City("Mannheim-Jungbusch", 68159);
        cities[1] = new City("Mannheim-Innenstadt", 68159);
        cities[2] = new City("Mannheim-Neckarau", 68199);
        cities[3] = new City("Oldenburg-Dietrichsfeld", 26127);
        cities[4] = new City("Oldenburg-Innenstadt", 26122);
        cities[5] = new City("Walldorf", 69190);


}



    JComboBox<String> comboBox;
    JLabel lblNewLabel;

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 508, 260);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        txt_city = new JTextPane();
        txt_city.setEditable(true);
        txt_city.setBounds(10, 11, 350, 113);
        frame.getContentPane().add(txt_city);

        txt_plz = new JTextPane();
        txt_plz.setEditable(true);
        txt_plz.setBounds(370, 11, 116, 113);
        frame.getContentPane().add(txt_plz);

        comboBox = new JComboBox<String>();
        comboBox.setEditable(false);
        comboBox.setBounds(10, 135, 350, 22);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String city = (String) comboBox.getSelectedItem();
                int plz = 0;
                for (City c : cities) {
                    if (c.getName().equalsIgnoreCase(city)) {
                        plz = c.getPLZ();
                    }
                }
                txt_plz.setText("" + plz);
            }
        });
        frame.getContentPane().add(comboBox);

        JButton btn_suche_nach_plzs = new JButton("PLZ suchen");
        btn_suche_nach_plzs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> plzs = new ArrayList<Integer>();
                txt_plz.setText("");
                lblNewLabel.setText("");
                City[] cities = getPLZforCity(txt_city.getText());
                if (cities.length >= 1) {
                    comboBox.removeAllItems();
                    for (int i = 0; i < cities.length; i++) {
                        if (!plzs.contains(cities[i].getPLZ())) {
                            String txt = txt_plz.getText();
                            txt_plz.setText(txt + "\n" + cities[i].getPLZ());
                            plzs.add(cities[i].getPLZ());
                        }
                        comboBox.addItem(cities[i].getName());
                    }
                    frame.getContentPane().add(comboBox);
                } else {
                    lblNewLabel.setText("Keine PLZ f�r die Stadt gefunden!");
                }
            }
        });
        btn_suche_nach_plzs.setBounds(10, 168, 350, 23);
        frame.getContentPane().add(btn_suche_nach_plzs);

        JButton btn_suche_nach_name = new JButton("Name suchen");
        btn_suche_nach_name.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txt_city.setText("");
                lblNewLabel.setText("Stadt suchen");
                comboBox.removeAllItems();
                try {
                    City[] cities = getCitiesForPLZ(Integer.parseInt(txt_plz.getText()));
                    if (cities.length > 1) {
                        for (int i = 0; i < cities.length; i++) {
                            txt_city.setText(txt_city.getText() + cities[i].getName() + "\n");
                        }
                    } else if (cities.length == 1) {
                        txt_city.setText(cities[0].getName() + "\n");
                    } else {
                        lblNewLabel.setText("Keine Stadt f�r die Postleitzahl gefunden!");
                    }
                } catch (NumberFormatException exc) {
                    lblNewLabel.setText("Die Eingabe der PLZ muss eine Nummer sein!");
                }
            }
        });
        btn_suche_nach_name.setBounds(370, 168, 116, 23);
        frame.getContentPane().add(btn_suche_nach_name);

        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(10, 202, 473, 14);
        frame.getContentPane().add(lblNewLabel);

    }

    public City[] getCitiesForPLZ(int plz) {
        ArrayList<City> r = new ArrayList<>();
        for (City c : cities) {
            if (c.getPLZ() == plz) {
                r.add(c);
            }
        }
        City[] result = new City[r.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = r.get(i);
        }
        return result;
    }

    public City[] getPLZforCity(String name) {
        ArrayList<City> r = new ArrayList<>();
        for (City c : cities) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                boolean containsPLZ = false;
                for (City c2 : r) {
                    if (c2.getPLZ() == c.getPLZ())
                        containsPLZ = true;
                }
                if (!containsPLZ)
                    r.add(c);
            }
        }
        City[] result = new City[r.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = r.get(i);
        }
        return result;
    }


}