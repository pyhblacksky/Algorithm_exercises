package 华为机试;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/22 9:01
 * @Version: 1.0
 * @Function:
 * @Description:
 * 题目描述
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * 输入描述:
 * 输入一个有字母和数字以及空格组成的字符串，和一个字符。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 *
 * 示例1
 * 输入
 * 复制
 * ABCDEF
 * A
 * 输出
 * 复制
 * 1
 */
public class 计算字符个数 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String Strch = sc.nextLine();
        //不区分大小写
        word = word.toLowerCase();
        char ch = Strch.charAt(0);
        if(ch >= 65 && ch <= 90){
            ch = (char)(ch+32);
        }

        int count = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ch){
                count++;
            }
        }

        System.out.println(count);
    }

}
