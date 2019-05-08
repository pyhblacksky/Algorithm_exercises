package 校招真题_2018.爱奇艺_2018;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/22 20:31
 * @Version 1.0
 * @Function:
 * 如果一个字符串S是由两个字符串T连接而成, 即S = T + T, 我们就称S叫做平方串,例如"","aabaab","xxxx"都是平方串.
 * 牛牛现在有一个字符串s,请你帮助牛牛从s中移除尽量少的字符,让剩下的字符串是一个平方串。换句话说,就是找出s的最长子序列并且这个子序列构成一个平方串。
 * 输入描述:
 * 输入一个字符串s,字符串长度length(1 ≤ length ≤ 50),字符串只包括小写字符。
 * 输出描述:
 * 输出一个正整数,即满足要求的平方串的长度。
 *
 */
public class 平方串 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            int res = countLen(str);
            System.out.println(res);
        }
        scan.close();

    }

    private static int countLen(String str){
        //从任意点将字符串切开，求这两部分的最长公共子序列
        if(str == null || str.length() == 0){
            return 0;
        }
        if(str.length() == 1){
            return 1;
        }

        int res = 1;//默认单字符
        for(int i = 0; i < str.length(); i++){
            String s1 = str.substring(0,i);
            String s2 = str.substring(i);
            res = Math.max(res, getLCS(s1, s2)*2);
        }

        return res;
    }

    //获取最长公共子序列长度
    static int getLCS(String s1, String s2){
        if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
            return 0;
        }

        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int n1 = ch1.length;
        int n2 = ch2.length;
        int[][] dp = new int[n1][n2];
        dp[0][0] = ch1[0] == ch2[0] ? 1 : 0;

        for(int i = 1; i < n1; i++){
            dp[i][0] = Math.max(dp[i-1][0], ch1[i] == ch2[0] ? 1 : 0);
        }
        for(int i = 1; i < n2; i++){
            dp[0][i] = Math.max(dp[0][i-1], ch1[0] == ch2[i] ? 1 : 0);
        }

        for(int i = 1; i < n1; i++){
            for(int j = 1; j < n2; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(ch1[i] == ch2[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }

        //通过dp求出
        return dp[n1-1][n2-1];
    }
}
