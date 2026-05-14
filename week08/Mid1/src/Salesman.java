import java.io.IOException;
import java.util.Scanner;

public class Salesman extends Regular implements MyProject {
    private int sale;
    private double commissionRate;

    public Salesman(String employeeID, Date birthday, String name, int grade, int step) {
        super(employeeID, birthday, name, grade, step);
        this.sale = 0;
        this.commissionRate = 0.0;
    }

    protected void inputData() throws IOException {
        Scanner keyboard = new Scanner(System.in);

        System.out.printf("[영업직] %s님의 판매 금액 입력 : ", getName());
        sale = keyboard.nextInt();

        while (true) {
            System.out.printf("[영업직] %s님의 커미션 비율 입력 : ", getName());
            commissionRate = keyboard.nextDouble();

            if (commissionRate >= 0.0 && commissionRate <= 5.0) {
                break;
            } else {
                error("커미션 비율 오류 (0 ~ 5%)");
            }
        }
    }

    @Override
    protected int commission() {
        return (int)(sale * (commissionRate / 100.0));
    }

    @Override
    protected String typeName() {
        return "영업직";
    }
}