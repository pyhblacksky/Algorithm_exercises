package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/29 8:44
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class Solution328_奇偶链表 {

    //常规方法，不符合要求
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode newHead = even;
        ListNode temp = odd;
        int count = 0;
        while(head != null){
            if(count % 2 == 0){
                even.next = new ListNode(head.val);
                even = even.next;
                count++;
            } else{
                odd.next = new ListNode(head.val);
                odd = odd.next;
                count++;
            }
            head = head.next;
        }

        even.next = temp.next;

        return newHead.next;
    }

    //空间复杂度为 O(1)，时间复杂度为 O(nodes) 的方法，三个指针
    public ListNode oddEvenList1(ListNode head){
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        //head为奇链表头节点，o为奇链表尾节点
        ListNode odd = head;

        //p为偶链表头节点
        ListNode p = head.next;

        //e为偶链表尾节点
        ListNode even = p;
        while(odd.next != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = p;
        return head;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
