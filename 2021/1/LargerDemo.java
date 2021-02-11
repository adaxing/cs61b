public class LargerDemo {
    public static int larger(int x, int y) {
        /** return the larger value of x, y */
        if (x > y) {
            return x;
        }
        return y;
    }
    public static void main(String[] args) {
        System.out.println(larger(-9, 10));
    }
}