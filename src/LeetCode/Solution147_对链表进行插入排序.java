package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/2/26 9:54
 * @Version 1.0
 * @Function:   147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 */
public class Solution147_对链表进行插入排序 {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }


        ListNode res = new ListNode(0); //保存结果
        res.next = head;//保存起始节点

        ListNode pre = head;//保存前一个结点,head-pre是排好序的部分
        ListNode cur = head.next;//第一个元素默认有序
        while(cur != null){
            //寻找插入位置
            ListNode insertPre = findInsertIndexPre(res, cur);
            if(insertPre == pre){
                //此时不需要换位置
                pre = cur;
                cur = cur.next;
            } else{
                //cur需要插入到insertPre后面的位置
                pre.next = cur.next;
                cur.next = insertPre.next;
                insertPre.next = cur;

                //移动cur
                cur = pre.next;
            }
        }
        return res.next;
    }
    /**
     * 查找cur要插入位置的前一个节点
     * */
    private ListNode findInsertIndexPre(ListNode head, ListNode cur){
        while(head.next != cur){
            if(head.next.val >= cur.val){
                return head;
            }
            head = head.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
