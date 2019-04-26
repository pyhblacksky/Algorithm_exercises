package Java刷题模板.面试笔试模板;

/**
 * @Author: pyh
 * @Date: 2019/4/23 21:40
 * @Version: 1.0
 * @Function:
 * @Description:
 *  最长公共子串
 *
 *  链接：https://www.nowcoder.com/questionTerminal/02e7cc263f8a49e8b1e1dc9c116f7602?toCommentId=1532408
 * 来源：牛客网
 *
 * 对于两个字符串，请设计一个时间复杂度为O(m*n)的算法(这里的m和n为两串的长度)，
 * 求出两串的最长公共子串的长度。
 * 这里的最长公共子串的定义为两个序列U1,U2,..Un和V1,V2,...Vn，
 *  其中Ui + 1 == Ui+1,Vi + 1 == Vi+1，同时Ui == Vi。
 *
 * 给定两个字符串A和B，同时给定两串的长度n和m。
 *
 * 测试样例：
 * "1AB2345CD",9,"12345EF",7
 * 返回：4
 *
 *
 * 解析
 *  1. dp矩阵第一列即dp[0~N-1][0]，对某一个位置(i,0)来说，
 *      如果str1[i] == str2[0]，令dp[i][0] = 1，否则令dp[i][0] = 0；
 *  2.矩阵dp第一行，即dp[0][0~M-1]，对某个位置(0,j)来说，
 *      如果str1[0] == str2[j]，令dp[0][j] = 1，否则令dp[0][j] = 0；
 *  3. 一般的位置有两种情况，如果str1[i] != str2[j]，
 *      说明在必须把str1[i]和str2[j]当做公共子串最后一个字符是不可能的，所以dp[i][j] = 0；
 *      如果str1[i] = str2[j]，说明可以将str1[i]和str2[j]作为公共子串的最后一个字符，
 *      其长度就是dp[i-1][j-1] + 1；
 */
public class 最长公共子串 {

    //求最大公共子串的长度
    public static int findLongest(String A, int n, String B, int m) {
        if(A == null || B == null || A.length() == 0 || B.length() == 0){
            return 0;
        }
        char[] s1 = A.toCharArray();
        char[] s2 = B.toCharArray();
        int res = 0;
        int[][] dp = new int[s1.length][s2.length];
        for(int i = 0; i < s1.length; i++){
            dp[i][0] = s1[i] == s2[0] ? 1 : 0;
        }
        for(int i = 0; i < s2.length; i++){
            dp[0][i] = s1[0] == s2[i] ? 1 : 0;
        }

        for(int i = 1; i < s1.length; i++){
            for(int j = 1; j < s2.length; j++){
                if(s1[i] == s2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }

    //生成Dp表
    public static int[][] getDp(char[] s1, char[] s2){
        int[][] dp = new int[s1.length][s2.length];
        for(int i = 0; i < s1.length; i++){
            dp[i][0] = s1[i] == s2[0] ? 1 : 0;
        }
        for(int i = 0; i < s2.length; i++){
            dp[0][i] = s1[0] == s2[i] ? 1 : 0;
        }

        for(int i = 1; i < s1.length; i++){
            for(int j = 1; j < s2.length; j++){
                if(s1[i] == s2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        return dp;
    }

    //根据dp表生成答案字符串
    public static String getLongestSubString(String s1, String s2, int[][] dp){
        if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0){
            return "";
        }
        int max = 0;
        int end = 0;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(dp[i][j] > max){
                    max = dp[i][j];
                    end = i;
                }
            }
        }
        return s1.substring(end - max + 1, end + 1);
    }

    //空间优化
    /**
     * 因为dp[i][j]只依赖于左上角位置的dp[i-1][j-1]，所以用一个变量记录左上角的值即可。
     *
     * 遍历方向从右上角的斜线开始，一直遍历到左下角，中间记录最大值max和结束位置end即可。
     * */
    public static String getLongestSubString(String A, String B){
        if(A == null || A.length() == 0 || B == null || B.length() == 0){
            return "";
        }

        char[] s1 = A.toCharArray();
        char[] s2 = B.toCharArray();
        int row = 0;
        int col = s2.length - 1;//从右上角开始
        int max = 0;//记录最大长度
        int end = 0;//记录结束位置
        while(row < s1.length){
            int i = row;
            int j = col;
            int ul = 0;//up and left 表示左上角的值
            while(i < s1.length && j < s2.length){
                //从(i, j)向右下方开始遍历
                if(s1[i] == s2[j]){
                    ul++;
                } else{
                    ul = 0;
                }

                if(ul > max){
                    max = ul;
                    end = i;
                }
                i++;
                j++;
            }

            if(col > 0){
                col--;//斜线还没到最左边 ->向左移动
            } else{
                row++;//到了最左，向下移动
            }
        }
        System.out.println(max);//
        return A.substring(end - max + 1, end + 1);//输出区间[end - max +1, end]
    }


    public static void main(String[] args){
        String sa = "abcdefq";
        String sb = "cdefab";
        int[][] dp = getDp(sa.toCharArray(), sb.toCharArray());
        System.out.println(getLongestSubString(sa, sb, dp)); // cdef
        System.out.println(getLongestSubString(sa, sb, dp).length()); //4

        String A = "1AB2345CD";
        String B = "12345EF";
        System.out.println(findLongest(A,9,B,7));
    }
}
