package Java刷题模板.面试笔试模板;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/4/23 15:33
 * @Version: 1.0
 * @Function:
 * @Description:
 *  01背包问题的模板
 *  01背包
 *  题目: http://acm.hdu.edu.cn/showproblem.php?pid=2602
 *
 *  Sample Input
 *  1
 *  5 10
 *  1 2 3 4 5
 *  5 4 3 2 1
 *
 *  Sample Output
 *  14
 *
 *  详细讲解地址
 *  https://github.com/ZXZxin/ZXBlog/blob/master/%E5%88%B7%E9%A2%98/Other/Hdu/DP/Hdu%20-%202602.%20Bone%20Collector(01%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98).md
 */
public class 背包问题_01背包 {

    static int n, C;
    static int[] w, v;
    static int[][] dp;

    //记忆化方法
    /**
     * 递归写法
     * 递归的思想就是:
     *
     * 我要计算的是从第0号物体到n-1号物体的最大重量；
     * 记录一个当前判断到i号物体时，已经选择的物体的容量curW；
     * 如果当前剩余容量C - curW < w[i]，当前物品就不能选；
     * s如果i越界的话就返回0；
     * 否则我就递归的去求选择了i号物品的最大值和不选择i号物品的最大值中，我们要取的最大值；
     * 因为上面的时间复杂度为O(2^n)，我们需要使用一个二维数组来记录计算过的重复子问题。(也就是记忆化)
     * */
    static int rec(int p, int curW){
        if(p == n){
            return 0;
        }
        if(dp[p][curW] != -1){
            return dp[p][curW];
        }
        if(curW + w[p] > C){
            return dp[p][curW] = rec(p+1, curW);
        } else{
            return dp[p][curW] = Math.max(rec(p+1, curW + w[p]) + v[p], rec(p+1, curW));
        }
    }

    //普通dp
    static int dp(){
        int[][] dp = new int[n+1][C+1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j <= C; j++){
                dp[i][j] = j + w[i] > C ?
                        dp[i+1][j] : Math.max(dp[i+1][j], dp[i+1][j + w[i]] + v[i]);
            }
        }
        return dp[0][0];
    }

    //二维滚动
    static int dp2(){
        int[][] dp = new int[2][C+1];
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= C; j++){
                dp[i&1][j] = j + w[i] > C ?
                        dp[(i+1)&1][j] : Math.max(dp[(i+1)&1][j], dp[(i+1)&1][j + w[i]] + v[i]);
            }
        }
        return dp[0][0];
    }

    //一维dp
    static int dp3(){
        int[] dp = new int[C+1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j <= C; j++){
                //注意顺序
                dp[j] = j + w[i] > C ? dp[j] : Math.max(dp[j], dp[j + w[i]] + v[i]);
            }
        }
        return dp[0];
    }

    //测试函数
    public static void main(String[] args){
        //直接粘贴
//        1
//        5 10
//        1 2 3 4 5
//        5 4 3 2 1
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = in.nextInt();
        for(int t = 0; t < T; t++){
            n = in.nextInt();
            C = in.nextInt();
            w = new int[n];
            v = new int[n];
            for(int i = 0; i < n; i++){
                v[i] = in.nextInt();
            }
            for(int i = 0; i < n; i++){
                w[i] = in.nextInt();
            }
            dp = new int[n][C+1];
            for(int i = 0; i < n; i++){
                Arrays.fill(dp[i], -1);
            }
            //out.println(rec(0,0));
            //out.println(dp());
            //out.println(dp2());
            out.println(dp3());
            out.flush();
        }
        out.close();
    }

}
