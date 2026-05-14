abstract public class Employee extends Person {
    public Employee(String employeeID, Date birthday, String name) {
        super(employeeID, birthday, name);
    }

    abstract protected int basePay();

    protected int incentive() {
        return 0;
    }

    protected int commission() {
        return 0;
    }

    protected int day() {
        return 0;
    }

    protected int dayPay() {
        return 0;
    }

    protected String gradeStep() {
        return "0급-0호";
    }

    protected int grossPay() {
        return basePay() + incentive() + commission();
    }

    protected int tax() {
        if (this instanceof Temporary) {
            return (int)(grossPay() * 0.066);
        }

        if (grossPay() <= 2000000) {
            return (int)(grossPay() * 0.066);
        } else if (grossPay() <= 4000000) {
            return (int)(grossPay() * 0.073);
        } else {
            return (int)(grossPay() * 0.085);
        }
    }

    protected int netPay() {
        return grossPay() - tax();
    }

    abstract protected String typeName();

    @Override
    public String toString() {
        return String.format("%s %7s %3d %,8d원 %,12d원 %,10d원 %,12d원 %,12d원 %,10d원 %,12d원 %-6s",
                super.toString(),
                gradeStep(),
                day(),
                dayPay(),
                basePay(),
                incentive(),
                commission(),
                grossPay(),
                tax(),
                netPay(),
                typeName());
    }
}