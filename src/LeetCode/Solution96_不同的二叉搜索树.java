package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/7/6 8:01
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution96_不同的二叉搜索树 {

    //回溯    超时...
    class Solution {
        public int numTrees(int n) {
            if(n == 0)
                return 0;

            return getRes(1, n);
        }

        private int getRes(int start, int end){
            int res = 0;
            if(start >= end)
                return 1;

            for(int i = start; i <= end; i++){
                int left = getRes(start, i-1);
                int right = getRes(i+1, end);

                //左右子树两两组合
                res += left*right;
            }

            return res;
        }
    }

    //回溯改进, 加memo
    class Solution1{
        public int numTrees(int n) {
            if(n == 0)
                return 0;

            Map<Integer, Integer> map = new HashMap<>();
            return getRes(n, map);
        }

        private int getRes(int n, Map<Integer, Integer> map){
            if(map.containsKey(n))
                return map.get(n);

            int res = 0;
            if(n == 0 || n == 1)
                return 1;

            for(int i = 1; i <= n; i++){
                int left = getRes(i-1, map);
                int right = getRes(n-i, map);

                res += left*right;
            }
            map.put(n, res);
            return res;
        }
    }

    //动态规划
    class Solution2 {
        public int numTrees(int n) {
            if (n == 0)
                return 0;

            int[] dp = new int[n+1];
            dp[0] = 1;

            //长度为 1 到 n
            for(int len = 1; len <= n; len++){
                //将不同的数字作为根节点，只需要考虑到len
                for(int root = 1; root <= len; root++){
                    int left = root-1;  //左子树长度
                    int right = len - root; //右子树长度
                    dp[len] += dp[left] * dp[right];
                }
            }

            return dp[n];
        }
    }

    //解法3，公式法，卡塔兰数！
    //卡塔兰数通项公式  Cn = (2n)! / (n+1)!n!
    class Solution3{
        public int numTrees(int n){
            if(n == 0)
                return 0;

            long res = 1;
            long i;
            for(i = 1; i <= n; i++){
                res = res * (i + n) / i;
            }

            return (int)(res/i);
        }
    }
}
