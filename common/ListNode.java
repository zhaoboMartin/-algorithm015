public class ListNode {
    public int val;
    public ListNode next;

    public ListNode setNext(ListNode next) {
        this.next = next;
        return next;
    }
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode of(String str) {
        str = str.replace("[","");
        str = str.replace("]","");
        String[] split = str.split(",");

        ListNode first = new ListNode(Integer.parseInt(split[0]));
        ListNode temp = first;
        for (int i = 1; i < split.length; i++) {
            ListNode inner = new ListNode(Integer.parseInt(split[i]));
            temp.next = inner;
            temp = inner;
        }
        return first;
    }

    @Override
    public String toString() {
        return val + "->" + (next == null ? "" : next);

    }
}
