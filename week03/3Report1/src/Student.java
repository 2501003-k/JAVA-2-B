public class Student {
    String name;
    String rollno;
    String depart;
    Date birthday;

    public Student(String name, String rollno, String depart, Date birthday) {
        this.name = name;
        this.rollno = rollno;
        this.depart = depart;
        this.birthday = birthday;
    }

    public int getAge() {
        int currentYear = 2026; // 현재 연도 (간단하게 고정)
        return currentYear - birthday.year;
    }
}