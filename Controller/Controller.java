package Controller;

import Model.DatabaseManager;
import java.util.HashMap;
import java.util.List;

public class Controller {

        private String Ort = "Frankfurt am Main";
        private String PLZ;
        private String Country;
        DatabaseManager dbm = new DatabaseManager();
        private List<String> Countries = dbm.getAvailableCountries();
        HashMap<String,List<String>> plzs = dbm.getPostcodes(Country);

        public String getChosenCountry() {
            for (String cities : plzs.get(Ort))
                System.out.println(cities);
            return Ort;
        }

        public List<String> getPostCodes() {
            List<String> PLZ = plzs.get(Ort);
            return PLZ;
        }
}
