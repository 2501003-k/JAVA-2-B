import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String path = ".\\data\\";
        String excelFile = "student.xlsx";
        String outputFile = "studentOut.pdf";

        // 엑셀 시트 이름 (반 이름)
        String[] sheetNames = {"1학년 A반", "1학년 B반"};

        File file = new File(path + excelFile);
        if (file.exists()) {
            ExcelHandler excelHandler = new ExcelHandler();
            ArrayList<ClassRoom> classRooms = new ArrayList<>();

            for (int i = 0; i < sheetNames.length; i++) {
                ArrayList<Student> students = excelHandler.readExcel(file, sheetNames[i]);
                if (!students.isEmpty()) {
                    ClassRoom classRoom = new ClassRoom(sheetNames[i], students);
                    classRoom.sortByGenderAndSum();
                    classRooms.add(classRoom);
                }
            }

            if (classRooms.isEmpty()) {
                System.out.println("읽어온 데이터가 없습니다.");
                return;
            }

            Grade grade = new Grade(classRooms);

            PdfHandler pdfHandler = new PdfHandler();
            pdfHandler.writePdf(path + outputFile, grade);

        } else {
            System.out.printf("%s 파일이 존재하지 않아요.\n", path + excelFile);
        }
    }
}