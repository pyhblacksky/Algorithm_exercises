package 校招真题_2018.爱奇艺_2018;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/16 9:04
 * @Version 1.0
 * @Function:
 *      判断题
 *      牛牛在考试中一共猜测了 t 道题目的答案是"正确",其他的牛牛猜为"错误"。
 *      考试结束后牛牛知道实际上 n 道题中有 a 个题目的答案应该是"正确"
 *      输入包括一行,一行中有三个正整数n, t, a(1 ≤ n, t, a ≤ 50), 以空格分割
 */
public class judgeQustion {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int t = scan.nextInt();
            int a = scan.nextInt();

            if(n >= t && n >= a){
                if(t == a){
                    //全部蒙对
                    System.out.println(n);
                } else{
                    int res = Math.abs(n - Math.abs(t-a));
                    System.out.println(res);
                }
            }
        }
        scan.close();
    }

}
