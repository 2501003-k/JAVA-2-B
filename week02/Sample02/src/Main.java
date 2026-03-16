//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        FastFood pizza = new FastFood("경복 피자", 14);

        FastFood donut = new FastFood();
        donut.setName("맛있는 도넛");
        donut.setRadius(6);

        System.out.println(pizza);
        System.out.println(donut);

    }
}