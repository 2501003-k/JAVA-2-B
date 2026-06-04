import java.io.File;
import java.util.ArrayList;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        String path = "data\\";
        String excelFile = "student.xlsx";
        String outputFile = "studentOut.xlsx";
        ArrayList<Student> students;

        File file = new File(path + excelFile);
        if (file.exists()) {
            ExcelHandler handler = new ExcelHandler();
            students = handler.readExcel(file);

            ClassRoom classRoom = new ClassRoom(students);
            classRoom.sortByGenderAndSum();

            handler.writeExcel(path + outputFile, students);
        } else {
            System.out.printf("%s 파일이 존재하지 않아요.\n", path + excelFile);
        }
    }
}