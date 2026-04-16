import java.util.Scanner;

public class ElectricOffice {
    private Customer[] customers;
    private int count;

    public ElectricOffice(int count) {
        this.count = count;
        customers = new Customer[count];
    }

    public void inputCustomers() {
        Scanner keyboard = new Scanner(System.in);

        for (int i = 0; i < count; i++) {
            String customerNumber;
            String name;
            int usage;

            while (true) {
                System.out.print((i + 1) + "번째 사용자 번호(5자리) 입력 : ");
                customerNumber = keyboard.next();

                if (customerNumber.matches("\\d{5}")) {
                    break;
                } else {
                    System.out.println("오류 : 사용자 번호는 5자리 숫자여야 합니다.");
                }
            }

            System.out.print((i + 1) + "번째 이름 입력 : ");
            name = keyboard.next();

            while (true) {
                System.out.print((i + 1) + "번째 전기 사용량(Kw) 입력 : ");
                usage = keyboard.nextInt();

                if (usage >= 0 && usage <= 9999) {
                    break;
                } else {
                    System.out.println("오류 : 사용량은 0~9999 사이의 정수여야 합니다.");
                }
            }

            if (customerNumber.charAt(0) == '9') {
                customers[i] = new SupportCustomer(customerNumber, name, usage);
            } else {
                customers[i] = new NormalCustomer(customerNumber, name, usage);
            }

            System.out.println();
        }
    }

    public void sortByTotalFeeDescending() {
        for (int i = 0; i < customers.length - 1; i++) {
            for (int j = i + 1; j < customers.length; j++) {
                if (customers[i].getTotalFee() < customers[j].getTotalFee()) {
                    Customer temporaryCustomer = customers[i];
                    customers[i] = customers[j];
                    customers[j] = temporaryCustomer;
                }
            }
        }
    }

    public void printResult() {
        line(82);

        System.out.printf("%-8s %-8s %8s %12s %10s %12s %8s\n",
                "번호", "이름", "사용량", "사용요금", "세금", "납부금액", "기타");

        line(82);

        for (Customer customer : customers) {
            System.out.printf("%-8s %-8s %,7dKw %,12d원 %,10d원 %,12d원 %5s\n",
                    customer.getCustomerNumber(),
                    customer.getName(),
                    customer.getUsage(),
                    customer.getUseFee(),
                    customer.getTax(),
                    customer.getTotalFee(),
                    customer.getEtc());
        }

        line(82);
    }

    public void line(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}