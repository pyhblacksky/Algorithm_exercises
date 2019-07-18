package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/18 20:13
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 *
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution188_买卖股票最佳时机4 {

    //通用dp解法
    static class Solution {
        public int maxProfit(int k, int[] prices) {
            if(prices == null || prices.length == 0 || k <= 0)
                return 0;
            int n = prices.length;

            //k超过prices长度的一半，退化为k次
            if(k > n/2){
                return maxProfit_K(prices);//要不然会超出内存限制
            }

            int[][][] dp = new int[n+1][k+1][2];

            //初始化
            for(int i = 0; i <= n; i++){
                dp[i][0][1] = Integer.MIN_VALUE;
            }
            for(int i = 0; i <= k; i++){
                dp[0][i][1] = Integer.MIN_VALUE;
            }

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= k; j++){
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i-1]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i-1]);
                }
            }

            return dp[n][k][0];
        }

        public int maxProfit_K(int[] prices){
            if(prices == null || prices.length == 0)
                return 0;
            int n = prices.length;
            int[][] dp = new int[n+1][2];
            for(int i=0; i <= n; i++){
                dp[i][1] = Integer.MIN_VALUE;
            }

            for(int i = 1; i <= n; i++){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i-1]);
            }
            return dp[n][0];
        }
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {2,4,1};

        solution.maxProfit(2, arr);
    }
}
