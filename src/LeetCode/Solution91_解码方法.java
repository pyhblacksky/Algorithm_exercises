package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/21 15:09
 * @Version: 1.0
 * @Function:
 * @Description:
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Solution91_解码方法 {
    //DP的思想求解,有条件的斐波那契数列
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || (s.length() == 1 && s.charAt(0) == '0')){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i = 0; i < s.length(); i++){
            dp[i+1] = s.charAt(i) == '0' ? 0 : dp[i];
            if(i > 0 && (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6'))){
                dp[i+1] += dp[i-1];
            }
        }
        printArr(dp);
        return dp[dp.length-1];
    }

    public static void main(String[] args){
        Solution91_解码方法 solution = new Solution91_解码方法();
        solution.numDecodings("12");
    }

    public static void printArr(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
