public class IntList {
	/** Instance variable */
	public int first;
	/** Pointer  */
	public IntList rest;

	/** Constructor */
	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using recursion */
	public int size() {
		/** why not set 'this == null'?
			if list L is null, when list call method size() will raise NullPointerException
		*/
		if (this.rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}
	/** Return the size of the list using iteration */
	public int iterativeSize() {
		/** set pointer */ 
		IntList p = this;
		int length = 0;
		while (p != null) {
			length += 1;
			p = p.rest;
		}
		return length;

	}

	/** Return the ith item of the list using iteration 
		Problem:
			what if index out of list?
	*/
	public int get(int i) {
		/** set pointer */
		IntList p = this;
		int j = 0;
		while (j < i) {
			p = p.rest;
			j++;
		}
		return p.first;
	}

	/** Return the ith item of the list using recursion */
	public int getValue(int i) {
		/** base case */
		if (i == 0) {
			return first;
		}
		return rest.getValue(i-1);
	}

	/** Increment list by x value */
	public static IntList incrList(IntList L, int x) {
		IntList newList = L;
		for (int i=0; i<L.size(); i++) {
			newList.first += x;
			newList = newList.rest;
		}
		return L;
	}

	/** Decrement list by x value */
	public static IntList decrList(IntList L, int x) {
		IntList newList = L;
		for (int i=0; i<L.size(); i++) {
			newList.first -= x;
			newList = newList.rest;
		}
		return L;
	}

	/** Main method */
	public static void main(String[] args) {
		IntList L = new IntList(5, null);
		L.rest = new IntList(10, null);
		L.rest.rest = new IntList(15, null);

		System.out.println(decrList(L, 2));
	}
}