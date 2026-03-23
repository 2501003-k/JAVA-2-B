public class Library {
    private Book book;

    public void addBook(Book book) {
        this.book = book;
    }

    public void lendBook(Member member) {
        if (!book.isBorrowed()) {
            book.borrow();
            System.out.println(member.getName() + "님이 "
                    + book.getTitle() + " 책을 대출했습니다.");
        } else {
            System.out.println("이미 대출된 책입니다.");
        }
    }

    public void returnBook(Member member) {
        book.returnBook();
        System.out.println(member.getName() + "님이 "
                + book.getTitle() + " 책을 반납했습니다.");
    }
}