public class Staff {
    private Employee[] employees;

    public Staff(Employee[] employees) {
        this.employees = employees;
    }

    public int getLength() {
        return employees.length;
    }

    public Employee getEmployee(int index) {
        return employees[index];
    }

    public void setEmployee(int index, Employee employee) {
        employees[index] = employee;
    }
}