package AllUsers.AllUsersDAO;

import AllUsers.Dispatcher;
import Utils.FileUtils;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class DispatcherDAO {

    public Dispatcher loadDispatcherByUsername(String username) {
        HashMap<String, Dispatcher> map = loadAllDispatchersFromFile();
        return map.get(username);
    }

    public HashMap<String, Dispatcher> loadAllDispatchersFromFile() {
        HashMap<String, Dispatcher> map = new HashMap<String, Dispatcher>();
        try (BufferedReader in = FileUtils.getReader("Dispatcher")) {
            String line;
            in.mark(1);
            if(in.read()!='\ufeff'){
                in.reset();
            }
            while ((line = in.readLine()) != null) {
                Dispatcher d = fromString(line);
                map.put(d.getUsername(),d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    private Dispatcher fromString(String str) {
        String parts[] = str.split(",");
        String korisnickoIme = parts[0];
        String lozinka = parts[1];
        String jmbg = parts[2];
        String email = parts[3];
        OsobaDAO oDAO = new OsobaDAO();
        Osoba o = oDAO.loadOsobaByJmbG(jmbg);
        return new Admin(korisnickoIme, lozinka, o, email);
    }

    public void saveAllAdminToFile(HashMap<String, Admin> map) {
        try (PrintWriter out = FileUtils.getPrintWriter("Admin")) {
            for (Admin a : map.values()) {
                out.println(toFileString(a));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String toFileString(Admin a) {
        KorisnikDAO dao = new KorisnikDAO();
        return dao.toFileString(a) + "," +
                StringUtils.clean(a.getOsoba().getJmbg()) + "," + StringUtils.clean(a.getEmail());
    }

}
