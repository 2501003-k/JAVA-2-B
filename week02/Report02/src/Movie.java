public class Movie {

    // 상태
    private String title;
    private String director;
    private int open;
    private String mainActor;
    private double rankPoint;

    // 생성자
    public Movie(String title, String director, int open, String mainActor, double rankPoint) {
        this.title = title;
        this.director = director;
        this.open = open;
        this.mainActor = mainActor;
        this.rankPoint = rankPoint;
    }

    // 메소드
    public void setRankPoint(double rankPoint) {
        this.rankPoint = rankPoint;
    }

    public String getDirector() {
        return director;
    }

    // 메소드
    @Override
    public String toString() {
        return "제목 : " + title + "\n"
                + "감독 : " + director + "\n"
                + "개봉 : " + open + "\n"
                + "주연 : " + mainActor + "\n"
                + "평점 : " + rankPoint;
    }
}