public class Main {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("영희", 24, "수학");
        Doctor doctor = new Doctor("철수", 45, "서울병원");
        Engineer engineer = new Engineer("민수", 35, "백엔드");

        teacher.introduce();
        doctor.introduce();
        engineer.introduce();

        teacher.teach();
        teacher.grade();

        doctor.treat();
        doctor.operate();

        engineer.develop();
        engineer.fixBug();
    }
}