package 校招笔试2020.vivo提前批;

/**
 * @Author: pyh
 * @Date: 2019/6/4 20:50
 * @Description:
 */

public class 反转指定位置链表 {

    //题目大意就是只反转 指定位置的链表
    /**
     * 如
     * 3 5
     * 11 5 9 22 8 5 10
     *
     * 结果
     * 11 5 8 22 9 5 0
     * */
    public static void main(String[] args){
        ListNode n1 = new ListNode(11);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(22);
        ListNode n5 = new ListNode(8);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(0);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        solution(n1, 3,5);
    }

    //打印n-m
    public static void solution(ListNode head, int n, int m){
        if(head == null){
            return;
        }

        int cnt = 1;
        while(head != null && cnt != n){
            System.out.print(head.val + " ");
            head = head.next;
            cnt++;
        }

        int des = m - n + 1;
        cnt = 0;
        ListNode newHead = null;
        while(head != null && cnt != des){
            cnt++;
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }

        while(newHead != null){
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }

        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}