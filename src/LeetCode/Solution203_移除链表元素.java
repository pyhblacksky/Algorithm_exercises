package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/21 21:21
 * @Version: 1.0
 * @Function:
 * @Description:
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution203_移除链表元素 {

    //创建新的链表
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode temp = new ListNode(0);
        ListNode newHead = temp;

        while(head != null){
            if(head.val == val){
                head = head.next;
                continue;
            }

            temp.next = new ListNode(head.val);
            temp = temp.next;
            head = head.next;
        }

        return newHead.next;
    }

    //在原数组

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
