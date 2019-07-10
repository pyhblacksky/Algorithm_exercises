package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/19 10:41
 * @Version 1.0
 * @Function:
 *      汇编语言中有一种移位指令叫做循环左移（ROL），
 *      现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 *      对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 *      例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 *
 */
public class 左旋转字符串 {

    public static String LeftRotateString(String str,int n) {

        if(n == 0 || str == null || str.length() == 0){
            return str;
        }

        n = n % str.length();
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < n; i++){
            temp.append(str.charAt(i));
        }
        for(int i = n; i < str.length(); i++){
            res.append(str.charAt(i));
        }
        res.append(temp);
        return res.toString();
    }

    public static String LeftRotateString1(String str, int n){
        if(n == 0 || str == null || str.length() == 0)
            return str;

        n = n % str.length();
        StringBuilder sb = new StringBuilder(str.substring(0, n));
        sb.reverse();
        StringBuilder st = new StringBuilder(str.substring(n));
        st.reverse();
        sb.append(st);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args){
        String s = "";
        System.out.println(LeftRotateString(s, 3));
    }
}
