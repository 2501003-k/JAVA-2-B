import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.*;
import java.util.ArrayList;

public class PdfHandler {

    private BaseFont baseFont;

    public PdfHandler() {
        try {
            baseFont = BaseFont.createFont(
                    "C:/Windows/Fonts/malgun.ttf",
                    BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED);
        } catch (Exception e) {
            System.out.println("폰트 로드 실패: " + e.getMessage());
        }
    }

    public void writePdf(String fileName, Grade grade) {
        try {
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            Font titleFont = new Font(baseFont, 16, Font.BOLD, BaseColor.RED);
            Font normalFont = new Font(baseFont, 9);
            Font headerFont = new Font(baseFont, 9, Font.BOLD);
            Font rankFont = new Font(baseFont, 9, Font.ITALIC, BaseColor.BLUE);

            ArrayList<ClassRoom> classRooms = grade.getClassRooms();

            for (int c = 0; c < classRooms.size(); c++) {
                ClassRoom classRoom = classRooms.get(c);
                ArrayList<Student> students = classRoom.getStudents();

                // 반 제목
                Paragraph title = new Paragraph(
                        classRoom.getClassName() + " 성적표", titleFont);
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);

                // 반 평균
                Paragraph classAvg = new Paragraph(
                        String.format("반 평균 : %06.2f", classRoom.classAverage()),
                        new Font(baseFont, 10, Font.BOLD, BaseColor.BLUE));
                classAvg.setAlignment(Element.ALIGN_RIGHT);
                document.add(classAvg);

                // 학년 평균
                Paragraph gradeAvg = new Paragraph(
                        String.format("학년 평균 : %06.2f", grade.gradeAverage()),
                        new Font(baseFont, 10, Font.BOLD, BaseColor.BLUE));
                gradeAvg.setAlignment(Element.ALIGN_RIGHT);
                document.add(gradeAvg);

                // 테이블 (15개 컬럼)
                PdfPTable table = new PdfPTable(15);
                table.setWidthPercentage(100);
                float[] widths = {60, 50, 30, 40, 40, 40, 40, 40, 40, 40, 40, 40, 50, 40, 50};
                table.setWidths(widths);

                // 헤더
                addHeader(table, "학번", headerFont);
                addHeader(table, "이름", headerFont);
                addHeader(table, "성별", headerFont);
                addHeader(table, "국어 점수", headerFont);
                addHeader(table, "국어 평점", headerFont);
                addHeader(table, "영어 점수", headerFont);
                addHeader(table, "영어 평점", headerFont);
                addHeader(table, "수학 점수", headerFont);
                addHeader(table, "수학 평점", headerFont);
                addHeader(table, "선택 점수", headerFont);
                addHeader(table, "선택 평점", headerFont);
                addHeader(table, "합계", headerFont);
                addHeader(table, "평균", headerFont);
                addHeader(table, "반 석차", headerFont);
                addHeader(table, "학년 석차", headerFont);

                // 데이터 행
                for (int i = 0; i < students.size(); i++) {
                    Student student = students.get(i);
                    boolean isFemale = student.getGender().equals("여");
                    BaseColor rowColor = isFemale ?
                            new BaseColor(255, 182, 193) :
                            new BaseColor(144, 238, 144);

                    Subject kor    = student.getSubject(0);
                    Subject eng    = student.getSubject(1);
                    Subject math   = student.getSubject(2);
                    Subject option = student.getSubject(3);

                    addRecord(table, student.getStudentID(), rowColor, normalFont);
                    addRecord(table, student.getName(), rowColor, normalFont);
                    addRecord(table, student.getGender(), rowColor, normalFont);
                    addRecord(table, String.valueOf(kor.getScore()), rowColor, normalFont);
                    addRecord(table, kor.getKorGrade(), rowColor, normalFont);
                    addRecord(table, String.valueOf(eng.getScore()), rowColor, normalFont);
                    addRecord(table, eng.getEngMathGrade(), rowColor, normalFont);
                    addRecord(table, String.valueOf(math.getScore()), rowColor, normalFont);
                    addRecord(table, math.getEngMathGrade(), rowColor, normalFont);
                    addRecord(table, String.valueOf(option.getScore()), rowColor, normalFont);
                    addRecord(table, option.getOptionGrade(), rowColor, normalFont);
                    addRecord(table, String.valueOf(student.sum()), rowColor, normalFont);
                    addRecord(table, String.format("%.2f", student.average()), rowColor, normalFont);
                    // 등수 셀: 노란 배경 + 파란 글씨
                    addRecord(table, String.valueOf(classRoom.getRank(i)),
                            new BaseColor(255, 255, 0), rankFont);
                    addRecord(table, String.valueOf(grade.getGradeRank(student)),
                            new BaseColor(255, 255, 0), rankFont);
                }

                document.add(table);

                if (c < classRooms.size() - 1)
                    document.newPage();
            }

            document.close();
            System.out.println("PDF 파일 생성 성공: " + fileName);
        } catch (Exception e) {
            System.out.println("PDF 생성 실패: " + e.getMessage());
        }
    }

    private void addHeader(PdfPTable table, String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new BaseColor(255, 255, 0));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
    }

    private void addRecord(PdfPTable table, String text, BaseColor bgColor, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(bgColor);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
    }
}