package Java刷题模板.面试笔试模板;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/4/24 8:15
 * @Version: 1.0
 * @Function:
 * @Description:
 *  最长公共子序列
 *
 *  题目      http://www.51nod.com/Challenge/Problem.html#!#problemId=1006
 * 就是输入两个字符串str1、str2，输出任意一个最长公共子序列。
 *
 * 解析
 * dp[i][j]代表的是 : 必须以str1[i]、str2[j]结尾的最长公共子序列，dp[i][j]来源:
 *
 * 可能是dp[i-1][j]，代表str1[0~i-1]与str2[0~j]的最长公共子序列。
 * 可能是dp[i][j-1]，代表str1[0~i]与str2[0~j-1]的最长公共子序列。
 * 如果str1[i] == str2[j]，还可能是dp[i-1][j-1] + 1。
 * 这三种情况中取最大值。
 *
 * 输入样例
 * abcicba
 * abdkscab
 *
 * 输出样例
 * abca
 *
 * 参考链接：https://github.com/ZXZxin/ZXBlog/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%AE%97%E6%B3%95/DP/51Nod%20-%201006.%20%E6%9C%80%E9%95%BF%E5%85%AC%E5%85%B1%E5%AD%90%E5%BA%8F%E5%88%97LCS%20%E5%92%8C%20%E6%9C%80%E9%95%BF%E5%85%AC%E4%BC%97%E5%AD%90%E4%B8%B2.md
 */
public class 最长公共子序列 {

    //获取dp数列
    //dp[i][j] 代表的是str[0...i] 与 str[0...j]的最长公共子序列
    public static int[][] getDp(String s1, String s2){
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int n1 = ch1.length;
        int n2 = ch2.length;
        int[][] dp = new int[n1][n2];
        dp[0][0] = ch1[0] == ch2[0] ? 1 : 0;

        for(int i = 1; i < n1; i++){
            // 一旦dp[i][0]被设置成1,则dp[i~N-1][0]都为1
            dp[i][0] = Math.max(dp[i-1][0], ch1[i] == ch2[0] ? 1 : 0);
        }
        for(int i = 1; i < n2; i++){
            dp[0][i] = Math.max(dp[0][i-1], ch1[0] == ch2[i] ? 1 : 0);
        }

        for(int i = 1;i < n1; i++){
            for(int j = 1; j < n2; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(ch1[i] == ch2[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }
        return dp;
    }

    //获取最长公共子序列
    public static String getLCS(String s1, String s2, int[][] dp){
        if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
            return "";
        }
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        char[] res = new char[dp[i][j]];    //生成答案的数组
        int index = dp[i][j] - 1;
        while(index >= 0){
            if(i > 0 && dp[i][j] == dp[i-1][j]){
                i--;
            } else if(j > 0 && dp[i][j] == dp[i][j-1]){
                j--;
            } else{
                // dp[i][j] = dp[i-1][j-1]+1
                res[index--] = ch1[i];
                i--;
                j--;
            }
        }
        return String.valueOf(res);
    }

    //测试函数
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        String s1 = in.next();
        String s2 = in.next();

        //abcicba
        //abdkscab

        int[][] dp = getDp(s1, s2);
        System.out.println(dp[s1.length()-1][s2.length()-1]); //length of lcs
        System.out.println(getLCS(s1, s2, dp));
    }

}
