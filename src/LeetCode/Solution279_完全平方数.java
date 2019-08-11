package LeetCode;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/30 8:59
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class Solution279_完全平方数 {

    public static int numSquares(int n) {
        if(n <= 0){
            return 0;
        }

        int thread = (int)(Math.sqrt(n));
        int[] powNum = new int[thread+1];
        for(int i = 1; i <= thread; i++){
            powNum[i] = (int)Math.pow(i,2);
        }

        //dp
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 1; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = powNum.length-1; j > 0; j--) {
                if (i - powNum[j] >= 0) {
                    dp[i] = Math.min(dp[i - powNum[j]] + 1, dp[i]);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        numSquares(12);
    }
}
