package 校招真题_2018.爱奇艺_2018;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/21 15:02
 * @Version 1.0
 * @Function:
 * 题目描述
 * 牛牛有一个由小写字母组成的字符串s,在s中可能有一些字母重复出现。比如在"banana"中,字母'a'和字母'n'分别出现了三次和两次。
 * 但是牛牛不喜欢重复。对于同一个字母,他只想保留第一次出现并删除掉后面出现的字母。请帮助牛牛完成对s的操作。
 * 输入描述:
 * 输入包括一个字符串s,s的长度length(1 ≤ length ≤ 1000),s中的每个字符都是小写的英文字母('a' - 'z')
 * 输出描述:
 * 输出一个字符串,表示满足牛牛要求的字符串
 *
 * 输入
 * banana
 * 输出
 * ban
 */
public class 删除重复字符 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String input = scan.nextLine();
            input  = delete(input);
            System.out.println(input);
        }
        scan.close();
    }

    private static String delete(String str){
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            if(!set.contains(str.charAt(i))){
                sb.append(str.charAt(i));
                set.add(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
