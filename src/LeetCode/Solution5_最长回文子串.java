package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/29 11:12
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution5_最长回文子串 {

    public static char[] manacherString(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for(int i = 0; i < res.length; i++){
            res[i] = ((i & 1) == 0) ? '#' : str.charAt(index++);
        }
        return res;
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        char[] chs = manacherString(s);
        int[] r = new int[chs.length];
        int C = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 0; i < chs.length; i++){
            r[i] = pR > i ? Math.min(r[2*C-i], pR - i) : 1;
            while(i + r[i] < chs.length && i - r[i] >= 0){
                if(chs[i + r[i]] == chs[i - r[i]]){
                    r[i]++;
                } else{
                    break;
                }
            }

            if(i + r[i] > pR){
                pR = i + r[i];
                C = i;
            }
            if(r[i] > max){
                max = r[i];
                maxIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = maxIndex - (max - 1); i <= maxIndex + max - 1; i++){
            if(chs[i] != '#'){
                sb.append(chs[i]);
            }
        }
        return sb.toString();
    }
}
