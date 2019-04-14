public class WordUtils {
	public static String longest(SLList<String> list) {
		String max = list.get(0);
		for (int i=1; i<list.size(); i++) {
			if (list.get(i).length() > max.length()) {
				max = list.get(i);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		SLList<String> L = new SLList<>();
		L.addLast("abcfh");
		L.addLast("deccvghjhjhbh");
		L.addLast("lalalalal");
		System.out.println(longest(L));
	}
}