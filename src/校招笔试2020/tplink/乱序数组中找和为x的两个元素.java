package 校招笔试2020.tplink;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/6/15 13:58
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class 乱序数组中找和为x的两个元素 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//数组元素个数
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();//目标数字
        find(arr, target);

    }

    public static void find(int[] arr, int target){
        if(arr == null || arr.length == 0)
            return;

        Arrays.sort(arr);
        //双指针
        int pre = 0;
        int last = arr.length - 1;
        while(pre < last){
            int temp = arr[pre] + arr[last];
            if(temp == target){
                System.out.println(arr[pre] + " " + arr[last]);
                return;
            } else if(temp < target){
                pre++;
            } else{
                last--;
            }
        }
    }

}
