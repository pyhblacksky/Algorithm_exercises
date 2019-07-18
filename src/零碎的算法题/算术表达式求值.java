package 零碎的算法题;

import java.util.Stack;

/**
 * @Author: pyh
 * @Date: 2019/7/14 21:22
 * @Version: 1.0
 * @Function:
 * @Description:
 * 用两个栈求算术表达式的值
 */
public class 算术表达式求值 {

    static class Solution{
        Stack<Integer> stackNum = new Stack<>();
        Stack<Character> stackOp = new Stack<>();

        public int getAns(String str){
            if(str == null || str.length() == 0)
                return 0;

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(c == '(' || c == ' ')
                    continue;

                if(c == ')'){
                    char op = stackOp.pop();
                    int num2 = stackNum.pop();
                    int num1 = stackNum.pop();
                    if(op == '+'){
                        num1 += num2;
                        stackNum.push(num1);
                    } else if (op == '-') {
                        num1 -= num2;
                        stackNum.push(num1);
                    } else if(op == '*'){
                        num1 *= num2;
                        stackNum.push(num1);
                    } else if(op == '/'){
                        num1 /= num2;
                        stackNum.push(num1);
                    }
                    continue;
                }


                if(c <= '9' && c >= '0'){
                    stackNum.push(c - '0');
                } else{
                    stackOp.push(c);
                }
            }

            return stackNum.peek();
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String str = "(1+((2+3)*(4*5)))";
        int res = solution.getAns(str);
        System.out.println(res);

        String a = "abcabdeabdc";
        String b = "abdc";
        System.out.println(KMP(a,b));
    }


    static int KMP(String a, String b){
        if(a == null || a.length() == 0 || b == null || b.length() == 0)
            return -1;

        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int[] next = getNext(c2);
        int p1 = 0;
        int p2 = 0;

        while(p1 <c1.length && p2 < c2.length){
            if(c1[p1] == c2[p2]){
                p1++;
                p2++;
            } else if(next[p2] == -1){
                p1++;
            } else{
                p2 = next[p2];
            }
        }

        return p2 == c2.length ? p1 - p2 : -1;
    }

    static int[] getNext(char[] ch){
        if(ch.length <= 1)
            return new int[]{-1};

        int[] next = new int[ch.length];
        next[0] = -1;
        int cn = 0;
        int p1 = 2;
        while(p1 < next.length){
            if(next[p1-1] == next[cn]){
                next[p1++] = ++cn;
            } else if(cn > 0){
                cn = next[cn];
            } else{
                next[p1++] = 0;
            }
        }

        return next;
    }
}
