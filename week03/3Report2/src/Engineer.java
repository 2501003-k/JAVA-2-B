public class Engineer extends Person {
    private String field;

    public Engineer(String name, int age, String field) {
        super(name, age);
        this.field = field;
    }

    public void develop() {
        System.out.println(name + " 엔지니어가 프로그램을 개발합니다.");
    }

    public void fixBug() {
        System.out.println(name + " 엔지니어가 프로젝트의 버그를 수정합니다.");
    }
}