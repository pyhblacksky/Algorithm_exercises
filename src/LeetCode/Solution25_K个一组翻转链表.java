package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/4 7:57
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution25_K个一组翻转链表 {

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null)
                return null;

            return help(head, 0, k, k);
        }

        //起点，终点，k个
        private ListNode help(ListNode node, int start, int end, int k){
            if(node == null)
                return null;

            ListNode temp = node;
            int len = 0;
            while(temp != null){
                temp = temp.next;
                len++;
            }

            if(len < k)
                return node;

            //局部翻转
            ListNode newHead = null;
            while(node != null && start != end){
                ListNode tmp = node.next;
                node.next = newHead;
                newHead = node;
                node = tmp;
                start++;
            }

            //newHead.next = null 时才接上
            ListNode mark = newHead;
            while(newHead != null &&newHead.next != null){
                newHead = newHead.next;
            }
            if(newHead != null){
                newHead.next = help(node, end, end + k, k);
            }
            return mark;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        solution.reverseKGroup(n1, 2);
    }

}
