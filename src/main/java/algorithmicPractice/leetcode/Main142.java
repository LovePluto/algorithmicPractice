package algorithmicPractice.leetcode;

import algorithmicPractice.bean.ListNode;

/**
 * 142. 环形链表 II
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 */
public class Main142 {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        boolean tag = false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {
            if (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                break;

            }
            if (fast == slow) {
                tag = true;
                break;
            }
        }
        fast = head;
        if (tag) {
            while (true) {
                if (fast == slow) {
                    return fast;
                }
                fast = fast.next;
                slow = slow.next;
            }
        }
        return null;
    }
}
