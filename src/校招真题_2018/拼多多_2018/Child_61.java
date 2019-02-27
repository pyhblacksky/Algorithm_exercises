package 校招真题_2018.拼多多_2018;

/**
 * @Author: pyh
 * @Date: 2019/2/15 15:36
 * @Version 1.0
 * @Function:
 *      2018拼多多第三题
 *      61儿童节题目
 *      对数组进行排序，然后用w数组最小分别比较
 */
import java.util.Scanner;

public class Child_61{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int h_size = scan.nextInt();
            int[] h = new int[h_size];
            for(int i = 0; i < h_size; i++){
                h[i] = scan.nextInt();
            }
            int w_size = scan.nextInt();
            int[] w = new int[w_size];
            for(int i = 0; i < w_size; i++){
                w[i] = scan.nextInt();
            }

            //排序
            quickSort(h);
            quickSort(w);

            int res = 0;

            int w_index = 0;
            int h_index = 0;
            while(w_index < w.length && h_index < h.length){
                if(w[w_index] >= h[h_index]){
                    w_index++;
                    h_index++;
                    res++;
                } else{
                    w_index++;
                }
            }
            System.out.println(res);
        }

        scan.close();

    }

    //先将两数组排序,使用快排
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
        int cur  = L;
        while(cur < more){
            if(arr[cur] < arr[R]){
                exch(arr, cur++, ++less);
            } else if(arr[cur] > arr[R]){
                exch(arr, cur, --more);
            } else{
                cur++;
            }
        }
        exch(arr, more, R);
        return new int[]{less, more};
    }

    private static void exch(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
