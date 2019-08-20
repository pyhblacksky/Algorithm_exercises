package 校招笔试2020.bilibili;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/20 18:46
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class S3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] w = new int[N];
        for(int i = 0; i < N; i++){
            w[i] = sc.nextInt();
        }
        int[] v = new int[N];
        for(int i = 0; i < N; i++){
            v[i] = sc.nextInt();
        }

        int res = dp1(N, M, w, v);
        System.out.println(res);
    }

    //一维状压dp
    static int dp1(int N, int M, int[] w, int[] v){
        int[] dp = new int[M+1];
        for(int i = N-1; i >= 0; i--){
            for(int j = 0; j <= M; j++){
                dp[j] = j + w[i] > M ? dp[j] : Math.max(dp[j], dp[j+w[i]] + v[i]);
            }
        }

        return dp[0];
    }

    //普通dp
    static int dp(int N, int M, int[] w, int[] v){
        int[][] dp = new int[N+1][M+1];
        for(int i = N-1; i >= 0; i--){
            for(int j = 0; j <= M; j++){
                dp[i][j] = j + w[i] > M ? dp[i+1][j] : Math.max(dp[i+1][j], dp[i+1][j+w[i]] + v[i]);
            }
        }

        return dp[0][0];
    }

}
