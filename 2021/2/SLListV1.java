/** This version add size variable to keep track size, speed up size operation */
public class SLListV1 {
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
    private IntNode first;
    private int size;

    /** create an empty SLList. */
    public SLListV1() {
        first = null;
        size = 0;
    }
    public SLListV1(int x) {
        first = new IntNode(x, null);
        size = 1;
    }
    public void addFirst(int x) {
        first = new IntNode(x, first);
        size += 1;
    }
    public int getFirst() {
        return first.item;
    }
    public void addLast(int x) {
        size += 1;
        if (first == null) {
            first = new IntNode(x, null);
            return;
        }
        IntNode p = first;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
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
        SLListV1 L = new SLListV1(1);
//        L.addFirst(10);
//        L.addFirst(5);
        L.addLast(15);
        System.out.println(L.getFirst());
    }
}