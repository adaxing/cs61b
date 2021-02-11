public class EnHancedForBreakDemo {
    public static void main(String[] args) {
        String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};

        for (String s: a) {
            for (int j = 0; j < 3; j += 1) {
                if (s.contains("horse")) {
                    break;
                }
                System.out.println(s);
            }
        }
    }
}