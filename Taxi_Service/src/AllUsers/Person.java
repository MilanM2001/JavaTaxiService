package AllUsers;

import Utils.StringUtils;

public class Person {

    private String name;
    private String lastName;
    private String jmbg;

    public Person(String name, String lastName, String jmbg) {
        this.name = name;
        this.lastName = lastName;
        this.jmbg = jmbg;
    }

    @Override
    public String toString() {
        return StringUtils.clean(name) + " " + StringUtils.clean(lastName) + " " + StringUtils.clean(jmbg);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getJmbg() {
        return jmbg;
    }
    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

}
