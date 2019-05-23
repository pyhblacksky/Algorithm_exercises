package 华为机试;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/23 9:01
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 *
 * 示例1
 * 输入
 * 复制
 * 0xA
 * 输出
 * 复制
 * 10
 *
 */
public class 进制转换 {

    //实际是大数问题
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String line = sc.nextLine();
            BigInteger bigInteger = new BigInteger(line.substring(2), 16);
            System.out.println(bigInteger);
        }
        sc.close();
    }

}
