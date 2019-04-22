/** hides the detail that there exists a null link from the user */
public class SLList<Item> implements List61B<Item> {

	/** Can not access any out of class
		save tiny memory as each IntNode
		no longer needs to keep track of 
		how to access enclosing SLList */
	private class Node {
		public Item items;
		public Node next;

		public Node(Item i, Node n) {
			items = i;
			next = n;
		}
	}

	public Node first;
	/** keep track of size */
	private int size;

	public SLList() {
		first = null;
		size = 0;
	}
	public Item get(int i) {
		if (i >= size) {
			return null;
		}
		else if (i == 0) {
			return first.items;
		}
		Node p = first;
		for (int j=0; j<=i; j++) {
			p = p.next;
		}
		return p.items;
	} 
	public SLList(Item x){
		first = new Node(x, null);
		size = 1;
	}
	/** return nothing; add x to front */
	public void addFirst(Item x) {
		Node oldFirst = first.next;
		Node newNode = new Node(x, oldFirst);
		first.next = newNode;
		size += 1;
	}
	/** return first item in the list */
	public Item getFirst() {
		return first.items;
	}
	private Node getLastNode() {
		Node p = first;
		/** move p until it reaches the end of list */
		while (p.next != null) {
			p = p.next;
		}
		return p;
	}
	/** return last node */
	public Item getLast() {
		Node last = getLastNode();
		return last.items;
	}
	/** delete and return last item */
	public Item removeLast() {
		Node last = getLastNode();
		if (last == first) {
			return null;
		}
		Node p = first;
		while (p.next != last) {
			p = p.next;
		}
		p.next = null;
		return last.items;
	}
	/** add an item to the end of list */
	public void addLast(Item x) {
		/** handle case with list of null */
		if (first == null) {
			first = new Node(x, null);
		}

		Node p = first;
		/** move p until it reaches the end of list */
		while (p.next != null) {
			p = p.next;
		}
		p.next = new Node(x, null);
		size += 1;
	}
	/** helper method  */
	/** Returns the size of the list that starts at IntNode p. */
	private int size(Node p) {
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
	/** prints the list */
	@Override
	public void print() {
		for (Node p=first.next; p!=null; p=p.next) {
			System.out.print(p.items + " ");
		}
		System.out.println();
	}

	// public static void main(String[] args){
	// 	/** creates a list of one integer -> 10 */
	// 	SLList<String> L = new SLList<>();
	// 	L.addLast("abc");
	// 	L.addLast("de");
	// 	L.addLast("lalalala");
	// 	System.out.println(L.get(3));
	// }
}