/** hides the detail that there exists a null link from the user */
public class SeSLList {

	/** Can not access any out of class
		save tiny memory as each IntNode
		no longer needs to keep track of 
		how to access enclosing SLList */
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	}

	/** The first item (if it is exists) is at sentinel.next */
	private IntNode sentinel;
	public IntNode first;
	/** keep track of size */
	private int size;
	private IntNode last;

	public SeSLList() {
		/** 61 does not mean anything, just for replacing ?? */
		sentinel = new IntNode(61, null);
		size = 0;
	}
	public SeSLList(int x){
		sentinel = new IntNode(61, null);
		sentinel.next = last = new IntNode(x, null);
		//sentinel.next.next = last;
		size = 1;
	}
	/** return nothing; add x to front */
	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		last.next = last;
		//sentinel.next.next = last;
		size += 1;
	}
	/** return first item in the list */
	public int getFirst() {
		return sentinel.next.item;
	}
	/** return last item in the list */
	public int getLast() {
		return last.item;
	}
	/** add an item to the end of list */
	public void addLast(int x) {
	
		/** EXCEPTION case when empty list has 
			null first -> can not access first.next */
		// IntNode p = sentinel;
		// /** move p until it reaches the end of list */
		// while (p.next != null) {
		// 	p = p.next;
		// }
		// p.next = new IntNode(x, null);
		IntNode p = new IntNode(x, null);
		if (sentinel.next == null) {
			sentinel.next = last = p;
			size += 1;
			return;
		}
		last.next = p;
		last = p;
		size += 1;
		return;
	}
	public void removeFirst() {
		sentinel.next = sentinel.next.next;
	}
	/** helper method  */
	/** Returns the size of the list that starts at IntNode p. */
	private static int size(IntNode p) {
		if (p.next == null) {
			return 1;
		}
		return 1 + size(p.next);
	}

	/** return size of the list */
	public int size() {
		// IntNode p = first;
		// int size = 1;
		// while (p.next != null) {
		// 	p = p.next;
		// 	size += 1;
		// }
		/** caching to speed up */
		return size;
	}
	public int returns() {
		System.out.println(last.item);
		return 1;
	}
	public static void main(String[] args){
		/** creates a list of one integer -> 10 */
		SeSLList L = new SeSLList(10);
		L.addFirst(20);
		L.addLast(25);
		//L.addLast(30);
		//L.addLast(40);
		L.removeFirst();
		System.out.println(L.getLast());
	}
}