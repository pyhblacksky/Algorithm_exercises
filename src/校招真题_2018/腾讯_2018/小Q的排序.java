package 校招真题_2018.腾讯_2018;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/6 21:02
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 小Q在学习许多排序算法之后灵机一动决定自己发明一种排序算法，小Q希望能将n个不同的数排序为升序。小Q发明的排序算法在每轮允许两种操作：
 *
 * 1、 将当前序列中前n-1个数排为升序
 *
 * 2、 将当前序列中后n-1个数排为升序
 *
 * 小Q可以任意次使用上述两种操作，小Q现在想考考你最少需要几次上述操作可以让序列变为升序。
 *
 * 输入描述:
 * 输入包括两行，第一行包括一个正整数n(3≤n≤10^5)，表示数字的个数
 *
 * 第二行包括n个正整数a[i](1≤a[i]≤10^9)，即需要排序的数字，保证数字各不相同。
 * 输出描述:
 * 输出一个正整数，表示最少需要的操作次数
 *
 * 示例1
 *
 * 输入
 * 6
 * 4 3 1 6 2 5
 *
 * 输出
 * 2
 */
public class 小Q的排序 {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = cin.nextInt();
        }

        System.out.println(minOp(arr));
    }

    //分情况讨论
    static int minOp(int[] arr){
        if(arr == null || arr.length <= 1){
            return 0;
        }

        //寻找最大数和最小数
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        if(arr[0] == min){
            //最小数在第一个，输出1，仅仅需要一次操作
            return 1;
        } else if(arr[0] == max){
            //最大数在第一个，输出3，需要三次操作
            //如：5 4 2 3 -> 5 2 3 4 -> 2 3 5 4 -> 2 3 4 5
            //分别以5， 4， 2 为基准点操作
            return 3;
        } else{
            return 2;
        }
    }
}
