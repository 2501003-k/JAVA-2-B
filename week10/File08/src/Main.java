import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputPath = ".\\data\\sample.txt";
        String outputPath = ".\\data\\sample_copy.txt";
        int count = 0;
        int lineCount = 0;

        File file = new File(inputPath);
        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(new FileReader(inputPath, Charset.defaultCharset()));
                PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath, Charset.defaultCharset()));

                String line;

                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    printWriter.println(line);
                    count += (line.length() + 1);
                    lineCount++;
                }

                scanner.close();
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