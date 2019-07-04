package LeetCode;

import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/7/4 15:48
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution322_零钱兑换 {

    //暴力递归，超时
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            if(coins == null || coins.length == 0 || amount == 0)
                return 0;

            return helper(amount, coins);
        }

        public int helper(int n, int[] coins){
            if(n == 0)
                return 0;

            int res = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++){
                if(n - coins[i] < 0)
                    continue;//金额不可达
                int subProblem = helper(n - coins[i], coins);
                if(subProblem == -1)
                    continue;//子问题无解
                res = Math.min(res, subProblem+1);
            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

    //带备忘录的方法
    static class Solution1 {
        public int coinChange(int[] coins, int amount) {
            if(coins == null || coins.length == 0 || amount == 0)
                return 0;
            int[] memo = new int[amount+1];
            return helper(amount, coins, memo);
        }

        public int helper(int n, int[] coins, int[] memo){
            if(n == 0)
                return 0;

            if(memo[n] != 0)
                return memo[n];

            int res = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++){
                if(n - coins[i] < 0)
                    continue;//金额不可达
                int subProblem = helper(n - coins[i], coins, memo);
                if(subProblem == -1)
                    continue;//子问题无解
                res = Math.min(res, subProblem+1);
            }

            //记录本轮答案
            memo[n] = res == Integer.MAX_VALUE ? -1 : res;
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

    //动态规划
    class Solution2 {
        public int coinChange(int[] coins, int amount) {
            if(coins == null || coins.length == 0 || amount == 0)
                return 0;

            int[] dp = new int[amount+1];
            //初始化dp
            Arrays.fill(dp, amount+1);
            dp[0] = 0;
            for(int i = 1; i <= amount; i++){
                for(int coin : coins){
                    if(i-coin >= 0)//可达
                        dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }

            return dp[amount] > amount ? -1 : dp[amount];
        }
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {1,2,5};
        solution.coinChange(arr, 13);
    }

}
