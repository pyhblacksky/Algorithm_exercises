package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/8/19 16:51
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Solution92_反转链表2 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(head == null || head.next == null)
                return head;

            //保存前一个结点
            ListNode pre = null;
            ListNode cur = head;
            while(m > 1){
                pre = cur;
                cur = cur.next;
                m--;
                n--;
            }

            ListNode con = pre;//当前节点的前一个
            ListNode tail = cur;//预计成为尾部的节点

            ListNode newHead = null;
            while(n > 0){
                newHead = cur.next;
                cur.next = pre;
                pre = cur;
                cur = newHead;
                n--;
            }

            if(con != null){
                con.next = pre;
            } else{
                head = pre;
            }
            tail.next = cur;

            return head;
        }
    }

}
