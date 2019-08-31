package LeetCode;

import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/8/31 14:51
 * @Version: 1.0
 * @Function:
 * @Description:
 * 同224题，多了个除法计算
 */
public class Solution227_基本计算器2 {
    class Solution {
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
}
