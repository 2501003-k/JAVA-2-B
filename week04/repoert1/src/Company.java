import java.io.IOException;

public class Company {

    private Employee[] employees;

    public Company(Employee[] employees) {
        this.employees = employees;
    }

    protected void inputData() throws IOException {
        for (int i = 0; i < employees.length; i++)
            employees[i].inputAid();
    }

    protected void sortByPay() {
        Employee temp;

        for (int i = 0; i < employees.length - 1; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                if (employees[i].net() < employees[j].net()) {
                    temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
    }

    protected void display() {
        sortByPay();
        line();

        System.out.println("  이름      사번      부서명     원호  급-호         본봉          업무수당      직급수당      공제금액      세금     수령액");

        line();

        for (int i = 0; i < employees.length; i++)
            System.out.println(employees[i]);

        line();
    }

    private void line() {
        for (int i = 0; i < 120; i++)
            System.out.print("-");
        System.out.println();
    }
}