public class ArrayBasics {
    public static void main(String[] args) {
        int[] z = null;
        int[] x, y;
        x = new int[]{1, 2, 3, 4, 5};
        y = x;
        x = new int[]{-1, 2, 5, 4, 99};
        y = new int[3];
        z = new int[0];
        int xL = x.length;
        String[] s = new String[6];
        s[4] = "ketchup";
        s[x[3] - x[1]] = "muffins";

        int[] b = {9, 10, 11};
        System.arraycopy(b, 0, x, 3, 2);
        System.out.println("Test y value: ");
        System.out.println(y[1]);
        System.out.println("Test x value: ");
        System.out.println(x[4]);


    }
}