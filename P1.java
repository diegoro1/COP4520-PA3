import java.util.ArrayList;
import java.util.Collections;

public class P1 {
    public final static int NUM_PRESENTS = 500000;

    public static void main(String[] args) throws InterruptedException {
        CGLinkedList list = new CGLinkedList();
        ArrayList<Integer> chain = new ArrayList<Integer>();
        for (int i = 0; i < NUM_PRESENTS; i++) {
            chain.add(i);
        }

        Collections.shuffle(chain);

        Servant s1 = new Servant(list, chain, 0, NUM_PRESENTS / 4 * 1);
        Servant s2 = new Servant(list, chain, ((NUM_PRESENTS / 4) * 1), (NUM_PRESENTS /
                4) * 2);
        Servant s3 = new Servant(list, chain, ((NUM_PRESENTS / 4) * 2), (NUM_PRESENTS /
                4) * 3);
        Servant s4 = new Servant(list, chain, ((NUM_PRESENTS / 4) * 3), ((NUM_PRESENTS /
                4) * 3) + 1);

        s1.start();
        s2.start();
        s3.start();
        s4.start();

        s1.join();
        s2.join();
        s3.join();
        s4.join();

        list.printList();
    }
}
