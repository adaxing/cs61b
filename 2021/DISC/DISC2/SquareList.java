import java.util.Arrays;

public class SquareList {
    /** squared value of IntList */
    public static int[] square(int[] L) {
        /** non-destructive approach with recursion by creating new IntLists */
        int[] res = new int[L.length];
        for (int i=0; i<L.length; i++) {
            res[i] = L[i] * L[i];
        }
        return res;
    }

    public static int[] squareDestructive(int[] L) {
        /** recursive approach to change the instance varibales of input IntLists */
        for (int i=0; i<L.length; i++) {
            L[i] *= L[i];
        }
        return L;
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,2,4,6};
        System.out.println("Non-des way: " + Arrays.toString(square(a)));
        System.out.println("Des way: " + Arrays.toString(square(a)));
    }
}