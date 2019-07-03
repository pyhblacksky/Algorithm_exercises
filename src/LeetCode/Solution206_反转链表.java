package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/3 11:28
 * @Version: 1.0
 * @Function:
 * @Description:
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Solution206_反转链表 {

    //非递归版,迭代
    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null)
                return head;

            ListNode newHead = null;
            while(head != null){
                ListNode temp = head.next;
                head.next = newHead;
                newHead = head;
                head = temp;
            }

            return newHead;
        }
    }

    //递归版
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null)
                return head;

            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }

    }

}
