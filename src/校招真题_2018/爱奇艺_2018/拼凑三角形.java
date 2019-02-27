package 校招真题_2018.爱奇艺_2018;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/22 20:14
 * @Version 1.0
 * @Function:
 * 题目描述
 * 牛牛手中有三根木棍,长度分别是a,b,c。牛牛可以把任一一根木棍长度削短,牛牛的目标是让这三根木棍构成一个三角形,并且牛牛还希望这个三角形的周长越大越好。
 * 输入描述:
 * 输入包括一行,一行中有正整数a, b, c(1 ≤ a, b, c ≤ 100), 以空格分割
 * 输出描述:
 * 输出一个整数,表示能拼凑出的周长最大的三角形。
 *
 * 满足任意两边之和大于第三边
 */
public class 拼凑三角形 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int res = judge(a, b, c);
            System.out.println(res);
        }
        scan.close();
    }

    private static int judge(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0){
            return 0;
        }

        int max = Math.max(a,b);
        max = Math.max(max, c);
        if(max == a){
            if(max > b+c){
                return 2*(b+c)-1;
            } else {
                return a+b+c;
            }
        } else if(max == b){
            if(max > a+c){
                return 2*(a+c)-1;
            } else {
                return a+b+c;
            }
        } else{
            if(max > a+b){
                return 2*(a+b)-1;
            } else {
                return a+b+c;
            }
        }
    }
}
