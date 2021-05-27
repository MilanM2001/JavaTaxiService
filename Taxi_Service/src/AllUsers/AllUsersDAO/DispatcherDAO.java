package AllUsers.AllUsersDAO;

import AllUsers.Dispatcher;
import AllUsers.Person;
import Enums.Gender;
import Utils.FileUtils;
import Utils.StringUtils;

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
        String username = parts[0];
        String password = parts[1];
        String address = parts[2];
        String phoneNumber = parts[3];
        boolean gender = Gender.Female(parts[4]);
        PersonDAO personDAO = new PersonDAO();
        Person p = personDAO.loadPersonByJmbG(jmbg);
        return new Dispatcher(korisnickoIme, lozinka, o, email);
    }

    public void saveAllDispatcherToFile(HashMap<String, Dispatcher> map) {
        try (PrintWriter out = FileUtils.getPrintWriter("Dispatcher")) {
            for (Dispatcher d : map.values()) {
                out.println(toFileString(d));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String toFileString(Dispatcher d) {
        UsersDAO dao = new UsersDAO();
        return dao.toFileString(d) + "," +
                StringUtils.clean(a.getOsoba().getJmbg()) + "," + StringUtils.clean(a.getEmail());
    }

}
