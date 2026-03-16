public class Book {

    // 상태
    private String title;
    private String author;

    // 생성자
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // 메소드
    @Override
    public String toString() {
        return "책 제목 : " + title + ", 저자 : " + author;
    }
}