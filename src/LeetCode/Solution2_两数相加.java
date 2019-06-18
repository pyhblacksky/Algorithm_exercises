package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/18 15:32
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Solution2_两数相加 {

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null){
                return l1;
            }
            if(l2 == null){
                return l2;
            }

            ListNode node = new ListNode(0);
            ListNode res = node;
            while(l1 != null && l2 != null){
                node.next = new ListNode(l1.val + l2.val);
                node = node.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while(l1 != null){
                node.next = new ListNode(l1.val);
                node = node.next;
                l1 = l1.next;
            }
            while(l2 != null){
                node.next = new ListNode(l2.val);
                node = node.next;
                l2 = l2.next;
            }

            //进行进位操作
            node = res;
            while(node != null){
                if(node.val >= 10){
                    node.val = node.val - 10;
                    if(node.next == null){
                        node.next = new ListNode(0);
                    }
                    node.next.val += 1;
                }
                node = node.next;
            }

            return res.next;
        }
    }

}
