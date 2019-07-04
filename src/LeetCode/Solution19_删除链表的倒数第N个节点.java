package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/4 9:07
 * @Version: 1.0
 * @Function:
 * @Description:
 *给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution19_删除链表的倒数第N个节点 {

    //一次扫描  使用双指针
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null)
                return null;

            if(head.next == null && n == 1)
                return null;

            //一个指针指向n+1
            //另一个从头
            ListNode first = head;
            ListNode jump = head;
            while(n != 0 && jump != null){
                jump = jump.next;
                n--;
            }
            if(jump == null)
                return head.next;

            while(first != null && jump != null){
                jump = jump.next;
                if(jump == null){
                    first.next = first.next.next;
                    break;
                }
                first = first.next;
            }

            return head;
        }
    }

    //简略解法
    class Solution1{
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode first = dummy;
            ListNode second = dummy;
            // Advances first pointer so that the gap between first and second is n nodes apart
            for (int i = 1; i <= n + 1; i++) {
                first = first.next;
            }
            // Move first to the end, maintaining the gap
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummy.next;
        }
    }

}
