public class SupportCustomer extends Customer {

    public SupportCustomer(String customerNumber, String name, int usage) {
        super(customerNumber, name, usage);
    }

    @Override
    public boolean isSupportHouse() {
        return true;
    }

    @Override
    public String getEtc() {
        return "지원가구";
    }

    // 지원 가구는 100Kw까지 무료
    @Override
    public int getFreeUsage() {
        return 100;
    }
}