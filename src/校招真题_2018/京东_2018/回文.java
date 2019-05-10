package 校招真题_2018.京东_2018;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/9 20:32
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 京京和东东是好朋友。东东很喜欢回文。回文是指从前往后读和从后往前读是一样的词语。
 * 京京准备给东东一个惊喜,先取定一个字符串s,然后在后面附上0个或者更多个字母形成回文,京京希望这个回文越短越好。
 * 请帮助京京计算他能够得到的最短的回文长度。
 * 输入描述:
 * 输入包括一个字符串s,字符串s长度length(1 ≤ length ≤ 50)
 * 输出描述:
 * 输出一个整数,表示牛牛能够得到的最短的回文长度。
 *
 * 示例1
 * 输入
 * abab
 *
 * 输出
 * 5
 *
 */
public class 回文 {

    //可以使用manacher算法
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        int res = getMinLenTail(str);
        System.out.println(res);
    }

    /*********************************************************************************/
    //以下方法是在前后都可以加字符串来构成一个最短回文串

    //使用dp的方法，根据dp矩阵还原完整字符串
    static String getPalindrome(String str){
        if(str == null || str.length() <= 1){
            return str;
        }

        char[] ch = str.toCharArray();
        int[][] dp = getDp(ch);
        char[] res = new char[str.length() + dp[0][str.length()-1]];
        int i = 0;
        int j = str.length()-1;
        int resLeft = 0;
        int resRight = res.length - 1;
        while(i <= j){
            if(ch[i] == ch[j]){
                res[resLeft++] = ch[i++];
                res[resRight--] = ch[j--];
            } else if(dp[i][j-1] < dp[i+1][j]){
                res[resLeft++] = ch[j];
                res[resRight--] = ch[j--];
            } else{
                res[resLeft++] = ch[i];
                res[resRight--] = ch[i++];
            }
        }
        return String.valueOf(res);
    }

    //获取dp矩阵,dp[i][j]的值代表子串str[i..j]最少添加几个字符可以使str[i..j]整体都是回文串
    static int[][] getDp(char[] str){
        int[][] dp = new int[str.length][str.length];
        for(int j = 1; j < str.length; j++){
            dp[j-1][j] = str[j-1] == str[j] ? 0 : 1;
            for(int i = j - 2; i >= 0; i--){
                if(str[i] == str[j]){
                    dp[i][j] = dp[i+1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]) + 1;
                }
            }
        }
        return dp;//dp[0][N-1]代表整个字符串最少需要添加几个字符
    }

    /*******************************************************************************/

    //以下是只能在尾部加，构成最短回文串
    static int getMinLenTail(String str){
        if(str == null){
            return 0;
        }
        if(str.length() <= 1){
            return str.length();
        }

        char[] arr = str.toCharArray();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(isPalindrome(arr, i, n-1)){
                return n + i;
            }
        }
        return 0;
    }

    static boolean isPalindrome(char[] arr, int i, int j){
        while(i <= j){
            if(arr[i++] != arr[j--]){
                return false;
            }
        }
        return true;
    }

}
