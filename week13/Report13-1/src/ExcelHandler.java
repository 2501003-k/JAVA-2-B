import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ExcelHandler {

    // 시트 이름을 받아 해당 반 학생 리스트 반환
    protected ArrayList<Student> readExcel(File file, String sheetName) {
        ArrayList<Student> students = new ArrayList<>();

        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                System.out.printf("시트 '%s'를 찾을 수 없습니다.\n", sheetName);
                workbook.close();
                bufferedInputStream.close();
                return students;
            }

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) continue;
                String studentID = readData(row, 0);
                String name = readData(row, 1);
                String gender = readData(row, 2);
                Student student = new Student(name, gender, studentID);
                for (int j = 0; j < student.getSubjects().size(); j++) {
                    student.setSubject(j,
                            Integer.parseInt(readData(row, j + 3)));
                }
                students.add(student);
            }

            if (students.isEmpty()) {
                System.out.printf("'%s' 시트에 데이터가 없습니다.\n", sheetName);
            } else {
                System.out.printf("'%s' 시트에서 %d명의 데이터를 읽었습니다.\n", sheetName, students.size());
            }

            workbook.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    private String readData(XSSFRow row, int index) {
        XSSFCell cell = row.getCell(index);
        if (cell == null) return "0";
        String value = "";
        if (cell.getCellType() == CellType.STRING) {
            value = cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            value = (int) cell.getNumericCellValue() + "";
        }
        return value;
    }
}