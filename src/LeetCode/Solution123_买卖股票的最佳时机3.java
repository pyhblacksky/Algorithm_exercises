package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/20 10:44
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution123_买卖股票的最佳时机3 {

    /**
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     *               max(   选择 rest  ,           选择 sell      )
     *
     * 解释：今天我没有持有股票，有两种可能：
     * 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
     * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
     *
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *               max(   选择 rest  ,           选择 buy         )
     *
     * 解释：今天我持有着股票，有两种可能：
     * 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
     * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
     *
     * */
    static class Solution {
        //dp
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length == 0){
                return 0;
            }

            int dp_i10 = 0;
            int dp_i11 = Integer.MIN_VALUE;
            int dp_i20 = 0;
            int dp_i21 = Integer.MIN_VALUE;
            for(int price : prices){
                dp_i20 = Math.max(dp_i20, dp_i21 + price);
                dp_i21 = Math.max(dp_i21, dp_i10 - price);
                dp_i10 = Math.max(dp_i10, dp_i11 + price);
                dp_i11 = Math.max(dp_i11, -price);
            }

            return dp_i20;
        }
    }

    //通用dp解法
    class Solution1 {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length == 0)
                return 0;

            int len = prices.length;
            int k = 2;
            int[][][] dp = new int[len+1][k+1][2];
            for(int i = 0; i <= len; i++){
                dp[i][0][1] = Integer.MIN_VALUE;
            }
            for(int i = 0; i <= k; i++){
                dp[0][i][1] = Integer.MIN_VALUE;
            }

            for(int i = 1; i <= len; i++){
                for(int j = 1; j <= k; j++){
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i-1]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i-1]);
                }
            }

            return dp[len][k][0];
        }
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(arr));
    }

}
