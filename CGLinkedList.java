import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CGLinkedList {
    private Node<Integer> head;
    private Lock lock = new ReentrantLock();

    public CGLinkedList() {
        head = new Node<Integer>(Integer.MIN_VALUE);
        head.Next = new Node<Integer>(Integer.MAX_VALUE);
    }

    public boolean add(Integer item) {
        Node<Integer> pred, curr;
        // int key = item.hashCode();
        lock.lock();
        try {
            pred = head;
            curr = pred.Next;
            while (curr.Item < item) {
                pred = curr;
                curr = curr.Next;
            }

            if (item == curr.Item) {
                return false;
            } else {
                Node<Integer> node = new Node<Integer>(item);
                node.Next = curr;
                pred.Next = node;
                return true;
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean remove(Integer item) {
        Node<Integer> pred, curr;
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
        Node<Integer> curr = head;
        while (curr != null) {
            System.out.println(curr.Item.toString() + ", " + curr.Key);
            curr = curr.Next;
        }
    }
}