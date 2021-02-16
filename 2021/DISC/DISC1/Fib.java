public class Fib {
    public static int fib(int n) {
        /** recursive way */
        if (n == 0) {
            return 0;
        }  else if (n == 1) {
            return 1;
        } else {
            return fib(n-1) +fib(n-2);
        }
        /** iterative */
//        int[] num = new int[n+1];
//        if (n >= 1) {
//            num[0] = 0;
//            num[1] = 1;
//            for (int i=2; i<=n; i++) {
//                num[i] = num[i-1] + num[i-2];
//            }
//        }
//        return num[n];
        /** answer */
//        if (n <= 1) {
//            return n;
//        } else {
//            return fib(n-1) + fib(n-2);
//        }
    }
    public static int fib2(int n, int k, int f0, int f1) {
        /** Implemnt fib in 5 lines or fewer */
        if (n == k) {
            return f0;
        } else {
            return fib2(n, k+1, f1, f0+f1);
        }
    }

    public static void main(String[] args) {
        System.out.print(fib2(7, 0, 0, 1));
    }
}