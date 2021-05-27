package AllUsers.AllUsersDAO;

import AllUsers.Driver;
import Enums.Gender;
import Utils.FileUtils;
import Utils.StringUtils;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class DriverDAO {

    public Driver loadDriverByUsername(String username) {
        HashMap<String, Driver> map = loadAllDriverFromFile();
        return map.get(username);
    }

    public HashMap<String, Driver> loadAllDriverFromFile() {
        HashMap<String, Driver> map = new HashMap<String, Driver>();
        try (BufferedReader in = FileUtils.getReader("Driver")) {
            String line;
            in.mark(1);
            if(in.read()!='\ufeff'){
                in.reset();
            }
            while ((line = in.readLine()) != null) {
                Driver d = fromString(line);
                map.put(d.getUsername(),d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public Driver fromString(String str) {
        String parts[] = str.split(",");
        String username = parts[0];
        String password = parts[1];
        String name = parts[2];
        String lastName = parts[3];
        String address = parts[4];
        String phoneNumber = parts[5];
        Gender gender = parts[6];

        OsobaDAO oDAO = new OsobaDAO();
        Osoba o = oDAO.loadOsobaByJmbG(jmbg);
        return new Kupac(korisnickoIme, lozinka, o, stanjeNaRacunu);
    }

    public void saveAllDriverToFile(HashMap<String, Driver> map) {
        try (PrintWriter out = FileUtils.getPrintWriter("Driver")) {
            for (Driver d : map.values()) {
                out.println(toFileString(d));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toFileString(Driver d) {
        UsersDAO dao = new UsersDAO();
        return dao.toFileString(d) + "," +
                StringUtils.clean(d.getOsoba().getJmbg()) + "," + k.getStanjeNaRacunu();
    }

}
