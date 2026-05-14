import java.io.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        String filePath = ".\\data\\kbu.jpg"; // .은 상대경로 ..은 상위 디렉터리
        String outputPath = ".\\data\\kbu_copy.jpg";
        int count = 0;

        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("파일이 존재 합니다.");
            try {
                InputStream inputStream = new FileInputStream(file);
                OutputStream outputStream = new FileOutputStream(outputPath);
                int data;

                while ((data = inputStream.read()) != -1) {
                    outputStream.write(data);
                    System.out.print(".");
                    count++;
                }
                System.out.printf("\n%,d Bytes 복사 완료", count);
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }

        } else {
            System.out.printf("%s 파일이 존재하지 않습니다.\n",filePath);
        }
    }
}