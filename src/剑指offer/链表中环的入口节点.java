package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/19 21:10
 * @Version 1.0
 * @Function:
 *      给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class 链表中环的入口节点 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return null;
        }

        //快慢指针，判断有无环。有环后，快指针回到原点，走一步，相遇，则是入口
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(slow != null){
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                break;
            }
        }

        fast = pHead;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
