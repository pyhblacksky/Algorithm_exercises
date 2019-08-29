package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/8/21 14:03
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Solution143_重排链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public void reorderList(ListNode head) {
            if(head == null || head.next == null)
                return;

            ListNode fast = head;
            ListNode slow = head;
            ListNode pre = null;
            int count = 0;
            while(true){
                if(fast == null || fast.next == null){
                    count += fast == null ? 1 : 0;
                    break;
                }
                fast = fast.next.next;
                pre = slow;
                slow = slow.next;
                count += 2;
            }

            if(count % 2 == 1){
                //总数有偶数个，断开
                pre.next = null;//断开，避免成环
            }

            ListNode mid = slow;
            ListNode newMid = null;
            while(mid != null){
                ListNode tmp = mid.next;
                mid.next = newMid;
                newMid = mid;
                mid = tmp;
            }

            //添加
            while(head != null && newMid != null){
                ListNode headNext = head.next;
                ListNode midNext = newMid.next;

//                System.out.println("node:"+head.val);
//                System.out.println("tmp:"+newMid.val);

                head.next = newMid;
                newMid.next = headNext;

                head = headNext;
                newMid = midNext;
            }
        }

    }
}
