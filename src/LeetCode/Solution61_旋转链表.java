package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/8/19 16:25
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Solution61_旋转链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //效率低
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null || head.next == null)
                return head;

            int len = 0;
            ListNode tmp = head;
            List<Integer> list = new LinkedList<>();
            while(tmp != null){
                list.add(tmp.val);
                tmp = tmp.next;
                len++;
            }

            k = k % len;
            if(k == 0)
                return head;
            ListNode node = new ListNode(0);
            ListNode newHead = node;
            //后到前
            for(int i = list.size()-k; i < list.size(); i++){
                node.next = new ListNode(list.get(i));
                node = node.next;
            }

            for(int i = 0; i < list.size()-k; i++){
                node.next = new ListNode(list.get(i));
                node = node.next;
            }

            return newHead.next;
        }
    }
}
