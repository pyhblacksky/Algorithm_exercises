package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/17 13:49
 * @Version 1.0
 * @Function:
 *      输入一个链表，反转链表后，输出新链表的表头。
 */
public class 反转链表 {

    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
