package 校招笔试2020.英语流利说;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/19 18:34
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Solution1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1){
            System.out.println(1);
            return;
        }
        if(n == 2){
            System.out.println(2);
            return;
        }

        int a = 1;
        int b = 2;
        while(n >= 3){
            int tmp = b;
            b += a;
            a = tmp;
            n--;
        }

        System.out.println(b);
    }

}
