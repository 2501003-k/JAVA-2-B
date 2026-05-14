import java.io.IOException;

public class Company {
    private Staff staff;

    public Company(Staff staff) {
        this.staff = staff;
    }

    protected void inputData() throws IOException {
        for (int i = 0; i < staff.getLength(); i++) {
            if (staff.getEmployee(i) instanceof Temporary) {
                ((Temporary) staff.getEmployee(i)).inputData();
                System.out.println();
            }
        }

        for (int i = 0; i < staff.getLength(); i++) {
            if (staff.getEmployee(i) instanceof Salesman) {
                ((Salesman) staff.getEmployee(i)).inputData();
                System.out.println();
            }
        }
    }

    protected void sortByNetPay() {
        for (int i = 0; i < staff.getLength() - 1; i++) {
            for (int j = 0; j < staff.getLength() - 1 - i; j++) {
                if (staff.getEmployee(j).netPay() < staff.getEmployee(j + 1).netPay()) {
                    Employee temp = staff.getEmployee(j);
                    staff.setEmployee(j, staff.getEmployee(j + 1));
                    staff.setEmployee(j + 1, temp);
                }
            }
        }
    }

    protected void display() {
        sortByNetPay();

        System.out.println("\n\t\t\t경복주식회사 급여 대장");
        line();
        System.out.println("    사번         이름           급-호    day      일당      기본급            인센티브       커미션        급여액         세금         지급액      비고");
        line();

        int total = 0;

        for (int i = 0; i < staff.getLength(); i++) {
            System.out.println(staff.getEmployee(i));
            total += staff.getEmployee(i).netPay();
        }

        line();
        System.out.printf("\t\t\t\t\t\t지급액 합계 : %,d 원\n", total);
        line();
    }

    private void line() {
        for (int i = 0; i < 145; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}