package 剑指offer;

import java.util.ArrayList;

import static 剑指offer.Tools.printArrList;

/**
 * @Author: pyh
 * @Date: 2019/2/18 16:43
 * @Version 1.0
 * @Function:
 *      输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *
 *      思想：利用小根堆
 */
public class 最小的k个数 {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || input.length == 0 || k <= 0 || k > input.length){
            return res;
        }

        int[] help = new int[input.length+1];

        for(int i = 1; i < help.length; i++){
            help[i] = input[i-1];
            heapSink(help, i);//入堆
        }

        int index = help.length-1;
        while(k != 0 && index != 0){
            k--;
            res.add(help[1]);
            exch(help, 1, index--);
            heapAdjust(help, 1, index);
        }
        return res;
    }

    public static void heapAdjust(int[] arr, int parent, int length){
        int child = parent*2;
        while(child < length){
            if(child + 1 < length && arr[child+1] < arr[child]){
                child++;
            }

            if(arr[parent] < arr[child]){
                break;
            }
            exch(arr, child, parent);
            parent = child;
            child = parent*2;
        }
    }

    private static void heapSink(int[] arr, int k){
        while(k > 0 && arr[k] < arr[k/2]){
            exch(arr, k, k/2);
            k = k/2;
        }
    }

    private static void exch(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args){
        int[] arr = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = GetLeastNumbers_Solution(arr, 0);
        printArrList(res);
    }
}
