package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/4 14:00
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *  
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution445_两数相加2 {

    //链表相加，常规方法，翻转链表
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null)
                return l2;
            if(l2 == null)
                return l1;

            ListNode n1 = null;
            int len1 = 0;
            while(l1 != null){
                ListNode temp = l1.next;
                l1.next = n1;
                n1 = l1;
                l1 = temp;
                len1++;
            }

            ListNode n2 = null;
            int len2 = 0;
            while(l2 != null){
                ListNode temp = l2.next;
                l2.next = n2;
                n2 = l2;
                l2 = temp;
                len2++;
            }

            int cin = 0;
            if(len1 > len2){
                ListNode save = n1;
                while(n1 != null && n2 != null){
                    n1.val += n2.val + cin;
                    if(n1.val >= 10){
                        n1.val %= 10;
                        cin = 1;
                    } else{
                        cin = 0;
                    }
                    if(n1.next == null && cin == 1){
                        n1.next = new ListNode(1);
                        break;
                    }
                    n1 = n1.next;
                    n2 = n2.next;
                }

                while(n1 != null && cin == 1){
                    n1.val += cin;
                    if(n1.val >= 10){
                        n1.val %= 10;
                        cin = 1;
                    } else{
                        cin = 0;
                    }

                    if(n1.next == null && cin == 1){
                        n1.next = new ListNode(1);
                        break;
                    }
                    n1 = n1.next;
                }

                ListNode res = null;
                while(save != null){
                    ListNode temp = save.next;
                    save.next = res;
                    res = save;
                    save = temp;
                }
                return res;

            } else{
                ListNode save = n2;
                while(n1 != null && n2 != null){
                    n2.val += n1.val + cin;
                    if(n2.val >= 10){
                        n2.val %= 10;
                        cin = 1;
                    } else{
                        cin = 0;
                    }

                    if(n2.next == null && cin == 1){
                        n2.next = new ListNode(1);
                        break;
                    }

                    n1 = n1.next;
                    n2 = n2.next;
                }

                while(n2 != null && cin == 1){
                    n2.val += cin;
                    if(n2.val >= 10){
                        n2.val %= 10;
                        cin = 1;
                    } else{
                        cin = 0;
                    }

                    if(n2.next == null && cin == 1){
                        n2.next = new ListNode(1);
                        break;
                    }
                    n2 = n2.next;
                }

                ListNode res = null;
                while(save != null){
                    ListNode temp = save.next;
                    save.next = res;
                    res = save;
                    save = temp;
                }
                return res;
            }
        }
    }

    //不对链表进行翻转的方法   利用栈
    class Solution1{
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null)
                return l2;
            if(l2 == null)
                return l1;

            return null;
        }
    }

}
