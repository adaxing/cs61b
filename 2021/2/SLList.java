/** add generic, not only restrict integer
 * parametrize, add type*/
public class SLList<TypeNess> {
    public class StuffNode {
        public TypeNess item;
        public StuffNode next;

        public StuffNode(TypeNess i, StuffNode n) {
            item = i;
            next = n;
        }
    }
    /** restrict access with private keyword */
    private StuffNode sentinel;
    private StuffNode last;
    private int size;

    /** create an empty SLList. */
//    public SLList() {
////        sentinel = new StuffNode(63, null);
//        last = sentinel;
//        size = 0;
//    }
    public SLList(TypeNess x) {
//        sentinel = new StuffNode(63, null);
        sentinel = new StuffNode(x, null);
        last = sentinel.next;
        size = 1;
    }
    public void addFirst(TypeNess x) {
        sentinel.next = new StuffNode(x, sentinel.next);
        last = sentinel.next;
        size += 1;
    }
    public TypeNess getFirst() {
        return sentinel.next.item;
    }
    public void addLast(TypeNess x) {
        size += 1;
        last.next = new StuffNode(x, null);
        last = last.next;
    }
    public TypeNess getLast() {
        return last.item;
    }
    public void removeLast() {
        size -= 1;
        StuffNode p = sentinel;
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
        last = p;
    }
    public int size(StuffNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }
    public int size() {
//        return size(first);
        return size;
    }
//    public static void main(String[] args) {
//        SLList L = new SLList(1);
//        L.addFirst(10);
//        L.addFirst(5);
//        L.addLast(2);
//        L.addLast(3);
//        L.addLast(4);
//        L.removeLast();
//        System.out.println(L.getLast());
//    }
}