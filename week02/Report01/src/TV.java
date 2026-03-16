public class TV {

    private String company;
    private int year;
    private int inch;
    private String type;

    // 생성자
    public TV(String company, int year, int inch, String type) {
        this.company = company;
        this.year = year;
        this.inch = inch;
        this.type = type;
    }
    // 메소드
    @Override
    public String toString() {
        return "우리집 TV는 " + company + "에서 만든 "
                + year + "년형 "
                + inch + "인치 "
                + type + " TV 입니다";
    }
}