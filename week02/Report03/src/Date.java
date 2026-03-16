public class Date {

    // 상태
    private int year;
    private int month;
    private int day;

    // 생성자
    public Date(int year, int month, int day) {
        // 2월은 28일까지 존재한다고 가정
        if(month == 2 && day > 28) {
            System.out.println("존재하지 않는 날짜입니다.");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // 메소드
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return year + "년 " + month + "월 " + day + "일";
    }
}