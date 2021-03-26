public interface Deque<T> {
    void addFirst(T x);
    void addLast(T x);
    boolean isEmpty();
    int size();
    void printDeque();
    T get(int i);
    T removeFirst();
    T removeLast();
}