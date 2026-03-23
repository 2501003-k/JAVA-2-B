public class Main {
    public static void main(String[] args) {

        Date birth = new Date(2000, 8, 14);

        Student student = new Student(
                "강성우",
                "2501003",
                "소프트웨어융합과",
                birth
        );

        System.out.println("이름: " + student.name);
        System.out.println("나이: " + student.getAge());
    }
}