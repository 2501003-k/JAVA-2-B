public class Main {

    public static void main(String[] args) {

        // 1. 본인의 생년월일
        Date birth = new Date(2000, 8, 14);
        System.out.println("생년월일 : " + birth);
        System.out.println();

        // 2. 오늘 날짜
        Date today = new Date(2026, 3, 16);
        System.out.println("오늘 날짜 : " + today);
        System.out.println();

        // 3. 존재하지 않는 날짜
        Date errorDate = new Date(2025, 2, 29);
        System.out.println("지정한 날짜 : " + errorDate);
        System.out.println();

        // 4. 년도 수정
        errorDate.setYear(2023);
        System.out.println("년도 수정 후 : " + errorDate);
    }
}