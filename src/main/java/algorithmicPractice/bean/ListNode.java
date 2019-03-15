package algorithmicPractice.bean;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    public static ListNode getListNode(int[] array) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        for (int i : array) {
            ListNode listNode = new ListNode(i);
            temp.next = listNode;
            temp = temp.next;
        }
        return result.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode temp = this;
        while (temp != null) {
            sb.append(temp.val);
            sb.append(",");
            temp = temp.next;
        }
        return sb.toString();
    }
}
