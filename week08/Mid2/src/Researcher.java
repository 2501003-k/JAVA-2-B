public class Researcher extends Regular {
    private final int RESEARCH_PAY = 300000;

    public Researcher(String employeeID, Date birthday, String name, int grade, int step) {
        super(employeeID, birthday, name, grade, step);
    }

    @Override
    protected int incentive() {
        return RESEARCH_PAY;
    }

    @Override
    protected int tax() {
        int pay = basePay(); // 연구수당 제외 (비과세 핵심)

        if (pay <= 2000000)
            return (int)(pay * 0.066);
        else if (pay <= 4000000)
            return (int)(pay * 0.073);
        else
            return (int)(pay * 0.085);
    }

    @Override
    protected String typeName() {
        return "연구직";
    }
}