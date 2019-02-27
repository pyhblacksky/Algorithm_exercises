package 校招真题_2018.网易_2018;

/**
 * @Author: pyh
 * @Date: 2019/2/15 15:56
 * @Version 1.0
 * @Function:
 *      等差数列
 *      题目描述
 * 如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 这里的d也可以是负数和零,我们就称数列S为等差数列。
 * 小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。小易允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次。但是有些数列通过交换还是不能变成等差数列,小易需要判别一个数列是否能通过交换操作变成等差数列
 * 输入描述:
 * 输入包括两行,第一行包含整数n(2 ≤ n ≤ 50),即数列的长度。
 * 第二行n个元素x[i](0 ≤ x[i] ≤ 1000),即数列中的每个整数。
 * 输出描述:
 * 如果可以变成等差数列输出"Possible",否则输出"Impossible"。
 *
 *      判断是否为等差数列
 *       排序后相邻元素相减进行判断
 */


import java.util.Scanner;

public class 等差数列 {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int size = scan.nextInt();
            int[] arr = new int[size];
            for(int i = 0; i < size; i++){
                arr[i] = scan.nextInt();
            }

            quickSort(arr);
            if(arr.length <= 1){
                System.out.println("Possible");
                return;
            }
            int d = arr[1] - arr[0];
            for(int i = 1; i < arr.length; i++){
                if(arr[i] - arr[i-1] != d){
                    System.out.println("Impossible");
                    return;
                }
            }
            System.out.println("Possible");
            return;
        }
        scan.close();

    }

    //快排
    public static void quickSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int L, int R){
        if(L < R){
            int[] j = participate(arr, L, R);
            quickSort(arr, L, j[0]);
            quickSort(arr, j[1], R);
        }
    }

    private static int[] participate(int[] arr, int L, int R){
        int less = L - 1;
        int more = R;
        int cur = L;
        while(cur < more){
            if(arr[cur] < arr[R]){
                exch(arr, cur++, ++less);
            } else if(arr[cur] > arr[R]){
                exch(arr, cur, --more);
            } else{
                cur++;
            }
        }
        exch(arr, R, more);
        return new int[]{less, more};
    }

    private static void exch(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
