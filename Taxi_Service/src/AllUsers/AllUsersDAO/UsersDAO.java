package AllUsers.AllUsersDAO;

import AllUsers.Users;
import Utils.StringUtils;

import java.util.HashMap;

public class UsersDAO {

    public Users loadKorisnikByKorisnickoIme(String ki) {
        return loadAllKorisnikFromFile().get(ki);
    }

    public HashMap<String, Users> loadAllKorisnikFromFile() {
        HashMap<String, Users> map = new HashMap<String, Users>();

        DispatcherDAO dDAO = new DispatcherDAO();
        map.putAll(dDAO.loadAllDispatchersFromFile());
        KupacDAO kDAO = new KupacDAO();
        map.putAll(kDAO.loadAllKupacFromFile());
        return map;
    }

    public String toFileString(Users u) {
        return StringUtils.clean(u.getUsername()) + "," + StringUtils.clean(u.getPassword());
    }

}
