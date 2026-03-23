public class Doctor extends Person {

    private String hospital;

    public Doctor(String name, int age, String hospital) {
        super(name, age);
        this.hospital = hospital;
    }

    public void treat() {
        System.out.println(name + " 의사가 환자를 진료합니다.");
    }

    public void operate() {
        System.out.println(name + " 의사가 수술도 진행합니다.");
    }
}