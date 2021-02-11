public class Max {
    public static int max(int[] m) {
        int i = 1;
        int max = m[0];
        /** FOR LOOP
         * for (int i=1; i<m.length; i++){
         *          if (m[i] > max) {
         *            max = m[i];
         *          }
         *       }
         */
        while (i < m.length) {
            if (max < m[i]) {
                max = m[i];
            }
            i++;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));
    }
}