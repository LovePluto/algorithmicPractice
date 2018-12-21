package algorithmicPractice.leetcode;

import java.lang.reflect.WildcardType;

/**
 * 83. 删除排序链表中的重复元素
 * <p>
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Main83 {

    public static void main(String[] args) throws Exception {

        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        head.next = listNode;
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        System.out.println(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while (temp != null) {
            while (temp.next != null && temp.val == temp.next.val) {
                temp.next = temp.next.next;

            }
            temp = temp.next;
        }
        return head;

    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
