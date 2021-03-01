/** DDLIST adds two pointers to track previous and next
 *  speed up removeLast operation, constant time
 *  extra code complexity */
public class DDList {
    /**
     * IntNode can not access any members of enclosing class
     * save memory, no need to keep track how to access */
    public static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    /** restrict access with private keyword */
    private IntNode sentinel;
    private IntNode last;
    private int size;

    /** create an empty SLList. */
    public DDList() {
        sentinel = new IntNode(63, null);
        last = sentinel;
        size = 0;
    }
    public DDList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        last = sentinel.next;
        size = 1;
    }
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        last = sentinel.next;
        size += 1;
    }
    public int getFirst() {
        return sentinel.next.item;
    }
    public void addLast(int x) {
        size += 1;
        last.next = new IntNode(x, null);
        last = last.next;
    }
    public int getLast() {
        return last.item;
    }
    public void removeLast() {
        size -= 1;
        IntNode p = sentinel;
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
        last = p;
    }
    public static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }
    public int size() {
//        return size(first);
        return size;
    }
    public static void main(String[] args) {
        DDList L = new DDList(1);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(2);
        L.addLast(3);
        L.addLast(4);
        L.removeLast();
        System.out.println(L.getLast());
    }
}