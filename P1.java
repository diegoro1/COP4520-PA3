public class P1 {
    public static void main(String[] args) {
        CGLinkedList<String> list = new CGLinkedList<String>("hello", "world");
        for (int i = 0; i < 100000; i++) {
            list.add(String.valueOf(i));
        }

        list.printList();
    }
}
