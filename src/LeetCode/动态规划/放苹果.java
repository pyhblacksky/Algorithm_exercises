package LeetCode.动态规划;

/**
 * @Author: pyh
 * @Date: 2019/3/4 8:20
 * @Version 1.0
 * @Function:   放苹果
 *
 * 题目描述
 * 把 M 个同样的苹果放在 N 个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * 注意：5、1、1 和 1、5、1 是同一种分法，即顺序无关。
 * 输入描述:
 * 输入包含多组数据。
 *
 * 每组数据包含两个正整数 m和n（1≤m, n≤20）。
 * 输出描述:
 * 对应每组数据，输出一个整数k，表示有k种不同的分法。
 * 示例1
 * 输入
 * 7 3
 * 输出
 * 8
 */
public class 放苹果 {

    //递归方法
    public static int dp(int m, int n){
        if(n == 1 || m == 0){
            return 1;
        }
        if(n > m){
            //盘子比较多 去掉空盘子
            return dp(m, m);
        } else{
            //苹果比较多
            //1.至少有一个空盘子，去掉这个盘子
            //2. 每个盘子都有苹果，各拿一个苹果
            return dp(m, n - 1) + dp(m - n, n);
        }
    }

    //动态规划,m个水果，n个盘子
    public static int dp1(int m, int n){
        if(m == 0 || m == 1 || n == 1){
            return 1;
        }

        int[][] dp = new int [n + 1][];
        //初始化
        for(int i = 0; i <= n; i++) {
            dp[i] = new int[m + 1];
            for( int j = 0; j <= m; j++ ) {
                dp[i][j] = 1;
            }
        }

        for(int i = 2; i <= n; ++i) {
            for( int j = 2; j <= m; ++j) {
                if(i > j) {
                    dp[i][j] = dp[j][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - i];
                }
            }
        }
        return dp[n][m];
    }

    //滚动数组优化？？？

    public static void main(String[] args){
        System.out.println(dp1(7,3));
    }

}
