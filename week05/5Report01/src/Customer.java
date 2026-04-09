public class Customer extends Person {
    protected String customerNumber;
    protected int usage;   // 사용량
    protected final int BASE_FEE = 1660;

    public Customer(String customerNumber, String name, int usage) {
        super(name);
        this.customerNumber = customerNumber;
        this.usage = usage;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public int getUsage() {
        return usage;
    }

    public boolean isSupportHouse() {
        return false;
    }

    public String getEtc() {
        return "";
    }

    // 일반 가구는 무료 사용량 없음
    protected int getFreeUsage() {
        return 0;
    }

    // 사용요금 = 기본요금 + (사용량에 따른 전력량 요금)
    public int getUseFee() {
        float energyFee = calculateEnergyFee();
        return (int)(BASE_FEE + energyFee);
    }

    // 세금 = 사용요금의 7%
    public int getTax() {
        return (int)(getUseFee() * 0.07f);
    }

    // 납부금액 = 사용요금 + 세금
    public int getTotalFee() {
        return getUseFee() + getTax();
    }

    // 구간별 누진 계산
    protected float calculateEnergyFee() {
        int billableUsage = usage - getFreeUsage();

        if (billableUsage < 0) {
            billableUsage = 0;
        }

        float fee = 0.0f;
        int remainingUsage = billableUsage;

        if (remainingUsage > 0) {
            int currentUsage = Math.min(remainingUsage, 100);
            fee += currentUsage * 184.1f;
            remainingUsage -= currentUsage;
        }

        if (remainingUsage > 0) {
            int currentUsage = Math.min(remainingUsage, 100);
            fee += currentUsage * 223.8f;
            remainingUsage -= currentUsage;
        }

        if (remainingUsage > 0) {
            int currentUsage = Math.min(remainingUsage, 100);
            fee += currentUsage * 278.3f;
            remainingUsage -= currentUsage;
        }

        if (remainingUsage > 0) {
            int currentUsage = Math.min(remainingUsage, 100);
            fee += currentUsage * 353.6f;
            remainingUsage -= currentUsage;
        }

        if (remainingUsage > 0) {
            int currentUsage = Math.min(remainingUsage, 100);
            fee += currentUsage * 466.4f;
            remainingUsage -= currentUsage;
        }

        if (remainingUsage > 0) {
            fee += remainingUsage * 643.9f;
        }

        return fee;
    }
}