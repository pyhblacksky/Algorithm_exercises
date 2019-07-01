package LeetCodeRace.Contest143;

/**
 * @Author: pyh
 * @Date: 2019/6/30 11:25
 * @Version: 1.0
 * @Function:
 * @Description:
 * 附近的家居城促销，你买回了一直心仪的可调节书架，打算把自己的书都整理到新的书架上。
 *
 * 你把要摆放的书 books 都整理好，叠成一摞：从上往下，第 i 本书的厚度为 books[i][0]，高度为 books[i][1]。
 *
 * 按顺序 将这些书摆放到总宽度为 shelf_width 的书架上。
 *
 * 先选几本书放在书架上（它们的厚度之和小于等于书架的宽度 shelf_width），然后再建一层书架。重复这个过程，直到把所有的书都放在书架上。
 *
 * 需要注意的是，在上述过程的每个步骤中，摆放书的顺序与你整理好的顺序相同。 例如，如果这里有 5 本书，那么可能的一种摆放情况是：第一和第二本书放在第一层书架上，第三本书放在第二层书架上，第四和第五本书放在最后一层书架上。
 *
 * 每一层所摆放的书的最大高度就是这一层书架的层高，书架整体的高度为各层高之和。
 *
 * 以这种方式布置书架，返回书架整体可能的最小高度。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
 * 输出：6
 * 解释：
 * 3 层书架的高度和为 1 + 3 + 2 = 6 。
 * 第 2 本书不必放在第一层书架上。
 *
 *
 * 提示：
 *
 * 1 <= books.length <= 1000
 * 1 <= books[i][0] <= shelf_width <= 1000
 * 1 <= books[i][1] <= 1000
 */
public class 填充书架 {

    //动态规划
    //dp[i]为前i本书能够到达的最小高度
    //1.如果自己单独一层，状态转移方程为dp[i+1] = dp[i] + h[i+1]
    //2.如果和前面的书放一起，则 dp[i+1] = min(dp[j], max(h[j+1] ~ h[i+1]))     sum(w[j+1] ~ w[i+1]) <= width
    // j 是前j本书组成的若干层，第j+1到第i+1本书组成一层
    //取最小值
    class Solution {
        public int minHeightShelves(int[][] books, int shelf_width) {
            if(shelf_width <= 0 || books == null || books.length == 0){
                return 0;
            }

            int[] dp = new int[books.length+1];
            dp[0] = 0;

            for(int i = 1; i <= books.length; i++){
                int[] book = books[i-1];
                int w = book[0];
                int h = book[1];
                dp[i] = dp[i-1] + h;
                for(int j = i - 1; j > 0; j--){
                    w += books[j-1][0];
                    h = Math.max(h, books[j-1][1]);
                    if(w > shelf_width)
                        break;
                    dp[i] = Math.min(dp[i], dp[j-1] + h);
                }
            }

            return dp[books.length];
        }
    }

}
