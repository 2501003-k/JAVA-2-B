//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Adder problem1 = new Adder(5, 3);

        System.out.println(problem1);
        Adder[] problem = new Adder[]{
                new Adder(5, 8),
                new Adder(8, 12),
                new Adder(8, 17)};

        for (int i = 0; i < problem.length; i++)
            System.out.println(problem[i]);

    }
}