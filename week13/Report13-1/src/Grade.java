import java.util.ArrayList;

public class Grade {
    private ArrayList<ClassRoom> classRooms;

    public Grade(ArrayList<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }

    public ArrayList<ClassRoom> getClassRooms() {
        return classRooms;
    }

    // 전체 학생 리스트
    private ArrayList<Student> getAllStudents() {
        ArrayList<Student> all = new ArrayList<>();
        for (int i = 0; i < classRooms.size(); i++)
            all.addAll(classRooms.get(i).getStudents());
        return all;
    }

    // 학년 전체 등수
    protected int getGradeRank(Student target) {
        int rank = 1;
        ArrayList<Student> all = getAllStudents();
        for (int i = 0; i < all.size(); i++)
            if (all.get(i).sum() > target.sum())
                rank++;
        return rank;
    }

    // 학년 평균
    protected double gradeAverage() {
        ArrayList<Student> all = getAllStudents();
        double total = 0;
        for (int i = 0; i < all.size(); i++)
            total += all.get(i).average();
        return total / all.size();
    }
}