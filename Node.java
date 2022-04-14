public class Node<T> {
    T Item;
    int Key;
    Node<T> Next;

    public Node(T item, int key) {
        this.Item = item;
        this.Key = key;
    }

    public Node(T item2) {
        this.Item = item2;
    }
}
