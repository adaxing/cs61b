/** hides the detail that there exists a null link from the user */
public class SLList {

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

	public IntNode first;
	/** keep track of size */
	private int size;

	public SLList() {
		first = null;
		size = 0;
	}
	public SLList(int x){
		first = new IntNode(x, null);
		size = 1;
	}
	/** return nothing; add x to front */
	public void addFirst(int x) {
		first = new IntNode(x, first);
		size += 1;
	}
	/** return first item in the list */
	public int getFirst() {
		return first.item;
	}
	/** add an item to the end of list */
	public void addLast(int x) {
		/** handle case with list of null */
		if (first == null) {
			first = new IntNode(x, null);
			return;
		}

		IntNode p = first;
		/** move p until it reaches the end of list */
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
		size += 1;
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
	public static void main(String[] args){
		/** creates a list of one integer -> 10 */
		SLList L = new SLList();
		L.addLast(20);
		System.out.println(L.getFirst());
	}
}