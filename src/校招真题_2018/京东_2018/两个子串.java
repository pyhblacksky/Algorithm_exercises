package 校招真题_2018.京东_2018;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/9 14:41
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 给定一个字符串s, 请计算输出含有连续两个s作为子串的最短字符串。 注意两个s可能有重叠部分。例如,"ababa"含有两个"aba".
 * 输入描述:
 * 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),s中每个字符都是小写字母.
 * 输出描述:
 * 输出一个字符串,即含有连续两个s作为子串的最短字符串。
 *
 * 示例1
 *
 * 输入
 * abracadabra
 * 输出
 * abracadabracadabra
 */
public class 两个子串 {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        System.out.println(getTwoString(str));
    }

    //实际上是KMP的next数组,求前缀串和后缀串的最大匹配长度
    static String getTwoString(String s){
        if(s == null || s.length() == 0){
            return null;
        }

        if(s.length() == 1){
            return s+s;
        }

        //必须前和后匹配，中间匹配都不可
        char[] p = s.toCharArray();
        int len = p.length;
        int[] next = new int[len+1];
        next[0] =- 1;
        int k = -1;
        int i = 0;
        //kmp求next数组
        while(i < len){
            if(k == -1 || p[i] == p[k]){
                next[++i] = ++k;
            }else{
                k = next[k];
            }
        }
        String res = s + s.substring(next[len]);

        return res;
    }
}
