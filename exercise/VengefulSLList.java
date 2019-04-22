public class VengefulSLList<Item> extends SLList<Item> {
	/** need to be initialize */
	SLList<Item> deletedItems;

	/** constructor to initialize deletedItems to get rid of nullpointer issues */
	/** default call its superclass's no-argument constructor */
	public VengefulSLList(){
		super();
		deletedItems = new SLList<Item>();
	}
	/** call its superclass with argument constructor */
	public VengefulSLList(Item x){
		super(x);
		deletedItems = new SLList<Item>();
	}

	@Override
	public Item removeLast() {
		/** super is called SLList's removeLast function */
		Item x = super.removeLast();
		deletedItems.addLast(x);
		return x;
	}

	public void printLostItems() {
		deletedItems.print();
	}

	public static void main(String[] args) {
		VengefulSLList<Integer>  L = new VengefulSLList<>();
		L.addLast(1);
		L.addLast(5);
		L.addLast(10);
		L.addLast(13);
		L.removeLast();
		L.print();
		System.out.print("The fallen are: ");
		L.printLostItems();
	}
}