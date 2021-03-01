/** This version add sentinel node to avoid empty list case */
public class SLListV2 {
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
    private int size;

    /** create an empty SLList. */
    public SLListV2() {
        sentinel = new IntNode(63, null);
        size = 0;
    }
    public SLListV2(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }
    public int getFirst() {
        return sentinel.next.item;
    }
    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;
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
        SLListV2 L = new SLListV2();
//        L.addFirst(10);
//        L.addFirst(5);
        L.addLast(15);
        System.out.println(L.getFirst());
    }
}