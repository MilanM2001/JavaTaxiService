package AllUsers.AllUsersDAO;

import AllUsers.Users;
import Utils.StringUtils;

import java.util.HashMap;

public class UsersDAO {

    public Users loadUserByUsername(String us) {
        return loadAllUsersFromFile().get(us);
    }

    public HashMap<String, Users> loadAllUsersFromFile() {
        HashMap<String, Users> map = new HashMap<String, Users>();

        DispatcherDAO dDAO = new DispatcherDAO();
        map.putAll(dDAO.loadAllDispatchersFromFile());
        DriverDAO drDAO = new DriverDAO();
        map.putAll(drDAO.loadAllDriverFromFile());
        return map;
    }

    public String toFileString(Users u) {
        return StringUtils.clean(u.getUsername()) + "," + StringUtils.clean(u.getPassword());
    }

}
