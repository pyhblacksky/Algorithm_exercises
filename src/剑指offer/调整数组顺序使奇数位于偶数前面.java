package 剑指offer;

import static 剑指offer.Tools.printArrInt;

/**
 * @Author: pyh
 * @Date: 2019/2/17 10:48
 * @Version 1.0
 * @Function:
 *      输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *      所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 *      思想：归并排序的修改
 */
public class 调整数组顺序使奇数位于偶数前面 {

    //归并
    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }
    private static void mergeSort(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        int mid = L + ((R-L)>>1);
        mergeSort(arr,L, mid);
        mergeSort(arr, mid+1, R);
        merge(arr, L, mid, R);

    }
    private static void merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R-L+1];
        int index = 0;
        int p1 = L;
        int p2 = mid+1;
        while(p1 <= mid && p2 <= R){
            //help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            //奇偶顺序修改
            if(arr[p1] % 2 == 0 && arr[p2] % 2 != 0){
                help[index++] = arr[p2++];
            } else{
                help[index++] = arr[p1++];
            }
        }
        while(p1 <= mid){
            help[index++] = arr[p1++];
        }
        while(p2 <= R){
            help[index++] = arr[p2++];
        }
        for(int i = 0; i < help.length; i++){
            arr[L+i] = help[i];
        }
    }

    //利用插入排序的思路
    public static void buble(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j-1] % 2 == 0 && arr[j] % 2 == 1){
                  exch(arr, j-1, j);
                }
            }
        }
    }
    public static void exch(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //另外，可以新建两个数组，一个放奇数一个放偶数，最后拷贝回原数组


    /***************************************************************************************************************/
    public static void main(String[] args){
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        buble(arr1);
        printArrInt(arr1);

    }



}
