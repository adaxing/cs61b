public class LinkedListDeque<T> {
    public class Node {
        public T item;
        public Node prev;
        public Node next;
        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }
    private Node sentinel;
    private int size;
    /** creates an empty linked list deque */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    /** creates a deep copy of other,
     *  an entirely new LinkedListDeque, with the exact same items as other
     *  should be different objects */
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        for (int i=0; i<other.size(); i++) {
            addLast((T) other.get(i));
        }
    }
    public LinkedListDeque(T p) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(p, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }
    /** adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }
    /** adds an item of type T to the back of the deque */
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }
    /** returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        if (sentinel.next.equals(sentinel)) {
            return true;
        } else {
            return false;
        }
    }
    /** returns the number of items in the deque
     *  TODO: take constant time */
    public int size() {
        return size;
    }
    /** prints the items in the deque from first to last,
     *  separated by a space.
     *  once all the items have been printed, print out a new line*/
    public void printDeque() {
        Node p = sentinel.next;
        while (!p.equals(sentinel)) {
            System.out.println(p.item + " ");
            p = p.next;
        }
    }
    /** removes and returns the item at the front of the deque
     *  if no such item exists, returns null */
    public T removeFirst() {
        size -= 1;
        if (isEmpty()) {
            return null;
        } else {
            Node del = sentinel.next;
            T x = del.item;
            sentinel.next = del.next;
            del.next.prev = sentinel;
            del.next = del.prev = null;
            return x;
        }
    }
    /** removes and returns the item at the back of the deque
     *  if no such item exists, returns null */
    public T removeLast() {
        size -= 1;
        if (isEmpty()) {
            return null;
        } else {
            Node del = sentinel.prev;
            T x = del.item;
            sentinel.prev = del.prev;
            del.prev.next = sentinel;
            del.next = del.prev = null;
            return x;
        }
    }
    /** gets the item at the given index, where 0 is the front,
     *  1 is the next item, and so forth, if no such item exists,
     *  returns null. must not alter the deque
     *  TODO: use iteration, not recursion */
    public T get(int index) {
        if (isEmpty()) {
            return null;
        } else {
            Node p = sentinel.next;
            for (int i=0; i<index; i++) {
                p = p.next;
            }
            return p.item;
        }
    }
    private T getRecursive(Node p, int index) {
        if (index == 0) {
            return p.item;
        } else {
            return getRecursive(p.next, index-1);
        }
    }
    /** get function with recursion */
    public T getRecursive(int index) {
        if (isEmpty()) {
            return null;
        } else {
            Node p = sentinel.next;
            return getRecursive(p, index);
        }
    }

}