package lab4;

/**
 * Class which is describing an entity Human
 */
public class Human {

    private int ID;
    private String name;
    private String gender;
    private Division division;
    private int salary;
    private String birthday;

    /** Default constructor for an object of the Human class */
    public Human() {
        this.ID = 0;
        this.name = "";
        this.gender = "";
        this.division = null;
        this.salary = 0;
        this.birthday = null;
    }

    /** Constructor with parameters for an object of the Human class */
    public Human(int ID, String name, String gender, Division division, int salary, String birthday) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
        this.birthday = birthday;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Division getDepartment() {
        return division;
    }

    public void setDepartment(Division division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "ID: " + this.getID() +
                "\nИмя: " + this.getName() +
                "\nПол: " + this.getGender() +
                "\nЗарплата: " + this.getSalary() +
                "\nДата рождения: " + this.getBirthday();
    }
}