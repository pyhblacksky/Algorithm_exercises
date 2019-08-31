package Java刷题模板.面试笔试模板;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/8/30 16:50
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class 算术表达式转逆波兰表达式 {

    //主函数测试
    public static void main(String[] args) {
        String str = "3+9*7+(2*1+7)*2";

        String[] res = niBoLan(str);

        //System.out.println();
        System.out.println(evalRPN(res));
    }


    //将算术表达式转为逆波兰表达式
    public static String[] niBoLan(String src) {
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        char tmp;

        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            if (Character.isDigit(c)) { // 如果是数字，直接输出
                sb.append(c+ " ");
            } else if (c == '(') { // 如果是左括号，直接入栈
                stack.push(c);
            } else if (c == ')') { // 如果是右括号，全部出栈输出，直到遇见左括号【左括号不输出】
                while ((tmp = stack.pop()) != '(') {
                    sb.append(tmp + " ");
                }
            } else {
                // 如果是操作符，如果操作符比栈顶小，将栈顶元素出栈输出，直到操作符大于等于栈顶。最后将操作符入栈。
                while (!stack.empty() && getPriority((tmp = stack.peek())) > getPriority(c)) {
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
    public static int getPriority(Character op) {
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

    //逆波兰表达式求值
    public static int evalRPN(String[] tokens) {
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
