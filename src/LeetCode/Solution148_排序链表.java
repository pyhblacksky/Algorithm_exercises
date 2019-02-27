package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/2/25 21:20
 * @Version 1.0
 * @Function: 148、排序链表
 *在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 */
public class Solution148_排序链表 {
    /**
     * 参考：Sort List——经典（链表中的归并排序） https://www.cnblogs.com/qiaozhoulin/p/4585401.html
     *
     * 归并排序法：在动手之前一直觉得空间复杂度为常量不太可能，因为原来使用归并时，都是 O(N)的，
     * 需要复制出相等的空间来进行赋值归并。对于链表，实际上是可以实现常数空间占用的（链表的归并
     * 排序不需要额外的空间）。利用归并的思想，递归地将当前链表分为两段，然后merge，分两段的方
     * 法是使用 fast-slow 法，用两个指针，一个每次走两步，一个走一步，知道快的走到了末尾，然后
     * 慢的所在位置就是中间位置，这样就分成了两段。merge时，把两段头部节点值比较，用一个 p 指向
     * 较小的，且记录第一个节点，然后 两段的头一步一步向后走，p也一直向后走，总是指向较小节点，
     * 直至其中一个头为NULL，处理剩下的元素。最后返回记录的头即可。
     *
     * 主要考察3个知识点，
     * 知识点1：归并排序的整体思想
     * 知识点2：找到一个链表的中间节点的方法
     * 知识点3：合并两个已排好序的链表为一个新的有序链表
     */
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head){
        if(head.next == null){
            return head;
        }

        ListNode p = head, q = head, pre = null;
        while(q != null && q.next != null){
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        //从中间断开
        pre.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(p);
        return merge(left, right);
    }
    private ListNode merge(ListNode left, ListNode right){
        ListNode help = new ListNode(0);
        ListNode cur = help;
        while(left != null && right != null){
            if(left.val <= right.val){
                cur.next = left;
                left = left.next;
                cur = cur.next;
            } else{
                cur.next = right;
                right = right.next;
                cur = cur.next;
            }
        }
        if (left != null){
            cur.next = left;
        }
        if (right != null){
            cur.next = right;
        }
        return help.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static void main(String[] args){
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution148_排序链表 solution148 = new Solution148_排序链表();
        ListNode res = solution148.sortList(node1);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
