public class Teacher extends Person {

    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void teach() {
        System.out.println(name + " 선생님이 수업을 합니다.");
    }

    public void grade() {
        System.out.println(name + " 선생님이 과제를 채점합니다.");
    }
}