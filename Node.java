public class Node<T> {
    T Item;
    int Key;
    Node<T> Next;
    boolean Marked;

    public Node(T item, int key) {
        this.Item = item;
        this.Key = key;
    }

    public Node(T item) {
        this.Item = item;
    }
}
