package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/7/5 14:06
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 *
 * 注意：1 ≤ k ≤ n ≤ 109。
 *
 * 示例 :
 *
 * 输入:
 * n: 13   k: 2
 *
 * 输出:
 * 10
 *
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution440_字典序的第K小数字 {

    //利用堆，超时......O(N)
    static class Solution {
        public int findKthNumber(int n, int k) {
            if(n == 0)
                return 0;

            Queue<String> queue = new PriorityQueue<>((o1, o2) -> {
                int len1 = o1.length();
                int len2 = o2.length();

                if(len1 < len2){
                    for(int i = 0; i < len1; i++){
                        if(o1.charAt(i) != o2.charAt(i)){
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                    return len1-len2;
                } else{
                    for(int i = 0; i < len2; i++){
                        if(o1.charAt(i) != o2.charAt(i)){
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                    return len1-len2;
                }
            });

            for(int i = 1; i <= n; i++){
                queue.add(String.valueOf(i));
            }

            int res = 0;
            if(!queue.isEmpty())
                res = Integer.valueOf(queue.peek());
            while(k > 0 && !queue.isEmpty()){
                k--;
                res = Integer.valueOf(queue.poll());
            }
            return res;
        }
    }

    //使用树,实际是一个十叉树  log(N)
    //由于n大小的限制，构成的并不是一个满十叉树
    //难点就变成了如何计算出每个节点的子节点的个数，
    //我们不停的用k减去子节点的个数，当k减到0的时候，当前位置的数字即为所求。
    static class Solution1 {
        public int findKthNumber(int n, int k) {
            int cur = 1;
            k--;//初始化cur == 1,k自减1
            while(k > 0){
                long step = 0;
                long first = cur;
                long last = cur+1;
                //统计这颗子树下所有节点数(step)
                while(first <= n){
                    step += Math.min(n+1, last) - first;
                    first *= 10;
                    last *= 10;
                }
                if(step <= k){
                    //不在子树中
                    ++cur;
                    k -= step;
                } else{
                    //在子树中，进入子树
                    cur *= 10;
                    --k;
                }
            }
            return cur;
        }

    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        long start = System.currentTimeMillis();
        int res = solution.findKthNumber(13, 8);
        long end = System.currentTimeMillis();
        System.out.println("res:"+ res);
    }

}
