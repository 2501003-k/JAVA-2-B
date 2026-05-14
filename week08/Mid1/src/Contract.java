public class Contract extends Employee {
    public Contract(String employeeID, Date birthday, String name) {
        super(employeeID, birthday, name);
    }

    @Override
    protected int basePay() {
        return 2000000;
    }

    @Override
    protected String typeName() {
        return "계약직";
    }
}