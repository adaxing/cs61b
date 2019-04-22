public class RotatingSLList<Item> extends SLList<Item> {
	public void rotateRight() {
		Item x = removeLast();
		addFirst(x);
	}
	public static void main(String[] args) {
		RotatingSLList<Integer> L = new RotatingSLList<>();
		L.addLast(10);
		L.addLast(11);
		L.addLast(12);
		L.addLast(13);
		L.rotateRight();
		L.print();
	}
}
