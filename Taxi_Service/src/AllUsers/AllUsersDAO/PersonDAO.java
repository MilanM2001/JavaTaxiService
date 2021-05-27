package AllUsers.AllUsersDAO;

import AllUsers.Person;
import Utils.FileUtils;
import Utils.StringUtils;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class PersonDAO {

    public Person loadPersonByJmbG(String jmbg) {
        HashMap<String, Person> map = loadAllPersonFromFile();
        return map.get(jmbg);
    }

    public HashMap<String, Person> loadAllPersonFromFile() {
        HashMap<String, Person> map = new HashMap<String, Person>();
        try (BufferedReader in = FileUtils.getReader("Person")) {
            String line;
            in.mark(1);
            if(in.read()!='\ufeff'){
                in.reset();
            }
            while ((line = in.readLine()) != null) {
                Person p = fromString(line);
                map.put(p.getJmbg(),p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public Person fromString(String str) {
        String parts[] = str.split(",");
        String name = parts[0];
        String lastName = parts[1];
        String jmbg = parts[2];
        return new Person(name, lastName, jmbg);
    }

    public void saveAllPersonToFile(HashMap<String, Person> map) {
        try (PrintWriter out = FileUtils.getPrintWriter("Person")) {
            for (Person p : map.values()) {
                out.println(toFileString(p));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toFileString(Person p) {
        return StringUtils.clean(p.getName()) + "," + StringUtils.clean(p.getLastName())
                + "," + StringUtils.clean(p.getJmbg());
    }

}
