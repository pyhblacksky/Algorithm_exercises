package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/18 20:52
 * @Version 1.0
 * @Function:
 *      输入两个链表，找出它们的第一个公共结点。
 */
public class 两个链表的第一个公共节点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //判断链表是否相交, 先对齐，再判断
        if(pHead1 == null || pHead2 == null){
            return null;
        }

        int len1 = 0;
        int len2 = 0;
        ListNode temp = pHead1;
        while(temp != null){
            temp = temp.next;
            len1++;
        }
        temp = pHead2;
        while(temp != null){
            temp = temp.next;
            len2++;
        }

        //对齐
        if(len1 > len2){
            int len = len1-len2;
            while(len != 0 && pHead1 != null){
                len--;
                pHead1 = pHead1.next;
            }
        } else if(len1 < len2){
            int len = len2-len1;
            while (len != 0 && pHead2 != null){
                len--;
                pHead2 = pHead2.next;
            }
        }

        //同时走
        while(pHead1 != null && pHead2 != null){
            if(pHead1 == pHead2){
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
