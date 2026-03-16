import java.io.IOException;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {
        Adder adder = new Adder();

        adder.setStart(adder.readData("시작 숫자를 입력"));
        adder.setLast(adder.readData("마지막 숫자 입력"));

        System.out.println(adder);

    }
}