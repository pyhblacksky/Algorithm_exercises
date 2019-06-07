package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/6 8:21
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 */
public class Solution221_最大正方形 {

    /**
     * dp[i][j]表示以matrix[i][j]为右下角所能构成的最大正方形边长, 则递推式为:
     * dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
     * */
    public int maximalSquare(char[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max*max;
    }


    //动态规划,改进版
    public int maximalSquare1(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }

        /**
         * 每个位置的计算仅仅使用到了dp[i-1][j-1],
         *  Math.min(dp[i-1][j], dp[i][j-1]) 也就是本行以及上一行的数据，
         *  再具体一些就是用到了本行的的前一个数据,以及上一行的数据
         *
         **/
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] pre = new int[n+1];
        int[] cur = new int[n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '1'){
                    cur[j] = 1 + Math.min(pre[j-1], Math.min(pre[j], cur[j-1]));
                    max = Math.max(max, cur[j]);
                }
                pre[j-1] = cur[j-1];// 上一行的j-1位置用不到了，此时就可以替换为本行的结果，为下一行的运算做准备。
                cur[j-1] = 0;// 本行用不到的结果置0，为下一行做准备。
            }
            pre[n] = cur[n];
            cur[n] = 0;
        }

        return max*max;
    }
}
