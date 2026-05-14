import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputPath = ".\\data\\sample.txt";
        String outputPath = ".\\data\\sample_copy.txt";
        int count = 0;        // 글자 수
        int lineCount = 0;    // 줄 수

        File file = new File(inputPath);
        if (file.exists()) {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                PrintWriter printWriter = new PrintWriter(outputPath, StandardCharsets.UTF_8);

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    printWriter.println(line);
                    count += (line.length() + 1);
                    lineCount++;
                }

                bufferedReader.close();
                printWriter.close();
                System.out.printf("%,d Bytes(%,d Lines) 복사 완료", count, lineCount);
                Runtime.getRuntime().exec("notepad.exe " + outputPath);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.printf("%s 파일이 존재하지 않습니다.\n", inputPath);
        }
    }
}