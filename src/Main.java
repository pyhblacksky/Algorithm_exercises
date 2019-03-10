import java.util.ArrayList;

/**
 * @Author: pyh
 * @Date: 2019/2/20 18:56
 * @Version 1.0
 * @Function:
 */
public class Main {

    private static int val = 100;

    public static void main(String[] args){
        /*
        int[] arr = new int[18];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        //查找3
        int res = binSearch(arr, 0, arr.length-1, 3);
        System.out.println(res);
        */
        int[] arr = {5,34,2,1,7,2,1,87,56,42,431,2,4,0,23,56,85};
        System.out.println(select(arr, 6));

        //quickSort(arr);
        heapSort(arr);
        printArr(arr);

    }

    //二分查找
    public static int binSearch(int[] arr, int min, int max, int target){
        if(min > max){
            return -1;
        }
        int mid = min + (max-min)/2;
        //System.out.println(mid);
        if(arr[mid] == target){
            return mid;
        } else if(arr[mid] < target){
            min = mid+1;
            return binSearch(arr, min, max, target);
        } else{
            max = mid-1;
            return binSearch(arr, min, max, target);
        }
    }

    public static void exch(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printList(ArrayList list){
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //快排划分
    public static int participate(int[] arr, int l, int h){
        int v = arr[l];
        int less = l;
        int more = h+1;
        int cur = l;
        while(cur < more){
            if(arr[cur] < v){
                exch(arr, cur++, ++less);
            } else if(arr[cur] > v){
                exch(arr, cur, --more);
            } else{
                cur++;
            }
        }
        exch(arr, less, l);
        return less;
    }
    public static void quickSort(int[] arr){
        if(arr == null){
            return;
        }
        quickSort(arr,0, arr.length-1);
    }
    private static void quickSort(int[] arr, int l, int h){
        if(l < h) {
            int j = participate(arr, l, h);
            quickSort(arr, l, j-1);
            quickSort(arr, j+1, h);
        }
    }

    //选择第k大的数
    public static int select(int[] arr, int k){
        if(k >= arr.length){
            return 0;
        }
        int l = 0;
        int h = arr.length - 1;
        while(h > l){
            int j = participate(arr, l, h);
            if(j == k){
                return arr[j];
            } else if(j > k){
                h = j - 1;
            } else{
                l = j + 1;
            }
        }
        return arr[k];
    }

    //堆排序
    public static void heapAdjust(int[] arr, int parent, int length){
        int child = parent*2;
        while(child < length){
            if(child + 1 < length && arr[child+1] < arr[child]){child++;}

            if(arr[parent] < arr[child]){
                break;
            }
            exch(arr, parent, child);
            parent = child;
            child = parent*2;
        }
    }
    public static void heapSink(int[] arr, int k){
        while(k > 0 && arr[k] < arr[k/2]){
            exch(arr, k ,k/2);
            k = k/2;
        }
    }
    public static void heapSort(int[] arr){

        int[] help = new int[arr.length+1];
        for(int i = 0; i < arr.length; i++){
            help[i+1] = arr[i];
            heapSink(help, i+1);
        }

        for(int i = help.length - 1; i >= 1; i--){
            exch(help, 1, i);
            heapAdjust(help, 1, i);
        }

        for(int i = 0; i < arr.length; i++){
            arr[i] = help[i+1];
        }

    }
}
