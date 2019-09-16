package LeetCodeRace.Contest154;

import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/9/15 10:06
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 *
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 */
public class Main2 {

    static class Solution {
        public String reverseParentheses(String s) {
            int left = 0;
            Stack<Integer> stk = new Stack<>();
            String ans = "";
            int size = s.length();
            boolean[] vis = new boolean[size];
            int[] match = new int[size];

            for (int i = 0; i < size; i++) {
                if (s.charAt(i) == '(') {
                    stk.push(i);
                } else if (s.charAt(i) == ')' && !stk.isEmpty()) {
                    left = stk.peek();
                    stk.pop();
                    match[left] = i;
                    match[i] = left;
                }
            }
            int cur = 0, d = 1;
            while (cur != size) {
                if (s.charAt(cur) == '(' || s.charAt(cur) == ')') {
                    cur = match[cur];
                    d = -d;
                    cur += d;
                } else {
                    ans += s.charAt(cur);
                    cur += d;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String res = solution.reverseParentheses("(u(love)i)");
        System.out.println(res);
    }

}
