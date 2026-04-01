import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Department[] departments = new Department[] {
                new Department('0', "", 0),
                new Department('1', "경리과", 250000),
                new Department('2', "인사과", 250000),
                new Department('3', "영업팀", 350000),
                new Department('4', "생산과", 350000),
                new Department('5', "A/S팀", 300000)
        };

        Grade[] grades = new Grade[] {
                new Grade('0', 0),
                new Grade('1', 1250000),
                new Grade('2', 925000),
                new Grade('3', 900000),
                new Grade('4', 875000),
                new Grade('5', 650000)
        };

        Employee[] employees = new Employee[] {
                new Employee("홍길동", new Date(2000, 3, 26), "11111", departments[1], grades[1], false, 1),
                new Employee("박춘미", new Date(2001, 5, 10), "12231", departments[3], grades[3], false, 2),
                new Employee("이대학", new Date(1999, 7, 15), "13156", departments[4], grades[4], true, 2),
                new Employee("한아름", new Date(2002, 8, 21), "13211", departments[5], grades[3], false, 3),
                new Employee("새로운", new Date(1998, 11, 3), "16171", departments[4], grades[5], false, 3),
                new Employee("이기쁨", new Date(2000, 1, 18), "17778", departments[3], grades[3], false, 2),
                new Employee("정동진", new Date(1997, 12, 8), "18567", departments[1], grades[2], true, 2),
                new Employee("김진우", new Date(2001, 9, 9), "19129", departments[4], grades[1], false, 1),
                new Employee("오남연", new Date(2000, 6, 30), "19891", departments[3], grades[4], false, 3),
                new Employee("박명길", new Date(1999, 4, 12), "21190", departments[2], grades[2], false, 2)
        };

        Company company = new Company(employees);
        company.inputData();
        company.display();
    }
}