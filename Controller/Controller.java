package Controller;
import Model.DatabaseManager;

import java.util.List;

public class Controller {

        public List<String> Countries(String[] args) {
            DatabaseManager dbm = new DatabaseManager();
            List<String> countrie = dbm.getAvailableCountries();
            return countrie;
        }
    }
