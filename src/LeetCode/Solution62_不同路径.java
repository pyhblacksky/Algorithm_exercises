package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/12 10:05
 * @Version: 1.0
 * @Function:
 * @Description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution62_不同路径 {

    //递归，超时
    static class Solution {
        int count = 0;
        public int uniquePaths(int m, int n) {
            if(m == 0 || n == 0)
                return 0;

            int[][] matrix = new int[m][n];
            getPath(matrix, 0, 0);
            return count;
        }

        private void getPath(int[][] matrix, int i, int j){
            if(i > matrix.length || j > matrix[0].length)
                return;

            if(i == matrix.length - 1 && j == matrix[i].length-1) {
                count++;
                return;
            }

            getPath(matrix, i+1, j);
            getPath(matrix, i, j+1);
        }

        public static void main(String[] args){
            Solution solution = new Solution();
            solution.uniquePaths(7, 3);
            System.out.println(solution.count);
        }
    }

    //dp
    static class Solution1{
        public int uniquePaths(int m, int n) {
            if(m == 0 || n == 0)
                return 0;

            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(i == 0){
                        dp[i][j] = 1;
                    } else if(j == 0){
                        dp[i][j] = 1;
                    } else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }

            return dp[m-1][n-1];
        }

        public static void main(String[] args){
            Solution1 solution1 = new Solution1();
            System.out.println(solution1.uniquePaths(23,12));
        }
    }

}

