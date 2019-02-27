package 校招真题_2018.爱奇艺_2018;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/21 15:10
 * @Version 1.0
 * @Function:
 * 题目描述
 * 对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
 * 牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
 * 输入描述:
 * 输入包括一行,一行中有4个正整数x1, k1, x2, k2(1 ≤ x1,x2 ≤ 10^9, 1 ≤ k1,k2 ≤ 50),以空格分割
 * 输出描述:
 * 如果v1小于v2输出"Less",v1等于v2输出"Equal",v1大于v2输出"Greater".
 *
 */
public class 循环数比较 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int x1 = scan.nextInt();
            int k1 = scan.nextInt();
            int x2 = scan.nextInt();
            int k2 = scan.nextInt();
            int res = judge(x1, k1, x2, k2);
            if(res == 1){
                System.out.println("Greater");
            } else if(res == -1){
                System.out.println("Less");
            } else{
                System.out.println("Equal");
            }
        }
        scan.close();
    }

    //相等返回0，小于返回-1，大于返回1
    private static int judge(int x1, int k1, int x2, int k2){
        String str1 = String.valueOf(x1);
        String str2 = String.valueOf(x2);
        int res = 0;
        if(str1.length()*k1 < str2.length()*k2){
            return -1;
        } else if(str1.length()*k1 > str2.length()*k2){
            return 1;
        } else{
            //数量相等时
            if(k1 == k2){
                if(x1 == x2){
                    return 0;
                } else if(x1 > x2){
                    return 1;
                } else{
                    return -1;
                }
            } else{
                String temp = str1;
                for(int i = 1; i < k1; i++){
                    str1 += temp;
                }
                temp = str2;
                for(int i = 1; i < k2; i++){
                    str2 += temp;
                }

                for(int i = 0; i < str1.length(); i++){
                    if(str1.charAt(i) > str2.charAt(i)){
                        return 1;
                    } else if(str1.charAt(i) < str2.charAt(i)){
                        return -1;
                    }
                }
            }
        }
        return res;
    }

}
