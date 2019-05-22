package 华为机试;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/22 8:54
 * @Version: 1.0
 * @Function:
 * @Description:
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 *
 * 输出描述:
 * 整数N，最后一个单词的长度。
 *
 * 示例1
 * 输入
 * 复制
 * hello world
 * 输出
 * 复制
 * 5
 */
public class 字符串最后一个单词的长度 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        //String[] str = line.split("\\s+");
        //System.out.println(str[str.length-1].length());
        int count = 0;
        int index = line.length()-1;
        //如果末尾有空格，去除空格
        while(index >= 0 && line.charAt(index) == ' '){
            index--;
        }
        while(index >= 0 && line.charAt(index) != ' '){
            count++;
            index--;
        }
        System.out.println(count);
    }

}
