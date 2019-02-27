package 校招真题_2018.爱奇艺_2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/21 16:25
 * @Version 1.0
 * @Function:
 * 题目描述
 * 牛牛有一个长度为n的整数序列,牛牛想对这个序列进行重排为一个非严格升序序列。牛牛比较懒惰,他想移动尽量少的数就完成重排,请你帮他计算一下他最少需要移动多少个序列中的元素。(当一个元素不在它原来所在的位置,这个元素就是被移动了的)
 * 输入描述:
 * 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),即序列的长度
 * 第二行n个整数x[i](1 ≤ x[i] ≤ 100),即序列中的每个数
 * 输出描述:
 * 输出一个整数,即最少需要移动的元素个数
 *
 * 思路：建立两个数组，将其中一个数组排序，比较两个数组，不同的计数器+1
 */
public class 排序 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < arr.length; i++){
                arr[i] = scan.nextInt();
            }
            System.out.println(countNum(arr, n));
        }
        scan.close();
    }

    private static int countNum(int[] arr, int n){
        int[] help = new int[n];
        for(int i = 0; i < arr.length; i++){
            help[i] = arr[i];
        }
        Arrays.sort(help);
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != help[i]){
                count++;
            }
        }
        return count;
    }
}
