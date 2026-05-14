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
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

                OutputStream outputStream = new FileOutputStream(outputPath);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

                int data;
                byte[] buffer = new byte[8192];

                while ((data = bufferedInputStream.read(buffer)) != -1) {
                    bufferedOutputStream.write(buffer, 0, data);
                    System.out.print(".");
                    count += data;
                }
                System.out.printf("\n%,d Bytes 복사 완료", count);
                bufferedInputStream.close();
                bufferedOutputStream.close();
                ProcessBuilder builder = new ProcessBuilder("mspaint ", new File(outputPath).getAbsolutePath());
                builder.start();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }

        } else {
            System.out.printf("%s 파일이 존재하지 않습니다.\n",filePath);
        }
    }
}