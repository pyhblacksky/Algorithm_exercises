package 校招真题_2018.爱奇艺_2018;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/5/8 15:11
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 一个完整的括号字符串定义规则如下:
 * 1、空字符串是完整的。
 * 2、如果s是完整的字符串，那么(s)也是完整的。
 * 3、如果s和t是完整的字符串，将它们连接起来形成的st也是完整的。
 * 例如，"(()())", ""和"(())()"是完整的括号字符串，"())(", "()(" 和 ")"是不完整的括号字符串。
 * 牛牛有一个括号字符串s,现在需要在其中任意位置尽量少地添加括号,将其转化为一个完整的括号字符串。
 * 请问牛牛至少需要添加多少个括号。
 *
 * 输入描述:
 * 输入包括一行,一个括号序列s,序列长度length(1 ≤ length ≤ 50).
 * s中每个字符都是左括号或者右括号,即'('或者')'.
 * 输出描述:
 * 输出一个整数,表示最少需要添加的括号数
 *
 * 示例1
 * 输入
 * (()(()
 *
 * 输出
 * 2
 */
public class 缺失的括号 {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        System.out.println(needNum(str));
    }

    static int needNum(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        if(str.length() == 1){
            return 1;
        }

        char[] ch = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        //利用栈，分情况讨论，只有当下一个为)且上一个为(时，才能弹出，否则继续入栈
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '(' && stack.isEmpty()){
                stack.push('(');
            } else if(ch[i] == ')' && stack.isEmpty()){
                stack.push(')');
            } else if(ch[i] == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            } else{
                stack.push(ch[i]);
            }
        }

        return stack.size();//统计栈中剩余元素即时缺少的括号数
    }

}
