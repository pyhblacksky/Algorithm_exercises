package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/3 20:05
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution21_合并两个有序链表 {

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null)
                return l2;
            if(l2 == null)
                return l1;

            ListNode res = new ListNode(0);
            ListNode result = res;
            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    res.next = new ListNode(l1.val);
                    l1 = l1.next;
                    res = res.next;
                } else {
                    res.next = new ListNode(l2.val);
                    l2 = l2.next;
                    res = res.next;
                }
            }

            while(l1 != null){
                res.next = new ListNode(l1.val);
                res = res.next;
                l1 = l1.next;
            }
            while(l2 != null){
                res.next = new ListNode(l2.val);
                l2 = l2.next;
                res = res.next;
            }

            return result.next;
        }
    }

}
