public interface List61B<Item> {
	public void addLast(Item x);
	public Item getLast();
	public void addFirst(Item x);
	public Item getFirst();
	public Item get(int i);
	public int size();
	public Item removeLast();
	default public void print() {
		for (int i=0; i<size(); i=i+1) {
			System.out.print(get(i)+" ");
		}
		System.out.println();
	}
}