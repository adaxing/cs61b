public class LinkedListDeque<T> implements Deque<T>{
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

    public LinkedListDeque(T p) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(p, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }
    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }
    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }
    @Override
    public boolean isEmpty() {
        if (sentinel.next.equals(sentinel)) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        Node p = sentinel.next;
        while (!p.equals(sentinel)) {
            System.out.println(p.item + " ");
            p = p.next;
        }
    }
    @Override
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
    @Override
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
    @Override
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
    public T getRecursive(int index) {
        if (isEmpty()) {
            return null;
        } else {
            Node p = sentinel.next;
            return getRecursive(p, index);
        }
    }

}