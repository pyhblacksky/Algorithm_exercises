package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/24 8:39
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class Solution343_整数拆分 {

    //动态规划
    public int integerBreak(int n) {
        if(n <= 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++){
            for(int j = 1; j <= i/2; j++){
                dp[i] = Math.max(dp[i-j]*dp[j], dp[i]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args){
        Solution343_整数拆分 solution = new Solution343_整数拆分();
        int res = solution.integerBreak(10);
        System.out.println(res);
    }
}
