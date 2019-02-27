package 剑指offer.水题;

/**
 * @Author: pyh
 * @Date: 2019/2/17 13:53
 * @Version 1.0
 * @Function:
 *      输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并两个排序链表 {

    //非递归版本
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode res = new ListNode(0);
        ListNode node = res;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ListNode temp = new ListNode(list1.val);
                res.next = temp;
                res = res.next;
                list1 = list1.next;
            } else{
                ListNode temp = new ListNode(list2.val);
                res.next = temp;
                res = res.next;
                list2 = list2.next;
            }
        }
        if (list1 != null){
            res.next = list1;
        }
        if(list2 != null){
            res.next = list2;
        }
        return node.next;
    }

    //递归版本
    public ListNode merge1(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val){
            list1.next = merge1(list1.next, list2);
            return list1;
        } else{
            list2.next = merge1(list1, list2.next);
            return list2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
