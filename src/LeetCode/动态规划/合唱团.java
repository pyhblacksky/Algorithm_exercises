package LeetCode.动态规划;

/**
 * @Author: pyh
 * @Date: 2019/3/4 10:17
 * @Version 1.0
 * @Function:
 * 题目描述
 * 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
 * 输入描述:
 * 每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
 * 输出描述:
 * 输出一行表示最大的乘积。
 *
 * 示例1
 * 输入
 * 3
 * 7 4 7
 * 2 50
 * 输出
 * 49
 */
public class 合唱团 {

    public static int dp(int[] arr, int k, int d){
        int[][] dp = new int[arr.length + 1][k + 1];

        //初始化
        for(int i = 0; i <= arr.length; i++){
            for(int j = 0; j <= k; j++){
                dp[i][j] = 1;
            }
        }

        for(int i = 1; i <= arr.length; i++){
            for(int j = 1; j <= k; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1] * arr[i-1]);
            }
        }

        return dp[arr.length][k];
    }


    public static void main(String[] args){
        int[] arr = {7,4,7};
        System.out.println(dp(arr, 2, 0));
    }

}
