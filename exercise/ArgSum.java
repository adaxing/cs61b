public class ArgSum {
	public static void main(String[] args) {
		int i = 0;
		int sum = 0;
		int totalLength = args.length;

		while (i < totalLength) {
			sum += Integer.parseInt(args[i]);
			i += 1;
		}

		System.out.println(sum);
	}
}