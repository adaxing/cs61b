public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
    /** comparsion with addFirst func in SLList, more work */
    public void addFirst(int x) {
        rest = new IntList(first, rest);
        first = x;
    }
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int iterativeSize() {
        // point current value
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i-1);
    }

    public static IntList incrList(IntList L, int x) {
        /** increment each element of L by x, not allow to change L */
        if (L == null) {
            return null;
        }
        IntList res = new IntList(L.first + x, null);
        res.rest = incrList(L.rest, x);

        return res;
    }

    public static IntList dincrList(IntList L, int x) {
        /** increment each element of L by x, not allow to use new keyword */
        if (L == null) {
            return null;
        }
        L.first = L.first + x;
        dincrList(L.rest, x);
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println("Recursive way: " + L.size());
        System.out.println("Iterative way: " + L.iterativeSize());
        System.out.println("Get ith value recursive way: " + L.get(1));
        System.out.println("Incr value: ");
        IntList incRes = incrList(L, 2);
        System.out.println(incRes.get(0));
        System.out.println(incRes.get(1));
        System.out.println(incRes.get(2));
        System.out.println("Dincr value: " );
        IntList res = dincrList(L, 2);
        System.out.println(res.get(0));
        System.out.println(res.get(1));
        System.out.println(res.get(2));
        System.out.println("Add first func: " );
        IntList L1 = new IntList(4, null);
        L1.addFirst(3);
        L1.addFirst(2);
        System.out.println(L1.get(0));
        System.out.println(L1.get(1));
        System.out.println(L1.get(2));


    }
}