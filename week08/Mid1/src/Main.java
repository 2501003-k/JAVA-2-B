import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Employee[] employees = new Employee[] {
                new Salesman("424561", new Date(2012, 4, 20), "최명길", 3, 2),
                new Salesman("124655", new Date(2013, 12, 20), "정통파", 2, 3),
                new Regular("348967", new Date(1987, 6, 22), "진검무", 4, 5),
                new Salesman("124567", new Date(2011, 4, 19), "한송이", 3, 4),
                new Manager("245778", new Date(2012, 12, 20), "한민국", 3, 1),
                new Regular("234567", new Date(2010, 3, 7), "홍길동", 2, 3),
                new Regular("348988", new Date(2011, 8, 10), "코로나", 1, 4),
                new Manager("345678", new Date(2012, 7, 20), "한국인", 1, 1),
                new Temporary("456213", new Date(1999, 5, 13), "이대한"),
                new Temporary("123456", new Date(1993, 10, 5), "경복대")
        };

        Staff staff = new Staff(employees);
        Company company = new Company(staff);

        company.inputData();
        company.display();
    }
}