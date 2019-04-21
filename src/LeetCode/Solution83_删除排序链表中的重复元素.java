package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/21 16:46
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Solution83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = head;

        while(head != null && head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
                continue; //原地停留
            }
            head = head.next;
        }

        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
