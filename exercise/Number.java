public class Number {
	/** return cumulative sum */
	public static void main(String[] args) {
		int sum = 0;
		int x = 0;
		while (x<10) {
			sum += x;
			System.out.print(sum + " ");
			x += 1;
		}
		/** print new line after return cumulative sum */
		System.out.printf("%n");
	}
}