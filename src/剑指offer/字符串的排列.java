package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: pyh
 * @Date: 2019/2/18 15:13
 * @Version 1.0
 * @Function:
 *      输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 *      例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *      输入描述:
 *      输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 *      回溯法
 */
public class 字符串的排列 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        func(str.toCharArray(), res, 0);
        Collections.sort(res);
        return res;
    }
    private static void func(char[] ch, ArrayList<String> list, int k){
        if(ch.length == k+1){
            if(!list.contains(new String(ch))){
                list.add(new String(ch));
            }
        } else{
            for(int i = k; i < ch.length; i++){
                exch(ch, i, k);
                func(ch, list, k+1);
                exch(ch, i, k);
            }
        }
    }

    private static void exch(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public static void main(String[] args){

    }
}
