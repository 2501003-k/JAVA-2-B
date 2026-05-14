public class Person {
    private String employeeID;
    private Date birthday;
    private String name;

    public Person(String employeeID, Date birthday, String name) {
        this.employeeID = employeeID;
        this.birthday = birthday;
        this.name = name;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%6s %3s(%s)", employeeID, name, birthday);
    }
}