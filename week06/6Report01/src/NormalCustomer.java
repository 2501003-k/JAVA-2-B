public class NormalCustomer extends Customer {

    public NormalCustomer(String customerNumber, String name, int usage) {
        super(customerNumber, name, usage);
    }

    @Override
    public boolean isSupportHouse() {
        return false;
    }

    @Override
    public String getEtc() {
        return "";
    }

    // 일반 가구는 무료 사용량 없음
    @Override
    public int getFreeUsage() {
        return 0;
    }
}