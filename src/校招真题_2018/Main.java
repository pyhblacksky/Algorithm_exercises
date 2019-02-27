package 校招真题_2018;

/**
 * @Author: pyh
 * @Date: 2019/2/14 15:54
 * @Version 1.0
 * @Function:
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i <n ; i++) {
            array[i] = sc.nextLong();
        }
        getLargestMul(array,n);
    }

    static void getLargestMul(long[] num, int len){
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
        for (int i = 0; i < len ; i++) {
            if(num[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = num[i];
            }else if(num[i] > max2){
                max3 = max2;
                max2 = num[i];
            }else if(num[i] > max3){
                max3 = num[i];
            }
            if(num[i] < min1 ){
                min2 = min1;
                min1 = num[i];
            }else if(num[i] < min2){
                min2 = num[i];
            }
        }
        long max = Math.max(max1 * max2 * max3, max1 * min1 * min2);
        System.out.println(max);
    }
}