public class SLList {
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
    /** restrict access */
//    private IntNode first;
    private IntNode sentinel;
    private int size;

    /** create an empty SLList. */
    public SLList() {
//        first = null;
        sentinel = new IntNode(63, null);
        size = 0;
    }
    public void SLList(int x) {
//        first = new IntNode(x, null);
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }
    public void addFirst(int x) {
//        first = new IntNode(x, first);
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }
    public int getFirst() {
//        return first.item;
        return sentinel.next.item;
    }
    public void addLast(int x) {
        size += 1;
//        if (first == null) {
//            first = new IntNode(x, null);
//            return;
//        }
//        IntNode p = first;
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
        SLList L = new SLList();
//        L.addFirst(10);
//        L.addFirst(5);
        L.addLast(15);
        System.out.println(L.getFirst());
    }
}