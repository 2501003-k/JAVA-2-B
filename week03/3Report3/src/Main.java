public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Book book = new Book("자바 프로그래밍");

        library.addBook(book);

        Member member = new Member("홍길동", 1);

        member.borrowBook(library);
        member.returnBook(library);
    }
}