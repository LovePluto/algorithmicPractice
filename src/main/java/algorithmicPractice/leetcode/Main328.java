package algorithmicPractice.leetcode;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class Main328 {
    public static void main(String[] args) {
        Main328 main328 = new Main328();
        ListNode l = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        l.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode s = main328.oddEvenList(l);
        System.out.println(s);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode resultA = head;
        ListNode resultB = head.next;
        ListNode headA = head;
        ListNode headB = head.next;
        ListNode temp = head.next;
        while (temp != null && temp.next != null) {
            headA.next = temp.next;
            temp = temp.next;
            headB.next = temp.next;
            headA = headA.next;
            headB = headB.next;
            temp = temp.next;
        }
        headA.next = resultB;
        return resultA;

    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
