package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/5 20:54
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution10_正则表达式匹配 {

    //规则写法,回溯
    class Solution {
        public boolean isMatch(String s, String p) {
            if(s == null || p == null)
                return false;

            if(s.length() == 0 && p.length() == 0)
                return true;

            return matchCore(s.toCharArray(), 0, p.toCharArray(), 0);
        }

        public boolean matchCore(char[] s, int sIndex, char[] p, int pIndex){
            if(sIndex == s.length && p.length == pIndex)
                return true;

            if(sIndex != s.length && p.length == pIndex)
                return false;

            if(pIndex + 1 < p.length && p[pIndex+1] == '*'){
                if((sIndex < s.length && s[sIndex] == p[pIndex])
                        || (sIndex < s.length && p[pIndex] == '.')){
                    return matchCore(s, sIndex, p, pIndex+2)
                            || matchCore(s, sIndex+1, p, pIndex)
                            || matchCore(s, sIndex+1, p, pIndex+2);
                } else{
                    return matchCore(s, sIndex, p, pIndex+2);
                }
            }

            if((sIndex < s.length && s[sIndex] == p[pIndex])
                    || (sIndex < s.length && p[pIndex] == '.')){
                return matchCore(s, sIndex+1, p, pIndex+1);
            }
            return false;
        }
    }

    //复杂度较低的方法 动态规划
    class Solution1{
        //自底向上
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length()+1][p.length()+1];
            dp[s.length()][p.length()] = true;

            for(int i = s.length(); i >= 0; i--){
                for(int j = p.length()-1; j >= 0; j--){
                    boolean firstMatch = (i < s.length()
                            && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
                    if(j+1 < p.length() && p.charAt(j+1) == '*'){
                        dp[i][j] = dp[i][j+2] || (firstMatch && dp[i+1][j]);
                    } else{
                        dp[i][j] = firstMatch && dp[i+1][j+1];
                    }
                }
            }

            return dp[0][0];
        }
    }

}
