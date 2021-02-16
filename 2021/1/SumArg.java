public class SumArg {
    public static void main(String[] args) {
        int sum = 0;
        for (int i=0; i<args.length; i++) {
            try {
                sum += Integer.parseInt(args[i]);
            } catch (Exception e) {
                System.out.println("Something you type not number!");
                continue;
            }
        }
        System.out.println(sum);
    }
}