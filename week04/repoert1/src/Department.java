public class Department {
    private char part;
    private String partName;
    private int workPay;

    public Department(char part, String partName, int workPay) {
        this.part = part;
        this.partName = partName;
        this.workPay = workPay;
    }

    public String getDepartName() {
        return partName;
    }

    public int getWorkPay() {
        return workPay;
    }
}