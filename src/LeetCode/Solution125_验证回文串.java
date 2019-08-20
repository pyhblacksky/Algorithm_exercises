package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/8/20 16:55
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution125_验证回文串 {

    class Solution {
        public boolean isPalindrome(String s) {
            if(s == null || s.length() <= 1)
                return true;

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c >= 'a' && c <= 'z'){
                    sb.append(c);
                } else if(c >= 'A' && c <= 'Z'){
                    char x = (char)(c+32);
                    sb.append(x);
                } else if(c >= '0' && c <= '9'){
                    sb.append(c);
                }
            }

            //判断是否是回文
            int p1 = 0;
            int p2 = sb.length()-1;
            char[] chs = sb.toString().toCharArray();
            while(p1 <= p2){
                if(chs[p1] != chs[p2])
                    return false;
                p1++;
                p2--;
            }

            return true;
        }
    }

}
