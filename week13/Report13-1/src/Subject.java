public class Subject {
    private String subjectName;
    private int score;

    public Subject(String subjectName, int score) {
        this.subjectName = subjectName;
        this.score = score;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getScore() {
        return score;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // 국어 평점: 수/우/미/양/가 (switch-case)
    public String getKorGrade() {
        int s = score / 10;
        switch (s) {
            case 10:
            case 9: return "수";
            case 8: return "우";
            case 7: return "미";
            case 6: return "양";
            default: return "가";
        }
    }

    // 영어/수학 평점: A0, A+, B0, B+, C0, C+, D0, D+, F (switch-case)
    public String getEngMathGrade() {
        int s = score / 5;
        switch (s) {
            case 20: case 19: return "A0";
            case 18: return "A+";
            case 17: return "B0";
            case 16: return "B+";
            case 15: return "C0";
            case 14: return "C+";
            case 13: return "D0";
            case 12: return "D+";
            default: return "F";
        }
    }

    // 선택과목 평점: A, B, C, D, F (if-else)
    public String getOptionGrade() {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }
}