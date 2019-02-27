package 剑指offer;

import java.util.HashSet;

/**
 * @Author: pyh
 * @Date: 2019/2/19 21:30
 * @Version 1.0
 * @Function:
 *      在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 *      重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class 删除链表中的重复节点 {

    public static ListNode deleteDuplication(ListNode pHead) {

        if(pHead == null){
            return null;
        }

        ListNode head = pHead;
        HashSet<Integer> set = new HashSet<>();
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                set.add(head.val);
            }
            head = head.next;
        }

        ListNode newHead = new ListNode(0);
        ListNode res = newHead;
        while(pHead != null){
            if(!set.contains(pHead.val)){
                newHead.next = new ListNode(pHead.val);
                newHead = newHead.next;
            }
            pHead = pHead.next;
        }
        return res.next;

    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        deleteDuplication(node1);
    }
}
