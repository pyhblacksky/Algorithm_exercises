package LeetCode;

import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/8/31 10:17
 * @Version: 1.0
 * @Function:
 * @Description:
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 *
 * 示例 1:
 *
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 *
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 *
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution224_基本计算器 {
    static class Solution {
        //逆波兰表达式求值
        public int calculate(String s) {
            s = s.replaceAll("\\s+", "");//去掉所有空格
            String[] niBolan = niBoLan(s);
            return evalRPN(niBolan);
        }

        //考虑对连续数的处理...
        public String[] niBoLan(String src) {
            Stack<Character> stack = new Stack<>();

            StringBuilder sb = new StringBuilder();
            char tmp;

            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);

                if (Character.isDigit(c)) { // 如果是数字，直接输出
                    //考虑连续的数
                    int j = i+1;
                    while(j < src.length() && src.charAt(j) >= '0' && src.charAt(j) <= '9'){
                        j++;
                    }
                    String newStr = src.substring(i, j);
                    i = j-1;
                    sb.append(newStr+ " ");
                } else if (c == '(') { // 如果是左括号，直接入栈
                    stack.push(c);
                } else if (c == ')') { // 如果是右括号，全部出栈输出，直到遇见左括号【左括号不输出】
                    while ((tmp = stack.pop()) != '(') {
                        sb.append(tmp + " ");
                    }
                } else {
                    // 如果是操作符，如果操作符比栈顶小，将栈顶元素出栈输出，直到操作符大于等于栈顶。最后将操作符入栈。
                    while (!stack.empty() && getPriority((tmp = stack.peek())) >= getPriority(c)) {
                        sb.append(tmp + " ");
                        stack.pop();
                    }
                    stack.push(c);
                }
            }

            // 输出结束后，如果操作符栈非空，全部出栈
            while (!stack.empty()) {
                sb.append(stack.pop() + " ");
            }

            return sb.toString().split(" ");
        }

        /**
         * 获取优先级
         */
        public int getPriority(Character op) {
            switch(op){
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                default:
                    return 0;
            }
        }

        public int evalRPN(String[] tokens) {
            if(tokens == null || tokens.length == 0){
                return 0;
            }

            Stack<Integer> stack = new Stack<>();

            for (String s : tokens) {
                switch (s) {
                    case "+": {
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num2 + num1);
                        break;
                    }
                    case "-": {
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num2 - num1);
                        break;
                    }
                    case "*": {
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num2 * num1);
                        break;
                    }
                    case "/": {
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        stack.push(num2 / num1);
                        break;
                    }
                    default:
                        stack.push(Integer.valueOf(s));
                        break;
                }
            }

            return stack.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = " 112 + 556*2  ";
        int res = solution.calculate(s);

        System.out.println(res);
        String test = "212-+";
    }

}
