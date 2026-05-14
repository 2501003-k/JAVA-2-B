import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        String inputPath = ".\\data\\sample.txt";
        String outputPath = ".\\data\\sample_copy.txt";
        int count = 0;

        File file = new File(inputPath);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath, Charset.defaultCharset()));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath, Charset.defaultCharset()));
                int data;
                char[] buffer = new char[8192];

                while ((data = bufferedReader.read(buffer)) != -1) {
                    bufferedWriter.write(buffer, 0, data);
                    count += data;
                }

                bufferedReader.close();
                bufferedWriter.close();
                System.out.printf("%,d Bytes 복사 완료", count);
                Runtime.getRuntime().exec("notepad.exe " + outputPath);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }


        } else {
            System.out.printf("%s 파일이 존재하지 않습니다.\n",inputPath);
        }
    }
}