public class Alist<Item> {

	private Item[] items;
	private int size;
	/** creates an empty list */
	public Alist() {
		items = (Item[]) new Object[100];
		size = 0;
	}
	/** inserts x into the back of list */
	public void addLast(Item x) {
		if (size == items.length) {
			resize(size+1);
		}
		items[size] = x;
		size++;

	}
	/** Since size of alist is set to 100 max
		what if we need more space we can resize by this function */
	public void resize(int x) {
		Item[] a = (Item[]) new Object[x];
		System.arraycopy(items, 0, a, 0, size);
		items = a;
	} 
	/** return the item from back of list */
	public Item getLast() {
		return items[size-1];
	}
	/** get the ith item in the list */
	public Item get(int i) {
		return items[i];
	}
	/** return the number of items in the list */
	public int size() {
		return size;
	}
	/** deletes item from back of list and return deleted item */
	public Item removeLast() {
		/** by copying new array, actually there is no need to do
			since it will take longer time */
		// int[] newArray = new int[items.length];
		// int delectedItem = items[size-1];
		// System.arraycopy(items, 0, newArray, 0, size-1);
		// items = newArray;
		// System.out.println(items[3]);
		Item delectedItem = getLast();
		size = size - 1;
		return delectedItem;
	}
	public static void main(String[] args) {
		Alist L = new Alist();
		L.addLast(1);
		L.addLast(2);
		L.addLast(4);
		L.addLast(7);
		L.addLast(9);
		System.out.println(L.removeLast());
	}
}