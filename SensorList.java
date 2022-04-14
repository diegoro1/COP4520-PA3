import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SensorList {
    private Node<Integer> head;
    private Lock lock = new ReentrantLock();
    public int Size;

    public SensorList() {
        head = new Node<Integer>(Integer.MIN_VALUE, -1);
        head.Next = new Node<Integer>(Integer.MAX_VALUE, -1);
        this.Size = 0;
    }

    public boolean add(Integer item, int interval) {
        Node<Integer> pred, curr;
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
                Node<Integer> node = new Node<Integer>(interval, item);
                node.Next = curr;
                pred.Next = node;
                this.Size++;
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

    public void printtop5() {
        Node<Integer> curr = head;
        int currentIndex = 0;

        // used to sort from largest to smalles, data would be logged from smalles to
        // largest,
        // since curr hits the smallest of the top 5 temperatures.
        ArrayList<Integer> top = new ArrayList<Integer>();

        System.out.print("Top 5: ");
        lock.lock();
        try {
            while (curr != null) {
                if (currentIndex >= (this.Size - 5) && curr.Key != -1)
                    top.add(curr.Item);

                curr = curr.Next;
                currentIndex++;
            }
            Collections.sort(top, Collections.reverseOrder());
            System.out.println(top);
            top.clear();
        } finally {
            lock.unlock();
        }
    }

    public void printBottom5() {
        System.out.print("Bottom 5: ");
        ArrayList<Integer> bottom = new ArrayList<Integer>();

        Node<Integer> curr = head.Next;
        for (int i = 0; i < 5; i++) {
            bottom.add(curr.Item);
            curr = curr.Next;
        }
        Collections.sort(bottom);
        System.out.println(bottom);
        bottom.clear();
    }

    public int getSize() {
        return this.Size;
    }
}