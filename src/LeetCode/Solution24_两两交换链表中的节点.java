package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/20 20:40
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Solution24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }

    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        Solution24_两两交换链表中的节点 solution = new Solution24_两两交换链表中的节点();
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        ListNode node = solution.swapPairs(h1);
        printList(node);
    }

    public static void printList(ListNode node){
        ListNode head = node;
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
