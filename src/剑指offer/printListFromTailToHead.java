package 剑指offer;

import java.util.ArrayList;

import static 剑指offer.Tools.printArrList;

/**
 * @Author: pyh
 * @Date: 2019/2/16 14:55
 * @Version 1.0
 * @Function:
 *      从尾到头打印链表
 *      输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 *
 *      注意：一定要反转链表！！！
 */
public class printListFromTailToHead {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();

        if(listNode == null){
            return res;
        }

        //反转链表
        ListNode newHead = null;
        while(listNode != null){
            ListNode temp = listNode.next;
            listNode.next = newHead;
            newHead = listNode;
            listNode = temp;
        }

        while(newHead != null){
            res.add(newHead.val);
            newHead = newHead.next;
        }

        return res;
    }

    /******************************************************************************************************************/

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
        ArrayList<Integer> list = printListFromTailToHead(n1);
        printArrList(list);
    }

}
