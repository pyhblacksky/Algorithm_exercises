package 剑指offer;

import java.util.ArrayList;

/**
 * @Author: pyh
 * @Date: 2019/2/19 14:37
 * @Version 1.0
 * @Function:
 *      先,让小朋友们围成一个大圈。
 *      然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 *      每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 *      并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 *      请你试着想下,哪个小朋友是最后一个？(注：小朋友的编号是从0到n-1)
 *
 *
 */
public class 孩子们的游戏 {

    //如果模拟游戏过程
    public int LastRemaining_Solution1(int n, int m) {
        if(n <= 0 || m <= 0){
            return -1;
        }

        if(n == 1){
            return 0;
        }

        //添加编号
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(i);
        }

        int index = -1;
        while(list.size() != 1){
            for(int i = 0; i < m; i++){
                if(index >= list.size()-1){
                    index = 0;
                    continue;
                }
                index++;
            }
            list.remove(index);
            index--;
        }
        return list.get(0);
    }

    //约瑟夫环问题!!!
    public int LastRemaining_Solution(int n, int m){
        if(n <= 0 || m <= 0){
            return -1;
        }

        if(n == 1){
            return 0;
        }

        return (LastRemaining_Solution(n-1, m) + m) % n;
    }

    //链表成环来做
    static class Solution {
        public int LastRemaining_Solution(int n, int m) {
            if(n <= 0 || m <= 0)
                return -1;

            if(n == 1)
                return n;

            ListNode head = build(n);

            int count = 0;
            while(head.next != null){
                count++;
                if(m-1 == count) {
                    count = 0;
                    removeNode(head);
                }
                if(head.next == null)
                    break;//只剩一个  跳出
                head = head.next;
            }

            return head.val;
        }

        public void removeNode(ListNode head){
            if(head == null || head.next == null)
                return;

            if(head.next.val == head.val){
                head.next = null;
                return;
            }
            head.next = head.next.next;
        }

        public ListNode build(int n){
            ListNode head = new ListNode(0);
            ListNode save = head;
            for(int i = 1; i < n; i++){
                head.next = new ListNode(i);
                head = head.next;
            }

            head.next = save;//成为环状
            return save;
        }

        class ListNode{
            ListNode next;
            int val;
            ListNode(int val){
                this.val = val;
            }
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.LastRemaining_Solution(5,3);
    }

}
