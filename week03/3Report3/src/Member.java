public class Member {
    private String name;
    private int memberId;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Library library) {
        library.lendBook(this);
    }

    public void returnBook(Library library) {
        library.returnBook(this);
    }
}