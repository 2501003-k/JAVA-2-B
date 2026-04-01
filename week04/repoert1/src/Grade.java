public class Grade {
    private char classNo;
    private int salary;

    public Grade(char classNo, int salary) {
        this.classNo = classNo;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public char getGrade() {
        return classNo;
    }
}