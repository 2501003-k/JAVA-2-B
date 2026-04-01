import java.io.IOException;
import java.util.Scanner;

public class Employee extends Person {

    private String id;          // 사번
    private Department part;    // 부서
    private boolean special;    // 보훈
    private int grade;          // 직급 (1~3)
    private Grade classNo;      // 호봉
    private int aid;            // 공제액

    public Employee(String name, Date birthday, String id,
                    Department part, Grade classNo,
                    boolean special, int grade) {
        super(name, birthday);
        this.id = id;
        this.part = part;
        this.classNo = classNo;
        this.special = special;
        this.grade = grade;
    }

    public void inputAid() throws IOException {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.printf("%s님의 공제금액 입력 : ", super.getName());
            aid = keyboard.nextInt();

            if (aid >= 0 && aid <= 300000)
                break;
            else {
                System.err.print("ERROR : 공제금액 오류");
                System.in.read();
            }
        }
    }

    private int positionPay() {
        if (grade == 1) return 300000;
        else if (grade == 2) return 200000;
        else return 100000;
    }

    private int workPay() {
        return part.getWorkPay();
    }

    private int gross() {
        return classNo.getSalary() + workPay() + positionPay();
    }

    private int basicDeduction() {
        return (int)(classNo.getSalary() * 0.03);
    }

    private int taxable() {
        return gross() - basicDeduction() - aid;
    }

    private int tax() {
        int tax;

        if (special)
            tax = (int)(classNo.getSalary() * 0.0003);
        else
            tax = (int)(taxable() * 0.0007);

        return tax;
    }

    protected int net() {
        return gross() - aid - tax();
    }

    @Override
    public String toString() {
        return String.format("%-8s %-8s %-8s %-4s %-6s %,12d %,12d %,12d %,12d %,8d %,12d",
                super.getName(),
                id,
                part.getDepartName(),
                special ? "O" : "X",
                grade + "-" + classNo.getGrade(),
                classNo.getSalary(),
                workPay(),
                positionPay(),
                aid,
                tax(),
                net());
    }
}