import java.util.ArrayList;

public class Servant extends Thread {
    CGLinkedList LinkedList;
    ArrayList<Integer> Chain;
    int Start;
    int End;

    public Servant(CGLinkedList linkedList, ArrayList<Integer> chain, int start, int end) {
        this.LinkedList = linkedList;
        this.Chain = chain;
        this.Start = start;
        this.End = end;
    }

    @Override
    public void run() {
        for (int i = this.Start; i < this.End; i++) {
            this.LinkedList.add(this.Chain.get(i));
        }
    }
}
