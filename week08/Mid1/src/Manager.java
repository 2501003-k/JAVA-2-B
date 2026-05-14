public class Manager extends Regular {
    public Manager(String employeeID, Date birthday, String name, int grade, int step) {
        super(employeeID, birthday, name, grade, step);
    }

    @Override
    protected int incentive() {
        if (basePay() <= 1800000) {
            return (int)(basePay() * 0.06);
        } else if (basePay() <= 2400000) {
            return (int)(basePay() * 0.05);
        } else {
            return (int)(basePay() * 0.04);
        }
    }

    @Override
    protected String typeName() {
        return "관리직";
    }
}