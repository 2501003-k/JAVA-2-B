import java.io.IOException;
import java.util.Scanner;

public class Temporary extends Employee implements MyProject {
    private int dayPay;
    private int day;

    public Temporary(String employeeID, Date birthday, String name) {
        super(employeeID, birthday, name);
        this.dayPay = 0;
        this.day = 0;
    }

    protected void inputData() throws IOException {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.printf("[일용직] %s님의 일당 입력 : ", getName());
            dayPay = keyboard.nextInt();

            if (dayPay >= 25000 && dayPay <= 95000) {
                break;
            } else {
                error("일당 범위 오류 (25,000 ~ 95,000원)");
            }
        }

        System.out.printf("[일용직] %s님의 작업 일수 입력 : ", getName());
        day = keyboard.nextInt();
    }

    @Override
    protected int basePay() {
        return dayPay * day;
    }

    @Override
    protected int day() {
        return day;
    }

    @Override
    protected int dayPay() {
        return dayPay;
    }

    @Override
    protected String typeName() {
        return "일당제";
    }
}