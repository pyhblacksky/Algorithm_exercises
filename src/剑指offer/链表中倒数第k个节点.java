package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/17 13:17
 * @Version 1.0
 * @Function:
 *      链表中倒数第k个节点
 *      输入一个链表，输出该链表中倒数第k个结点。
 */
public class 链表中倒数第k个节点 {

    //方法一：计算链表长度，然后得出相应位置
    public static ListNode FindKthToTail(ListNode head,int k) {
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }

        int count = len - k;
        if(count < 0){
            return null;
        }
        ListNode res = null;
        while (count != 0 && head != null){
            count--;
            head = head.next;
        }
        res = head;

        return res;
    }

    //方法二：创建两个链表节点，同时为head，第一个节点先走k-1步，
    //  然后，第二个和第一个同时走，当第一个节点为空时，返回第二个节点即为所求节点
    public static ListNode FindKthToTail1(ListNode head,int k) {
        if(head == null || k < 0){
            return null;
        }

        ListNode pre = head;
        ListNode last = head;
        for(int i = 0; i < k; i++){
            if(pre == null){
                return null;
            }
            pre = pre.next;
        }

        while(pre != null){
            pre = pre.next;
            last = last.next;
        }

        return last;

    }
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;


        ListNode res = FindKthToTail(n1, 1);
        System.out.println(res.val);
    }
}
