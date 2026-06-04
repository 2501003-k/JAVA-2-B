import java.util.ArrayList;

public class ClassRoom {
    private String className;
    private ArrayList<Student> students;

    public ClassRoom(String className, ArrayList<Student> students) {
        this.className = className;
        this.students = students;
    }

    public String getClassName() {
        return className;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // 반 등수
    protected int getRank(int index) {
        int rank = 1;
        int sum = students.get(index).sum();
        for (int i = 0; i < students.size(); i++)
            if (students.get(i).sum() > sum)
                rank++;
        return rank;
    }

    // 성별 등수
    protected int getGenderRank(String gender, int index) {
        int rank = 1;
        int sum = students.get(index).sum();
        for (int i = 0; i < students.size(); i++)
            if (students.get(i).getGender().equals(gender) &&
                    students.get(i).sum() > sum)
                rank++;
        return rank;
    }

    // 반 평균
    protected double classAverage() {
        double total = 0;
        for (int i = 0; i < students.size(); i++)
            total += students.get(i).average();
        return total / students.size();
    }

    // 성별 + 총점 기준 정렬
    protected void sortByGenderAndSum() {
        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(j).getGender().compareTo(students.get(i).getGender()) > 0) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(j).getGender().equals(students.get(i).getGender())) {
                    if (students.get(j).sum() > students.get(i).sum()) {
                        temp = students.get(i);
                        students.set(i, students.get(j));
                        students.set(j, temp);
                    }
                }
            }
        }
    }
}