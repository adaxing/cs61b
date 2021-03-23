public class ArrayDeque<T> {
    private T[] items;
    private int size = 8;
    private int memreq = 8;
    private static int RFACTOR = 2;
    private static double UFACTOR = 0.25;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
    }

    public ArrayDeque(ArrayDeque other) {
        size = 0;
        items = (T[]) new Object[8];
        for (int i=0; i<other.size(); i++) {
            addLast((T) other.get(i));
        }
    }
    public int size() {
        return size;
    }
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    private void decsize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
        memreq = size;
    }
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        T[] a = (T[]) new Object[size];
        System.arraycopy(items, 1, a, 0, size-1);
        items = a;
        items[0] = item;
        memreq++;
    }
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[size] = item;
        size += 1;
        memreq++;
    }
    public boolean isEmpty() {
        if (size==0) {
            return true;
        } else {
            return false;
        }
    }
    public void printDeque() {
        int i;
        for (i=0; i<size; i++) {
            System.out.println(items[i]);
        }
    }

    public T removeFirst() {
        T itemToReturn = items[0];
        T[] a = (T[]) new Object[size];
        System.arraycopy(items, 1, a, 0, size-1);
        items = a;
        size--;
        if (size/memreq < UFACTOR) {
            decsize(size);
        }
        return itemToReturn;
    }

    public T removeLast() {
        T itemToReturn = getBack();
        items[size-1] = null;
        size -= 1;
        if (size/memreq < UFACTOR) {
            decsize(size);
        }
        return itemToReturn;
    }

    public T get(int index) {
        return items[index];
    }
    public T getBack() {
        int lastActualItemIndex = size - 1;
        return items[lastActualItemIndex];
    }


}