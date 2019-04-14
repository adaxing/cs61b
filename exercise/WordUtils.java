public class WordUtils {
	/** return the longest length string of list */
	public static String longest(List61B<String> list) {
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
		System.out.println("SLList example: " + longest(L));
		AList<String> Alist = new AList<>();
		Alist.addLast("zxc");
		Alist.addLast("poiuy");
		Alist.addLast("uhendyebc");
		System.out.println("AList example: " + longest(Alist));

	}
}