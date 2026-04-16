import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int customerCount;

        while (true) {
            System.out.print("입력할 데이터 개수 입력(최소 10개) : ");
            customerCount = keyboard.nextInt();

            if (customerCount >= 10) {
                break;
            } else {
                System.out.println("오류 : 데이터는 최소 10개 이상이어야 합니다.");
            }
        }

        ElectricOffice electricOffice = new ElectricOffice(customerCount);

        electricOffice.inputCustomers();
        electricOffice.sortByTotalFeeDescending();
        electricOffice.printResult();
    }
}