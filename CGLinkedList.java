import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CGLinkedList<T> {
    private Node<T> head;
    private Lock lock = new ReentrantLock();

    public CGLinkedList(T first, T second) {
        head = new Node<T>(first, Integer.MIN_VALUE);
        head.Next = new Node<T>(second, Integer.MAX_VALUE);
    }

    public boolean add(T item) {
        Node<T> pred, curr;
        int key = item.hashCode();
        lock.lock();
        try {
            pred = head;
            curr = pred.Next;
            while (curr.Key < key) {
                pred = curr;
                curr = curr.Next;
            }

            if (key == curr.Key) {
                return false;
            } else {
                Node<T> node = new Node<T>(item);
                node.Key = key;
                node.Next = curr;
                pred.Next = node;
                return true;
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean remove(T item) {
        Node<T> pred, curr;
        int key = item.hashCode();
        lock.lock();
        try {
            pred = head;
            curr = pred.Next;
            while (curr.Key < key) {
                pred = curr;
                curr = curr.Next;
            }

            if (key == curr.Key) {
                pred.Next = curr.Next;
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public void printList() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.Item.toString() + ", " + curr.Key);
            curr = curr.Next;
        }
    }
}