public class Regular extends Employee {
    protected int grade;
    protected int step;

    public Regular(String employeeID, Date birthday, String name, int grade, int step) {
        super(employeeID, birthday, name);
        this.grade = grade;
        this.step = step;
    }

    @Override
    protected int basePay() {
        int[][] payTable = {
                {2600, 2800, 3100, 3400, 3800},
                {2650, 2860, 3170, 3480, 3890},
                {2700, 2920, 3240, 3560, 3980},
                {2750, 2980, 3310, 3640, 4070},
                {2800, 3040, 3380, 3720, 4160}
        };

        return payTable[step - 1][grade - 1] * 1000;
    }

    @Override
    protected String gradeStep() {
        return String.format("%d급-%d호", grade, step);
    }

    @Override
    protected String typeName() {
        return "정규직";
    }
}