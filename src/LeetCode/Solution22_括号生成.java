package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/7/6 14:22
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution22_括号生成 {

    //回溯
    class Solution {
        List<String> list = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            if(n == 0)
                return list;

            getRes("", 0, 0 ,n);
            return list;
        }

        private void getRes(String cur, int open, int close, int max){
           if(cur.length() == max * 2){
               list.add(cur);
               return;
           }

           if(open < max)
               getRes(cur+"(", open+1, close, max);
           if(close < open)
               getRes(cur+")", open, close+1, max);
        }
    }

}
