public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        while (x <= 45) {
            System.out.println(x);
            y++;
            x = x + y;
        }
    }
}