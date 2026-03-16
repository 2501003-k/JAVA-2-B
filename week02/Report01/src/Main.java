public class Main {
    public static void main(String[] args) {

        TV myTV = new TV("Samsung", 2017, 55, "LED");
        System.out.println(myTV);

        System.out.println();

        System.out.println("오늘 TV를 새로 구입하면?");
        TV newTV = new TV("LG", 2026, 65, "OLED");
        System.out.println(newTV);
    }
}