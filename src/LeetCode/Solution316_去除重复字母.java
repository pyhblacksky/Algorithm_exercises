package LeetCode;

import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/7/2 15:35
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1:
 *
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 *
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution316_去除重复字母 {

    class Solution {
        public String removeDuplicateLetters(String s) {
            if(s == null || s.length() <= 0)
                return s;

            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);

                if(stack.contains(c))
                    continue;

                //如果peek在c字典序后，如果尾部还有此元素，弹出
                while (stack.size() > 0 && stack.peek() > c && s.lastIndexOf(stack.peek()) > i){
                    stack.pop();
                }

                stack.push(c);
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < stack.size(); i++){
                sb.append(stack.get(i));
            }

            return sb.toString();
        }
    }

}
